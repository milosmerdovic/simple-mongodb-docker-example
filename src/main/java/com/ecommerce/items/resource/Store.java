package com.ecommerce.items.resource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "store")
public class Store {
    @Id
    private String id;
    private long storeId;
    private String storeName;
    @DBRef
    private Address address;

}
