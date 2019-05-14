package com.ipiecoles.java.java240;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = "com.ipiecoles")
@PropertySource("classpath:application.properties")
public class SpringConfig {
    //beans
    @Value("${bitcoinService.forceRefresh}")
    Boolean forceRefresh;

    @Bean(name = "bitcoinServiceWithoutCache")
    @Scope("singleton")//Facultatif car scope singleton par défaut
    public BitcoinService bitcoinServiceWithoutCache() {
        BitcoinService bitcoinService = new BitcoinService();
        bitcoinService.setForceRefresh(forceRefresh);
        return bitcoinService;
    }

    @Bean(name = "bitcoinServiceWithCache")
    @Scope("singleton")//Facultatif car scope singleton par défaut
    public BitcoinService bitcoinServiceWithCache() {
        BitcoinService bitcoinService = new BitcoinService();
        bitcoinService.setForceRefresh(false);
        return bitcoinService;
    }
}
