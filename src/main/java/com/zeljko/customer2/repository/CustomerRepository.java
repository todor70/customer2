package com.zeljko.customer2.repository;

import com.zeljko.customer2.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {

}
