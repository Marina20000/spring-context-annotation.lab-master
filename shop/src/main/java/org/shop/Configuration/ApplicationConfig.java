package org.shop.Configuration;

import org.shop.Profiler.ProfilingHandlerBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Created by Marina_Voronetckaia on 8/10/2017.
 */
@Import({FactoryConfig.class,InitiliazerConfig.class, RepositoryConfig.class, ServiceConfig.class})

@Configuration
public class ApplicationConfig {
    @Bean
    public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public ProfilingHandlerBeanPostProcessor profilingHandlerBeanPostProcessor(){
        return new ProfilingHandlerBeanPostProcessor();
    }


}
