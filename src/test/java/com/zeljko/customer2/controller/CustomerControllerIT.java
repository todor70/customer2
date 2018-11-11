package com.zeljko.customer2.controller;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import com.zeljko.customer2.Customer2Application;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Customer2Application.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.JVM)
public class CustomerControllerIT {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

    }

    @Test
    public void verifyWacAndServletContextProvidesCustomerController() {
        ServletContext servletContext = wac.getServletContext();

        Assert.assertNotNull(servletContext);
        Assert.assertTrue(servletContext instanceof MockServletContext);
        Assert.assertNotNull(wac.getBean("customerController"));
    }

    @Test
    public void verifyList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/customers/")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2))).andDo(print());
    }

    @Test
    public void verifyRead() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/customers/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.firstName").exists())
                .andExpect(jsonPath("$.lastName").exists())
                .andExpect(jsonPath("$.email").exists())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.firstName").value("marko"))
                .andExpect(jsonPath("$.lastName").value("markovic"))
                .andExpect(jsonPath("$.email").value("marko@gmail.com"))
                .andDo(print());
    }

    @Test
    public void verifyCreate() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/customers/")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"firstName\" : \"nemanja\", \"lastName\" : \"nemanjic\", \"email\" : \"nemanja@gmail.com\" }")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.firstName").exists())
                .andExpect(jsonPath("$.lastName").exists())
                .andExpect(jsonPath("$.email").exists())
                .andExpect(jsonPath("$.id").value(3))
                .andExpect(jsonPath("$.firstName").value("nemanja"))
                .andExpect(jsonPath("$.lastName").value("nemanjic"))
                .andExpect(jsonPath("$.email").value("nemanja@gmail.com"))
                .andDo(print());
    }

    @Test
    public void verifyPut() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/customers/2")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"firstName\" : \"pera\", \"lastName\" : \"peric\", \"email\" : \"petar@gmail.com\" }")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.firstName").exists())
                .andExpect(jsonPath("$.lastName").exists())
                .andExpect(jsonPath("$.email").exists())
                .andExpect(jsonPath("$.id").value(2))
                .andExpect(jsonPath("$.firstName").value("pera"))
                .andExpect(jsonPath("$.lastName").value("peric"))
                .andExpect(jsonPath("$.email").value("petar@gmail.com"))
                .andDo(print());
    }

    @Test
    public void verifyPatch() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.patch("/customers/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"lastName\" : \"maric\", \"email\" : \"mare@gmail.com\" }")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.firstName").exists())
                .andExpect(jsonPath("$.lastName").exists())
                .andExpect(jsonPath("$.email").exists())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.firstName").value("marko"))
                .andExpect(jsonPath("$.lastName").value("maric"))
                .andExpect(jsonPath("$.email").value("mare@gmail.com"))
                .andDo(print());
    }

}