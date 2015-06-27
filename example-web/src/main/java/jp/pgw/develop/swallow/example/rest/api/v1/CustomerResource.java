package jp.pgw.develop.swallow.example.rest.api.v1;

import jp.pgw.develop.swallow.example.model.domain.Customer;
import jp.pgw.develop.swallow.example.service.CustomerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.inject.Inject;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

/**
 * Created by kazamage on 2015/06/28.
 */
@RestController
@RequestMapping("/customers")
public class CustomerResource {

    private final CustomerService customerService;

    @Inject
    public CustomerResource(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Customer getCustomer(@PathVariable Long id) {
        return customerService.getCustomer(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer,
                                                   UriComponentsBuilder uriBuilder) {
        final Customer created = customerService.save(customer);
        final URI location = uriBuilder.path("/customers/{id}")
                .buildAndExpand(created.getId()).toUri();
        final HttpHeaders headers = new HttpHeaders();
        headers.setLocation(location);
        return new ResponseEntity<>(created, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Customer updateCustomer(@PathVariable Long id,
                                   @RequestBody Customer customer) {
        customer.setId(id);
        return customerService.save(customer);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeCustomer(@PathVariable Long id) {
        customerService.remove(id);
    }

}
