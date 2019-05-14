package com.ipiecoles.java.java240;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;

@SpringBootApplication
public class SpringConfig {

    //beans
    @Value("${bitcoinService.forceRefresh}")
    Boolean forceRefresh;

    @Bean(name = "bitcoinServiceWithoutCache")
    @Qualifier("WithoutCache")
    @Scope("singleton")//Facultatif car scope singleton par défaut
    public BitcoinService bitcoinServiceWithoutCache() {
        BitcoinService bitcoinService = new BitcoinService();
        bitcoinService.setForceRefresh(forceRefresh);
        return bitcoinService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringConfig.class, args);
    }
}
