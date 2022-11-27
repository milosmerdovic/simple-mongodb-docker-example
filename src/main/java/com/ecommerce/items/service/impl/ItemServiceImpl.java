package com.ecommerce.items.service.impl;

import com.ecommerce.items.common.ServiceResponse;
import com.ecommerce.items.dto.ItemDto;
import com.ecommerce.items.exceptions.ItemNotFoundException;
import com.ecommerce.items.mapper.ItemMapper;
import com.ecommerce.items.repository.ItemsRepository;
import com.ecommerce.items.resource.Item;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class ItemServiceImpl {

    @Autowired
    ItemsRepository repository;
    @Autowired
    ItemMapper itemMapper;

    @Transactional
    public ServiceResponse<List<ItemDto>> getAllItems(Pageable paging) {
        Page<Item> item = repository.findAll(paging);
        List<ItemDto> itemDto = itemMapper.toDto(item);
        return ServiceResponse.<List<ItemDto>>builder().payload(itemDto).total(item.getTotalElements()).build();
    }
    @Transactional
    public ServiceResponse<List<ItemDto>> getAllItemsByCategory(String category, Pageable paging) {
        Page<Item> items = repository.findByCategory(category, paging);
        List<ItemDto> itemsByCategory = itemMapper.toDto(items);
        return ServiceResponse.<List<ItemDto>>builder().payload(itemsByCategory)
                                                       .total(itemsByCategory.size())
                                                       .build();
    }

    @Transactional
    public ServiceResponse<Item> getItemById(long id) {
        Item item = repository.findByItemId(id);
        if (item != null) {
            return ServiceResponse.<Item>builder().payload(item).build();
        }
        return ServiceResponse.<Item>builder().payload(null).build();
    }
    @Transactional
    public ServiceResponse<Item> createItem(ItemDto itemDto) {
        Item item = new Item();
        item = itemMapper.toEntity(itemDto);
        repository.save(item);
        return ServiceResponse.<Item>builder().payload(item).build();
    }
    @Transactional
    public ServiceResponse<Item> updateItem(ItemDto itemDto) throws ItemNotFoundException{
        Item item = repository.findByItemId(itemDto.getItemId());
        if (item != null) {
            item = itemMapper.toEntity(itemDto);
            repository.save(item);
            return ServiceResponse.<Item>builder().payload(item).build();
        } throw new ItemNotFoundException("Item with id " + item.getItemId() + " cant be found");
    }

    @Transactional
    public void removeItem(long id) throws ItemNotFoundException {
        Item item = repository.findByItemId(id);
        try {
            if (item != null) {
                repository.delete(item);
            }
        } catch (Exception e) {
            throw new ItemNotFoundException("Item with id " + id + " can not be found");
        }
    }

}
