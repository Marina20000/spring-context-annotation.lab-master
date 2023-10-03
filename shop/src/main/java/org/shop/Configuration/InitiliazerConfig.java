package org.shop.Configuration;

import org.apache.log4j.Logger;
import org.shop.*;
import org.shop.api.ProductService;
import org.shop.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

/**
 * Created by Marina_Voronetckaia on 8/10/2017.
 */
@Configuration
public class InitiliazerConfig {
    private static final Logger logger = Logger.getLogger(InitiliazerConfig.class);

    @Bean(initMethod = "initData")
    public DataInitializer dataInitializer(){
        logger.info("dataInitializer");
        return new DataInitializer();
    }

    @Bean
    public SellerInitializer sellerInitializer(){
        logger.info("sellerInitializer");
        return new SellerInitializer();
    }

    @Bean(initMethod = "initProposals")
    @DependsOn("productInitializer")
    public ProposalInitializer proposalInitializer(){
        logger.info("proposalInitializer");
        return new ProposalInitializer();
    }

    @Autowired
    private ProductService productService;
    @Bean(name="productInitializer",initMethod = "initProducts")
    public ProductInitializer productInitializer(){
        logger.info("productInitializer");
        return new ProductInitializer(productService);
    }

    @Autowired
    private UserService userService;
    @Bean(initMethod = "initUsers")
    public UserInitializer userInitializer(){
        logger.info("userInitializer");
        return new UserInitializer(userService);
    }


}
/*
    a. SellerInitializer: требуется параметр типа Map<sellerId, sellerName>

    b. ProposalInitializer: использовать autowiring by name

    c. ProductInitializer: передать параметры в конструктор

    d. DataInitializer: объявить init метод
*/