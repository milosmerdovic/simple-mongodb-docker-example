package com.ecommerce.items.resource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "item")
public class Item {
    @Id
    private String id;
    private long itemId;
    private int serialNumber;
    private String category;
    private String name;
}
