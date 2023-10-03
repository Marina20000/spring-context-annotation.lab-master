package org.shop;


import org.apache.log4j.Logger;
import org.shop.Configuration.ApplicationConfig;
import org.shop.Configuration.InitiliazerConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.Map;

/**
 * The ShopLauncher class.
 */
public class ShopLauncher {
    private static final Logger logger = Logger.getLogger(ShopLauncher.class);
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        Map<String, DataInitializer> beansOfType = ctx.getBeansOfType(DataInitializer.class);
        logger.info("gets beans by type "+beansOfType.toString());
    }
}
