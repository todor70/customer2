package com.zeljko.customer2.controller;

import com.zeljko.customer2.entity.Customer;
import com.zeljko.customer2.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping( value = "/", method = RequestMethod.GET )
    public Iterable<Customer> list(){
        return customerService.list();
    }

    @RequestMapping( value = "/", method = RequestMethod.POST )
    public Customer create(@RequestBody Customer customer){
        return customerService.create(customer);
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.GET )
    public Customer read(@PathVariable(value="id") long id){
        return customerService.read(id);
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.PUT )
    public Customer update(@PathVariable(value="id") long id, @RequestBody Customer customer){
        return customerService.update(id, customer);
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.PATCH )
    public Customer patch(@PathVariable(value="id") long id, @RequestBody Customer customer){
        return customerService.patch(id, customer);
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.DELETE )
    public void delete(@PathVariable(value="id") long id){
        customerService.delete(id);
    }

}
