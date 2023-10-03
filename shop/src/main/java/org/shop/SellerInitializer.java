package org.shop;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.shop.Profiler.Profiling;
import org.shop.api.SellerService;
import org.shop.data.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PostConstruct;

/**
 * The Seller Initializer util class.
 */

@PropertySource("classpath:config.properties")
public class SellerInitializer {
    Logger logger = Logger.getLogger(SellerInitializer.class);

    /** The seller service. */
    @Autowired
    private SellerService sellerService;
    
    /** The seller names.
     */

    @Value("#{${sellerMapName}}")
    private Map<Long, String> sellerNames;


    /**
     * Inits the sellers.
     */
    @PostConstruct
    public void initSellers() {
        logger.info("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!sellerNames.entrySet="+sellerNames.entrySet().toString());
        List<Seller> sellers = new LinkedList<Seller>();
        for (Map.Entry<Long, String> entry : sellerNames.entrySet()) {
            Seller seller = new Seller();
            seller.setId(entry.getKey());
            seller.setName(entry.getValue());
            sellers.add(seller);
        }
        sellerService.importSellers(sellers);
    }
}
