package ga.snatchkart.backend.services;

import java.util.List;

import ga.snatchkart.backend.modal.Product;
import org.springframework.http.ResponseEntity;


public interface ProductService {

	List<Product> getAllProducts();
	ResponseEntity<String> saveAllProducts();
	List<Product> getAllProductsByOffers();
	
}
