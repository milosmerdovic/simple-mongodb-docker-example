package com.ecommerce.items.repository;

import com.ecommerce.items.resource.Store;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StoreRepository extends MongoRepository<Store, Long> {

}
