package com.luizalabs.wishlist.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luizalabs.wishlist.domain.dto.ProductDTO;
import com.luizalabs.wishlist.domain.exceptions.WishlistFullException;
import com.luizalabs.wishlist.domain.service.WishlistService;
import com.luizalabs.wishlist.util.ErrorMessage;

@RestController
@RequestMapping("/wishlist")
public class WishlistController {

	@Autowired
	private WishlistService service;

	@PostMapping
	public ResponseEntity<?> addProduct(@RequestBody ProductDTO productDTO) {
		try {
			service.addProduct(productDTO);
			return ResponseEntity.ok().build();
		} catch (WishlistFullException e) {
			return ResponseEntity.status(400).body(new ErrorMessage(e.getMessage()));
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> removeProduct(@PathVariable String id) {
		service.removeProduct(id);
		return ResponseEntity.ok().build();
	}

	@GetMapping
	public ResponseEntity<List<ProductDTO>> getProducts() {
		return ResponseEntity.ok(service.getAllProducts());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Boolean> isProductInWishlist(@PathVariable String id) {
		return ResponseEntity.ok(service.isProductInWishlist(id));
	}
}
