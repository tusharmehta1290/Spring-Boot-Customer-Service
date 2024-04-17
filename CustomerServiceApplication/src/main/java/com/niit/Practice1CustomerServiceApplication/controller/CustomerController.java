package com.niit.Practice1CustomerServiceApplication.controller;

import com.niit.Practice1CustomerServiceApplication.domain.Customer;
import com.niit.Practice1CustomerServiceApplication.exception.CustomerAlreadyExistsException;
import com.niit.Practice1CustomerServiceApplication.exception.CustomerNotFoundException;
import com.niit.Practice1CustomerServiceApplication.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class CustomerController
{

    private ResponseEntity responseEntity;
    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/customer")
    ResponseEntity saveCustomer(@RequestBody Customer customer) throws CustomerAlreadyExistsException
    {
        try
        {
            customerService.saveCustomerDetail(customer);
            responseEntity = new ResponseEntity(customer, HttpStatus.CREATED);
        }
        catch (CustomerAlreadyExistsException e) {
            throw new CustomerAlreadyExistsException();
        }
        catch (Exception e) {
            responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @DeleteMapping("/customer/{customerId}")
    public ResponseEntity deleteCustomer(@PathVariable int customerId) throws CustomerNotFoundException
    {
        try
        {
            customerService.deleteCustomer(customerId);
            responseEntity = new ResponseEntity("Successfully Deleted !!", HttpStatus.OK);
        }
        catch (CustomerNotFoundException e)
        {
            throw new CustomerNotFoundException();
        }
        catch (Exception exception)
        {
            responseEntity = new ResponseEntity(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @GetMapping("/customers")
    public ResponseEntity getAllCustomer()
    {
        try
        {
            responseEntity = new ResponseEntity(customerService.getAllCustomerDetail(), HttpStatus.FOUND);
        }
        catch (Exception e) {
            responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
    }

    @GetMapping("/customers/{productName}")
    public ResponseEntity getAllProductByName(@PathVariable String productName)
    {
        try
        {
            responseEntity = new ResponseEntity(customerService.getCustomersByProductName(productName), HttpStatus.FOUND);
        }
        catch (Exception e)
        {
            responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }


}
