package org.shop;

import org.apache.log4j.Logger;
import org.shop.api.SellerService;
import org.shop.data.Seller;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * The Seller Initializer util class.
 */

public class SellerInitializer {
    Logger logger = Logger.getLogger(SellerInitializer.class);

    /** The seller service. */
    private SellerService sellerService;
    
    /** The seller names.
     */

    private Map<Long, String> sellerNames;


    /**
     * Inits the sellers.
     */
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
