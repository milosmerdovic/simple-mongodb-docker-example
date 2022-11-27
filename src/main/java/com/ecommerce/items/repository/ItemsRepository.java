package com.ecommerce.items.repository;

import com.ecommerce.items.resource.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ItemsRepository extends MongoRepository<Item, Long> {
    Page<Item> findByCategory(String category, Pageable paging);
    Item findByItemId(long id);
}
