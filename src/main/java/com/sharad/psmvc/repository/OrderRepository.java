package com.sharad.psmvc.repository;

import java.util.List;

import com.sharad.psmvc.domain.Account;
import com.sharad.psmvc.domain.Order;

/**
 * Repository for working with {@link Order} domain objects
 *  
 * @author Marten Deinum
 * @author Koen Serneels
 *
 */
public interface OrderRepository {

    /**
     * Find the {@link Order} for the given id.
     * 
     * @param id id of the order to find.
     * @return the order belonging to the id.
     */
    Order findById(long id);

    /**
     * Save the order in the databse.
     */
    Order save(Order order);

    /**
     * Find the orders for the given {@link Account}.
     * @param customer the account
     * @return list of orders for the account, never <code>null</code>
     */
    List<Order> findByAccount(Account account);

}
