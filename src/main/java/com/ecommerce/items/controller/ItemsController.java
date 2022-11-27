package com.ecommerce.items.controller;

import com.ecommerce.items.common.ApiResponse;
import com.ecommerce.items.common.ServiceResponse;
import com.ecommerce.items.dto.ItemDto;
import com.ecommerce.items.exceptions.ItemNotFoundException;
import com.ecommerce.items.resource.Item;
import com.ecommerce.items.service.impl.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemsController {
    @Autowired
    ItemServiceImpl service;

    @GetMapping( produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<ApiResponse<List<ItemDto>>> getAllItems(@RequestParam(defaultValue = "0", required = false)Integer pageNo,
                                                                  @RequestParam(defaultValue = "20", required = false) Integer pageSize,
                                                                  @RequestParam(defaultValue = "itemId", required = false) String sortBy,
                                                                  @RequestParam(defaultValue = "ASC", required = false) String sortDirection){
        Sort.Direction sortDir = sortDirection.equalsIgnoreCase("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Pageable paging = PageRequest.of(pageNo, pageSize, sortDir, sortBy);
        ServiceResponse<List<ItemDto>> response = service.getAllItems(paging);
        return ResponseEntity.ok(ApiResponse.<List<ItemDto>>builder()
                                            .operationResultCode(HttpStatus.OK.value())
                                            .operationResultDescription("Fetched all items")
                                            .totalObjectNumber(response.getTotal())
                                            .returnedObjectNumber(response.getPayload().size())
                                            .payload(response.getPayload())
                                            .build());
    }

    @GetMapping(value = "categories/{category}",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<ApiResponse<List<ItemDto>>> getAllItemsByCategory(@PathVariable String category,
                                                                  @RequestParam(defaultValue = "0", required = false)Integer pageNo,
                                                                  @RequestParam(defaultValue = "20", required = false) Integer pageSize,
                                                                  @RequestParam(defaultValue = "itemId", required = false) String sortBy,
                                                                  @RequestParam(defaultValue = "ASC", required = false) String sortDirection){
        Sort.Direction sortDir = sortDirection.equalsIgnoreCase("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Pageable paging = PageRequest.of(pageNo, pageSize, sortDir, sortBy);
        ServiceResponse<List<ItemDto>> response = service.getAllItemsByCategory(category,paging);
        return ResponseEntity.ok(ApiResponse.<List<ItemDto>>builder()
                .operationResultCode(HttpStatus.OK.value())
                .operationResultDescription("Fetched all items filtered by categories")
                .totalObjectNumber(response.getTotal())
                .returnedObjectNumber(response.getPayload().size())
                .payload(response.getPayload())
                .build());
    }

    @GetMapping(value = "{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<ApiResponse<Item>> getItemById(@PathVariable Long id){
        ServiceResponse<Item> item = service.getItemById(id);
        if(item != null){
        return ResponseEntity.ok(ApiResponse.<Item>builder()
                                            .payload(item.getPayload())
                                            .operationResultDescription("Item successfully fetched")
                                            .operationResultCode(HttpStatus.OK.value())
                                            .build());
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping(value = "add-item", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<ApiResponse<Item>> addItem(@RequestBody ItemDto itemDto){
        ServiceResponse<Item> item = service.createItem(itemDto);
        return ResponseEntity.ok(ApiResponse.<Item>builder()
                                            .payload(item.getPayload())
                                            .operationResultCode(HttpStatus.CREATED.value())
                                            .totalObjectNumber(1)
                                            .returnedObjectNumber(1)
                                            .operationResultDescription("Item successfully added")
                                            .build());
    }

    @PatchMapping(value = "update", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<ApiResponse<Item>> updateItem(@RequestBody ItemDto itemDto) throws ItemNotFoundException {
        ServiceResponse<Item> item = service.updateItem(itemDto);
        return ResponseEntity.ok(ApiResponse.<Item>builder()
                        .payload(item.getPayload())
                        .operationResultCode(HttpStatus.OK.value())
                        .returnedObjectNumber(1)
                        .totalObjectNumber(1)
                        .operationResultDescription("Item successfully updated")
                        .build());
    }

    @DeleteMapping(value = "delete/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<String>deleteItem(@PathVariable Long id) throws ItemNotFoundException {
        service.removeItem(id);
        return ResponseEntity.ok("Item with id: " + id + " successfully deleted");
    }

}
