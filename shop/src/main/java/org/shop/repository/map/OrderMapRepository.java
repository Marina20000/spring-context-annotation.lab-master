package org.shop.repository.map;

import org.apache.commons.collections.Predicate;
import org.shop.data.Order;
import org.shop.repository.OrderRepository;

import java.util.List;

/**
 * The Class OrderMapRepository.
 * 
 * @author Dzmitry_Naskou
 */

public class OrderMapRepository extends AbstractMapRepository<Order> implements OrderRepository {

    public void setSequence(long sequence) {
        super.sequence = sequence;
    }
    
    /* (non-Javadoc)
     * @see org.shop.repository.OrderRepository#getOrderById(java.lang.Long)
     */
    @Override
    public Order getOrderById(Long id) {
        return get(id);
    }

    /* (non-Javadoc)
     * @see org.shop.repository.OrderRepository#createOrder(org.shop.data.Order)
     */
    @Override
    public Long createOrder(Order order) {
        return create(order);
    }

    /* (non-Javadoc)
     * @see org.shop.repository.OrderRepository#updateOrder(org.shop.data.Order)
     */
    @Override
    public void updateOrder(Order order) {
        update(order);
    }

    /* (non-Javadoc)
     * @see org.shop.repository.OrderRepository#getOrdersByUserId(java.lang.Long)
     */
    @Override
    public List<Order> getOrdersByUserId(Long userId) {
        return select(new OrderByUserPredicate(userId));
    }
    
    /**
     * The Class OrderByUserPredicate.
     */
    private class OrderByUserPredicate implements Predicate {
        
        /** The user id. */
        private Long userId;

        /**
         * Instantiates a new order by user predicate.
         *
         * @param userId the user id
         */
        private OrderByUserPredicate(Long userId) {
            super();
            this.userId = userId;
        }

        /* (non-Javadoc)
         * @see org.apache.commons.collections.Predicate#evaluate(java.lang.Object)
         */
        @Override
        public boolean evaluate(Object input) {
            if (input instanceof Order) {
                Order order = (Order)input;
                
                return userId.equals(order.getUser().getId());
            }
            
            return false;
        }
    }
}
