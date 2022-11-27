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
    private String id;
    private long itemId;
    private int serialNumber;
    private String category;
    private String name;
}
