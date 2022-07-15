package com.myProject.cryptoCurrencyWatcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CryptoCurrencyWatcherApplication {

	public static void main(String[] args) {
		SpringApplication.run(CryptoCurrencyWatcherApplication.class, args);


	}

}
