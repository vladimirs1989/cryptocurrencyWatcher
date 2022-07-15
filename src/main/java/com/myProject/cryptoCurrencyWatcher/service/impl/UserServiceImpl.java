package com.myProject.cryptoCurrencyWatcher.service.impl;

import com.myProject.cryptoCurrencyWatcher.repository.UserRepository;
import com.myProject.cryptoCurrencyWatcher.repository.entity.User;
import com.myProject.cryptoCurrencyWatcher.service.PriceBTCService;
import com.myProject.cryptoCurrencyWatcher.service.PriceETHService;
import com.myProject.cryptoCurrencyWatcher.service.PriceSOLService;
import com.myProject.cryptoCurrencyWatcher.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;
    private final PriceBTCService priceBTCService;
    private final PriceETHService priceETHService;
    private final PriceSOLService priceSOLService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           PriceBTCService priceBTCService,
                           PriceETHService priceETHService,
                           PriceSOLService priceSOLService) {
        this.userRepository = userRepository;
        this.priceBTCService = priceBTCService;
        this.priceETHService = priceETHService;
        this.priceSOLService = priceSOLService;
    }

    @Override
    public Iterable<User> findAll() {
        Iterable<User> users = userRepository.findAll();
        List<User> userList = new ArrayList<>();
        users.forEach(userList::add);
        return userList;
    }

    @Override
    public List<User> findBySymbol(String symbol) {
        List<User> users = userRepository.findBySymbol(symbol);
        return users;
    }

    @Override
    public User createUser(User user) {
        User newUser = new User();
        newUser.setUserName(user.getUserName());
        newUser.setUserChoseSymbol(user.getUserChoseSymbol());
        if (Objects.equals(user.getUserChoseSymbol(), "BTC")) {
            newUser.setPriceCurrency(priceBTCService.getPriceBTC());
        } else if (Objects.equals(user.getUserChoseSymbol(), "ETH")) {
            newUser.setPriceCurrency(priceETHService.getPriceETH());
        } else {
            newUser.setPriceCurrency(priceSOLService.getPriceSOL());
        }
        return userRepository.save(newUser);
    }

    @Scheduled(fixedDelay = 60 * 1000)
    public void changePrice() {
        Iterable<User> users = findAll();
        for (User user : users) {
            BigDecimal oldPrice = user.getPriceCurrency();
            BigDecimal newPrice;
            if (Objects.equals(user.getUserChoseSymbol(), "BTC")) {
                newPrice = priceBTCService.getPriceBTC();
            } else if (Objects.equals(user.getUserChoseSymbol(), "ETH")) {
                newPrice = priceETHService.getPriceETH();
            } else {
                newPrice = priceSOLService.getPriceSOL();
            }
            if ((oldPrice.multiply(new BigDecimal("0.99")).compareTo(newPrice) >= 0) ||
                    (oldPrice.multiply(new BigDecimal("1.01")).compareTo(newPrice) <= 0)) {

                logger.warn("WARN " + user.getUserChoseSymbol() + " " + user.getUserName() + " " + "% - did not have time");
            }
        }
    }
}
