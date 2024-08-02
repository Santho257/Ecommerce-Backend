package com.santho.ecommerce.repositories;

import com.santho.ecommerce.models.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<Customer,String > {
}
