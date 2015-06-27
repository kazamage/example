package jp.pgw.develop.swallow.example.service.impl;

import jp.pgw.develop.swallow.example.model.domain.Customer;
import jp.pgw.develop.swallow.example.persistence.repository.CustomerRepository;
import jp.pgw.develop.swallow.example.service.CustomerService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by kazamage on 2015/06/28.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Inject
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Customer getCustomer(Long id) {
        return customerRepository.findOne(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Customer save(final Customer customer) {
        return customerRepository.save(customer);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void remove(final Long id) {
        customerRepository.delete(id);
    }

}
