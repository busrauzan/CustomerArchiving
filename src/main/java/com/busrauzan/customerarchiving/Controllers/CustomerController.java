package com.busrauzan.customerarchiving.Controllers;

import com.busrauzan.customerarchiving.DataAccess.CustomerRepository;
import com.busrauzan.customerarchiving.Entities.Customer;
import com.busrauzan.customerarchiving.ExceptionMessages.ResourceNotFoundException;
import com.busrauzan.customerarchiving.Utils.Constants;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping(path = "/customers")
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping(path = "/customer/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable(value = "id") Long customerId)
            throws NotFoundException, ResourceNotFoundException {
        final Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException(Constants.ERR_MSG_CUSTOMER + customerId));
        return ResponseEntity.ok().body(customer);
    }

    @PostMapping(path = "/customer")
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @PutMapping(path = "/customer/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable(value = "id") Long customerId,
                                                   @RequestBody Customer updatedCustomer) throws ResourceNotFoundException {
        final Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException(Constants.ERR_MSG_CUSTOMER + customerId));
        updatedCustomer.setId(customer.getId());
        return ResponseEntity.ok().body(customerRepository.save(updatedCustomer));

    }

    @DeleteMapping(path = "/customer/{id}")
    public Map<String, Boolean> deleteCustomer(@PathVariable(value = "id") Long customerId)
            throws ResourceNotFoundException {
        final Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException(Constants.ERR_MSG_CUSTOMER + customerId));
        customerRepository.delete(customer);
        Map<String, Boolean> response = new HashMap<>();
        response.put(Constants.DELETED, Boolean.TRUE);
        return response;
    }

}
