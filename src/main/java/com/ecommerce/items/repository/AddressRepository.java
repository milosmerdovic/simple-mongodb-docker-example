package com.ecommerce.items.repository;

import com.ecommerce.items.resource.Address;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AddressRepository extends MongoRepository<Address, Long> {

}
