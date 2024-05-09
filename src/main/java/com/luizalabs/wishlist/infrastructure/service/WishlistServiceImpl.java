package com.luizalabs.wishlist.infrastructure.service;

import com.luizalabs.wishlist.domain.dto.ProductDTO;
import com.luizalabs.wishlist.domain.entity.Product;
import com.luizalabs.wishlist.domain.exceptions.WishlistFullException;
import com.luizalabs.wishlist.domain.service.WishlistService;
import com.luizalabs.wishlist.infrastructure.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WishlistServiceImpl implements WishlistService {

	@Autowired
	private WishlistRepository repository;

	/**
	 * Adiciona um produto à lista de desejos.
	 * <p>
	 * Este método aceita um {@link ProductDTO} que não contém o ID para fins de
	 * segurança e privacidade. O produto é salvo com um ID gerado automaticamente
	 * pelo MongoDB.
	 * </p>
	 * <p>
	 * Para testar essa funcionalidade no Postman e verificar se o produto está na
	 * lista, é necessário consultar o ID do produto diretamente no banco de dados
	 * usando ferramentas como MongoDB Compass ou outros SGBDs.
	 * </p>
	 * 
	 * @param productDTO O DTO do produto a ser adicionado.
	 * @throws RuntimeException Se a lista de desejos atingir o limite de 20
	 *                          produtos.
	 */

	@Override
	public void addProduct(ProductDTO productDTO) {
		if (repository.count() >= 20) {
			throw new WishlistFullException();
		}
		Product product = new Product();
		product.setName(productDTO.getName());
		repository.save(product);
	}

	@Override
	public void removeProduct(String productId) {
		repository.deleteById(productId);
	}

	@Override
	public List<ProductDTO> getAllProducts() {
		return repository.findAll().stream().map(product -> new ProductDTO(product.getName()))
				.collect(Collectors.toList());
	}

	@Override
	public boolean isProductInWishlist(String productId) {
		return repository.existsById(productId);
	}
}
