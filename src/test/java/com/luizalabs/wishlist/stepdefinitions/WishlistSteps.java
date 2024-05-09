package com.luizalabs.wishlist.stepdefinitions;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.springframework.beans.factory.annotation.Autowired;

import com.luizalabs.wishlist.domain.entity.Product;
import com.luizalabs.wishlist.infrastructure.repository.WishlistRepository;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class WishlistSteps {

	@Autowired
	private WishlistRepository wishlistRepository;

	private Product product;

	@Dado("que existe um produto com id {string} e nome {string}")
	public void que_existe_um_produto_com_id_e_nome(String id, String name) {
		product = new Product();
		product.setId(id);
		product.setName(name);
	}

	@Quando("eu adiciono o produto à lista de desejos")
	public void eu_adiciono_o_produto_a_lista_de_desejos() {
		wishlistRepository.save(product);
	}

	@Então("o produto deve estar na lista de desejos")
	public void o_produto_deve_estar_na_lista_de_desejos() {
		assertTrue(wishlistRepository.findById(product.getId()).isPresent());
	}

	@Dado("a lista de desejos contém um produto com id {string}")
	public void a_lista_de_desejos_contem_um_produto_com_id(String id) {
		product = wishlistRepository.findById(id).orElseThrow();
	}

	@Quando("eu removo o produto da lista de desejos")
	public void eu_removo_o_produto_da_lista_de_desejos() {
		wishlistRepository.deleteById(product.getId());
	}

	@Então("o produto não deve mais estar na lista de desejos")
	public void o_produto_nao_deve_mais_estar_na_lista_de_desejos() {
		assertFalse(wishlistRepository.findById(product.getId()).isPresent());
	}

	@Então("a lista de desejos deve conter no máximo 20 produtos")
	public void a_lista_de_desejos_deve_conter_no_maximo_20_produtos() {
		assertTrue(wishlistRepository.count() <= 20);
	}
}
