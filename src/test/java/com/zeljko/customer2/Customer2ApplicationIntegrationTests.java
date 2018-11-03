package com.zeljko.customer2;

import com.zeljko.customer2.entity.Customer;
import com.zeljko.customer2.repository.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Customer2ApplicationIntegrationTests {

	@Autowired
	private CustomerRepository customerRepository;

	@Test
	public void testFindCustomerById() throws Exception{
		Customer customer = customerRepository.findById(1L).get();
		assertEquals("marko", customer.getFirstName());
		assertEquals("markovic", customer.getLastName());
		assertEquals("marko@gmail.com", customer.getEmail());
	}

}
