package com.luizalabs.wishlist.infrastructure.repository;

import com.luizalabs.wishlist.domain.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WishlistRepository extends MongoRepository<Product, String> {
}
