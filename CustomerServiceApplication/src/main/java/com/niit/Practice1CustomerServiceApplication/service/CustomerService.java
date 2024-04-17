package com.niit.Practice1CustomerServiceApplication.service;

import com.niit.Practice1CustomerServiceApplication.domain.Customer;
import com.niit.Practice1CustomerServiceApplication.exception.CustomerAlreadyExistsException;
import com.niit.Practice1CustomerServiceApplication.exception.CustomerNotFoundException;

import java.util.List;

public interface CustomerService
{

    Customer saveCustomerDetail(Customer customer) throws CustomerAlreadyExistsException;
    boolean deleteCustomer(int id) throws CustomerNotFoundException;
    List<Customer> getAllCustomerDetail() throws Exception;
    List<Customer> getCustomersByProductName(String productName) throws Exception;


}
