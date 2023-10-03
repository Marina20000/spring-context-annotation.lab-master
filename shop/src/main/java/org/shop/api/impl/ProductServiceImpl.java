package org.shop.api.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.shop.Profiler.Profiling;
import org.shop.api.ProductService;
import org.shop.data.Product;
import org.shop.repository.ProductRepository;
@Profiling
public class ProductServiceImpl implements ProductService {
    private static final Logger logger = Logger.getLogger(ProductService.class);

    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        super();
        this.repository = repository;
    }
    
    /* (non-Javadoc)
     * @see org.shop.api.ProductService#getProductById(java.lang.Long)
     */
    @Override
    public Product getProductById(Long id) {
        return repository.getProductById(id);
    }

    /* (non-Javadoc)
     * @see org.shop.api.ProductService#getProducts()
     */
    @Override
    public List<Product> getProducts() {
        return repository.getProducts();
    }

    /* (non-Javadoc)
     * @see org.shop.api.ProductService#getProductsByName(java.lang.String)
     */
    @Override
    public List<Product> getProductsByName(String name) {
        logger.info("ProductService getProductsByName"+ name);
        return repository.getProductsByName(name);
    }

    /* (non-Javadoc)
     * @see org.shop.api.ProductService#createProduct(org.shop.data.Product)
     */
    @Override
    public Long createProduct(Product product) {
        return repository.createProduct(product);
    }

    /* (non-Javadoc)
     * @see org.shop.api.ProductService#updateProduct(org.shop.data.Product)
     */
    @Override
    public void updateProduct(Product product) {
        repository.updateProduct(product);
    }

    /* (non-Javadoc)
     * @see org.shop.api.ProductService#deleteProduct(java.lang.Long)
     */
    @Override
    public void deleteProduct(Long productId) {
        repository.deleteProduct(productId);
    }
}
