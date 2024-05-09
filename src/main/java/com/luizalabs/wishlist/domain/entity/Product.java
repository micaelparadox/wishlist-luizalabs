package com.luizalabs.wishlist.domain.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

import java.util.UUID;

@Data
@Document(collection = "products")
public class Product {
    @Id
    private String id = UUID.randomUUID().toString();
    private String name;
}
