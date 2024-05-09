Funcionalidade: Gerenciamento de Wishlist

  Cenário: Adicionar um produto à wishlist
    Dado que existe um produto com id "1" e nome "iPhone 13 Pro Max"
    Quando eu adiciono o produto à lista de desejos
    Então o produto deve estar na lista de desejos

  Cenário: Remover um produto da wishlist
    Dado a lista de desejos contém um produto com id "1"
    Quando eu removo o produto da lista de desejos
    Então o produto não deve mais estar na lista de desejos
