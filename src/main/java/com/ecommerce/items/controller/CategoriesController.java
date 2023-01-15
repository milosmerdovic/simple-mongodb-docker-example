package com.ecommerce.items.controller;

import com.ecommerce.items.common.ApiResponse;
import com.ecommerce.items.common.ServiceResponse;
import com.ecommerce.items.dto.ItemDto;
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
@RequestMapping(Endpoints.CATEGORIES)
public class CategoriesController {

    @Autowired
    ItemServiceImpl service;

    @GetMapping(value = "{category}",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
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

}
