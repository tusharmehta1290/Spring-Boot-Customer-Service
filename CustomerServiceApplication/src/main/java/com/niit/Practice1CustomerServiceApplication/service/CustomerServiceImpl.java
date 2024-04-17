package com.niit.Practice1CustomerServiceApplication.service;

import com.niit.Practice1CustomerServiceApplication.domain.Customer;
import com.niit.Practice1CustomerServiceApplication.exception.CustomerAlreadyExistsException;
import com.niit.Practice1CustomerServiceApplication.exception.CustomerNotFoundException;
import com.niit.Practice1CustomerServiceApplication.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService
{

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer saveCustomerDetail(Customer customer) throws CustomerAlreadyExistsException {
        if (customerRepository.findById(customer.getCustomerId()).isPresent()) {
            throw new CustomerAlreadyExistsException();
        }
        return customerRepository.save(customer);
    }

    @Override
    public boolean deleteCustomer(int id) throws CustomerNotFoundException {
        boolean flag = false;
        if (customerRepository.findById(id).isEmpty()) {
            throw new CustomerNotFoundException();
        } else {
            customerRepository.deleteById(id);
            flag = true;
        }
        return flag;
    }

    @Override
    public List<Customer> getAllCustomerDetail() throws Exception {
        return customerRepository.findAll();
    }

    @Override
    public List<Customer> getCustomersByProductName(String productName) throws Exception {
        if (customerRepository.findByproductName(productName).isEmpty()) {
            throw new CustomerNotFoundException();
        }
        return customerRepository.findByproductName(productName);
    }


}
