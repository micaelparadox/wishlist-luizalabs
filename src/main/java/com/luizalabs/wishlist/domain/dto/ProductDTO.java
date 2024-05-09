package com.luizalabs.wishlist.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe de transferência de dados (DTO) para os produtos.
 * <p>
 * Esta classe é utilizada para interagir com a API, permitindo a transferência de informações sobre produtos
 * sem expor o identificador único do produto (ID). O ID é gerado automaticamente e não é exposto na API
 * por questões de segurança e privacidade.
 * </p>
 * <p>
 * Para verificar o ID de um produto, pode-se utilizar ferramentas como o MongoDB Compass ou qualquer outro
 * sistema gerenciador de banco de dados (SGBD) compatível com o MongoDB, acessando diretamente o banco de dados.
 * </p>
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
	
	//private String id;
	private String name;
}
