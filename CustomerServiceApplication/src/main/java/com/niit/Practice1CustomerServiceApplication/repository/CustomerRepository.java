package com.niit.Practice1CustomerServiceApplication.repository;

import com.niit.Practice1CustomerServiceApplication.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer, Integer>
{

    @Query("{'customerProduct.productName' : {$in : [?0]}}")
    List<Customer> findByproductName(String productName);

}
