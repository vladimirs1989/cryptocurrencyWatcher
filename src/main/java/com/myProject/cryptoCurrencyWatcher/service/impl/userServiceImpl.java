package com.myProject.cryptoCurrencyWatcher.service.impl;

import com.myProject.cryptoCurrencyWatcher.repository.PriceBTCRepository;
import com.myProject.cryptoCurrencyWatcher.repository.UserRepository;
import com.myProject.cryptoCurrencyWatcher.repository.entity.User;
import com.myProject.cryptoCurrencyWatcher.service.PriceBTCService;
import com.myProject.cryptoCurrencyWatcher.service.PriceETHService;
import com.myProject.cryptoCurrencyWatcher.service.PriceSOLService;
import com.myProject.cryptoCurrencyWatcher.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service("userService")
@Transactional
public class userServiceImpl implements UserService {

    private UserRepository userRepository;
    private PriceBTCService priceBTCService;
    private PriceETHService priceETHService;
    private PriceSOLService priceSOLService;

    @Autowired
    public userServiceImpl(UserRepository userRepository,
                           PriceBTCService priceBTCService,
                           PriceETHService priceETHService,
                           PriceSOLService priceSOLService) {
        this.userRepository = userRepository;
        this.priceBTCService = priceBTCService;
        this.priceETHService = priceETHService;
        this.priceSOLService = priceSOLService;
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
}
