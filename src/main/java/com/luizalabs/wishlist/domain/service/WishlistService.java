package com.luizalabs.wishlist.domain.service;

import com.luizalabs.wishlist.domain.dto.ProductDTO;
import java.util.List;

public interface WishlistService {
    void addProduct(ProductDTO productDTO);
    void removeProduct(String productId);
    List<ProductDTO> getAllProducts();
    boolean isProductInWishlist(String productId);
}
