package org.shop.Configuration;

import org.apache.log4j.Logger;
import org.shop.repository.*;
import org.shop.repository.factory.UserRepositoryFactory;
import org.shop.repository.map.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;

/**
 * Created by Marina_Voronetckaia on 8/10/2017.
 */
@Configuration
@PropertySource("classpath:config.properties")
public class RepositoryConfig {
    Logger logger = Logger.getLogger(RepositoryConfig.class);


    @Bean
    public ItemRepository itemRepository(){
        return new ItemMapRepository();
    }

    @Value("${intitialSequence}")
    private Long intitialSequence;

    @Bean
    public OrderRepository orderRepository(){
        OrderMapRepository orderMapRepository = new OrderMapRepository();
        orderMapRepository.setSequence(intitialSequence);
        logger.info("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+intitialSequence);
        return orderMapRepository;
    }

    @Bean
    public ProductRepository productRepository(){
        return new ProductMapRepository();
    }

    @Bean
    public ProposalRepository proposalRepository(){
        return  new ProposalMapRepository();
    }

    @Bean
    public SellerRepository sellerRepository(){
        return new SellerMapRepository();
    }

    @Bean
    public UserRepository userRepository(){
        return new UserRepositoryFactory().createUserRepository();
    }
}

/*
 a)Для создания UserRepository использовать класс org.shop.repository.factory.UserRepositoryFactory и соответствующий factory method
 b)Для создания OrderRepository необходимо передать параметр intitialSequence, значение которого должно быть взято из property файла.
 */