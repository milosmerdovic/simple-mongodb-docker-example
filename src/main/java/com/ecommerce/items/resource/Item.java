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

    // TODO -> discuss Id creation strategy
    @Id
    private String id;
    // TODO -> change from primitive to Wrapper class
    private long itemId;
    // TODO -> change from primitive to Wrapper class
    private int serialNumber;
    private String category;
    private String name;
}
