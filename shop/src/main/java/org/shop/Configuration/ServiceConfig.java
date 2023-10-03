package org.shop.Configuration;

import org.shop.api.*;
import org.shop.api.impl.*;
import org.shop.repository.ItemRepository;
import org.shop.repository.ProductRepository;
import org.shop.repository.ProposalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Marina_Voronetckaia on 8/10/2017.
 */
@Configuration
public class ServiceConfig {
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private  ProductRepository productRepository;

    @Autowired
    private ProposalRepository proposalRepository;



    @Bean
    ItemService itemService(){
        return new ItemServiceImpl(itemRepository);
    }

    @Bean
    OrderService orderService(){
        return new OrderServiceImpl();
    }

    @Bean(name="productService")
    ProductService productService(){
        return new ProductServiceImpl(productRepository);
    }

    @Bean
    ProposalService proposalService(){
        return new ProposalServiceImpl(proposalRepository);
    }

    @Bean
    public SellerService sellerService(){
        return new SellerServiceImpl();
    }

    @Bean
    public UserService userService(){
        return new UserServiceImpl();
    }
}
