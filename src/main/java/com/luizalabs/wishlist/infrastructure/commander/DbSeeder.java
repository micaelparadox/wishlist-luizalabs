package com.luizalabs.wishlist.infrastructure.commander;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.luizalabs.wishlist.domain.entity.Product;
import com.luizalabs.wishlist.infrastructure.repository.WishlistRepository;

@Component
public class DbSeeder implements CommandLineRunner {
	private final WishlistRepository repository;

	public DbSeeder(WishlistRepository repository) {
		this.repository = repository;
	}

	@Override
	public void run(String... strings) {

		repository.deleteAll();

		List<String> productNames = Arrays.asList(
				"iPhone 13 Pro Max", 
				"MacBook Pro 16", 
				"Samsung Galaxy S21",
				"Google Pixel 6", 
				"iPad Air", 
				"Sony PlayStation 5", 
				"Xbox Series X", 
				"Nintendo Switch", 
				"Dell XPS 15",
				"HP Spectre x360", 
				"Bose QuietComfort 35", 
				"Sonos One", 
				"Fitbit Charge 4", 
				"GoPro HERO9 Black",
				"DJI Mavic Air 2", 
				"Nikon Z6", 
				"Canon EOS R5", 
				"Apple Watch Series 7", 
				"Microsoft Surface Laptop 4");

		productNames.forEach(name -> {
			Product product = new Product();
			product.setName(name);
			repository.save(product);
		});

	}
}
