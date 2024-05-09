# Wishlist

Este projeto é uma implementação de uma API para gerenciamento de listas de desejos (wishlist). Foi desenvolvido com Spring Boot e MongoDB, oferecendo uma interface via Swagger para fácil visualização e interação com os endpoints da API.

## Pré-requisitos

Para rodar este projeto localmente, é necessário ter uma instância do MongoDB. O projeto está configurado para se conectar a uma base de dados local, que pode ser configurada conforme descrito abaixo:

- MongoDB rodando localmente na porta padrão: `27017`.
- URI para conexão local: `mongodb://127.0.0.1:27017/wishlistdb`

### Configuração com Docker -> RECOMENDADO <-

Se preferir utilizar Docker, o projeto inclui um `docker-compose.yml` configurado para rodar o MongoDB em um container Docker, mapeado para a porta `27018` para evitar conflitos com instâncias locais:

- URI para conexão via Docker: `mongodb://127.0.0.1:27018/wishlistdb`

1. Para subir o projeto utilizando Docker, certifique-se de que o Docker está instalado corretamente e execute na raiz do projeto:

   
   ```docker-compose up --build```
   
2. O Dockerfile vai criar toda a infra necessaria, e você não deve ter nenhum problema!

## Instalação alternativa Local e Execução

Para testar o projeto localmente, siga os passos abaixo:

1. Clone o repositório do projeto.
2. Na raiz do projeto, execute o comando `mvn install` seguido de `mvn clean package` para gerar o arquivo `target/wishlist-0.0.1-SNAPSHOT.jar`.
3. Se estiver usando STS ou outra IDE nesse ponto você deve estar apto a rodar a aplicação.
4. Use algum SGBD tipo MongoDB Compass [https://www.mongodb.com/try/download/compass](https://www.mongodb.com/try/download/compass) ou DBeaver lembrando que você vai precisar baixar algum plugin recomendo usar o MongoDB Compass. 

## Swagger UI

A documentação da API pode ser acessada através do Swagger UI no seguinte endereço após iniciar o projeto:

- [http://localhost:8080/swagger-ui/](http://localhost:8080/swagger-ui/)

Esta interface facilita a visualização e interação com os endpoints da API, sendo também compatível com ferramentas como Postman para testes mais práticos.

## Funcionalidades do Commander

O sistema inclui um `Commander` que inicializa com 19 produtos PROPOSITALMENTE na lista de desejos. Caso a lista exceda 20 itens, uma exceção de runtime será lançada informando que a lista está cheia, cobrindo assim os requisitos de limite para a lista de desejos.

## Testes

O projeto inclui testes simples que podem ser executados para validar as funcionalidades básicas.

## Postman Collection

Uma coleção do Postman foi exportada e está disponível para facilitar os testes dos endpoints. Esta na raiz do projeto

[``(https://github.com/micaelparadox/wishlist-luizalabs/blob/main/LuizaLabsCollection.postman_collection.json)``](https://github.com/micaelparadox/wishlist-luizalabs/blob/main/LuizaLabsCollection.postman_collection.json)

## Suporte

Em caso de dúvidas, por favor, entre em contato pelo e-mail: micaelparadox@gmail.com
