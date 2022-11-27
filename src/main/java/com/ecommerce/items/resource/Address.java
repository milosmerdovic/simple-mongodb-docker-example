package com.ecommerce.items.resource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "address")
public class Address {
    @Id
    private String id;
    private long addressId;
    private String streetName;
    private int streetNumber;
    private String townName;
    private String cityName;
    private String countryName;
}
