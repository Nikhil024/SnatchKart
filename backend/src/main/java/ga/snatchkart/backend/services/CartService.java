package ga.snatchkart.backend.services;

import ga.snatchkart.backend.modal.Cart;
import org.springframework.http.ResponseEntity;

public interface CartService {
	ResponseEntity<String> saveCart(Cart cart);
}