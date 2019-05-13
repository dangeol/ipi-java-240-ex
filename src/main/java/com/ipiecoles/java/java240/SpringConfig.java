package com.ipiecoles.java.java240;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class SpringConfig {
    //beans

    @Bean(name = "bitcoinServiceWithoutCache")
    @Scope("singleton")//Facultatif car scope singleton par défaut
    public BitcoinService bitcoinServiceWithoutCache() {
        BitcoinService bitcoinService = new BitcoinService();
        bitcoinService.setForceRefresh(true);
        bitcoinService.setWebPageManager(webPageManager());
        return bitcoinService;
    }

    @Scope("singleton")//Facultatif car scope singleton par défaut
    public BitcoinService bitcoinServiceWithCache() {
        BitcoinService bitcoinService = new BitcoinService();
        bitcoinService.setForceRefresh(false);
        bitcoinService.setWebPageManager(webPageManager());

        return bitcoinService;
    }

    @Bean
    public WebPageManager webPageManager() {
        WebPageManager webPageManager = new WebPageManager();
        return webPageManager;
    }

    @Bean(initMethod = "initialiserCatalogue")
    public ProduitManager produitManager() {
        ProduitManager produitManager = new ProduitManager();
        produitManager.setWebPageManager(webPageManager());
        produitManager.setBitcoinService(bitcoinServiceWithCache());
        return produitManager;
    }
}
