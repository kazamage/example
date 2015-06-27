package jp.pgw.develop.swallow.example.service;

import jp.pgw.develop.swallow.example.model.domain.Customer;

import java.util.List;

/**
 * Created by kazamage on 2015/06/28.
 */
public interface CustomerService {
    List<Customer> getCustomers();

    Customer getCustomer(Long id);

    Customer save(Customer customer);

    void remove(Long id);
}
