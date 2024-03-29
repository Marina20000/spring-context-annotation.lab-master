package org.shop.repository.map;

import org.apache.commons.collections.Predicate;
import org.apache.log4j.Logger;
import org.shop.data.Product;
import org.shop.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductMapRepository extends AbstractMapRepository<Product> implements ProductRepository {
    private static final Logger logger = Logger.getLogger(ProductRepository.class);
    @Override
    public Product getProductById(Long productId) {
        return get(productId);
    }
    
    @Override
    public List<Product> getProducts() {
        return new ArrayList<Product>(register.values());
    }
    
    @Override
    public List<Product> getProductsByName(String name) {
        logger.info("ProductRepository getProductsByName"+name);
        return select(new ProductByNamePredicate(name));
    }

    @Override
    public Long createProduct(Product product) {
        return create(product);
    }

     @Override
    public void updateProduct(Product product) {
        update(product);
    }
    
    @Override
    public void deleteProduct(Long productId) {
        delete(productId);
    }
    
    private class ProductByNamePredicate implements Predicate {
        private String name;

        private ProductByNamePredicate(String name) {
            super();
            logger.info("select ProductByNamePredicate"+name);
            this.name = name;
        }

        @Override
        public boolean evaluate(Object input) {
            if (input instanceof Product) {
                Product product = (Product)input;
                return name.equalsIgnoreCase(product.getName());
            }
            return false;
        }
    }
}
