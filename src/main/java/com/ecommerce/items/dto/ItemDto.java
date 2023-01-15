package com.ecommerce.items.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {

    // TODO -> discuss Id creation strategy -> currently saving a new Item rewrites an Item if front sends existing id
    private String id;
    // TODO -> change from primitive to Wrapper class
    private long itemId;
    // TODO -> change from primitive to Wrapper class
    private int serialNumber;
    private String category;
    private String name;
}
