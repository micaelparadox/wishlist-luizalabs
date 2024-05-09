package com.luizalabs.wishlist.domain.exceptions;

public class WishlistFullException extends RuntimeException {
    public WishlistFullException() {
        super("Ops! Sua lista de desejos está cheia. Por favor, remova algum item antes de tentar adicionar novos.");
    }
}
