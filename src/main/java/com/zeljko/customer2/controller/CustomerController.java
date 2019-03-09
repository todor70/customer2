package com.zeljko.customer2.controller;

import com.zeljko.customer2.entity.Customer;
import com.zeljko.customer2.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/")
    public Iterable<Customer> list(){
        return customerService.list();
    }

    @PostMapping("/")
    public Customer create(@RequestBody Customer customer){
        return customerService.create(customer);
    }

    @GetMapping("/{id}")
    public Customer read(@PathVariable String id){
        return customerService.read(id);
    }

    @PutMapping("/{id}")
    public Customer update(@PathVariable String id, @RequestBody Customer customer){
        return customerService.update(id, customer);
    }

    @PatchMapping("/{id}")
    public Customer patch(@PathVariable String id, @RequestBody Customer customer){
        return customerService.patch(id, customer);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        customerService.delete(id);
    }

}
