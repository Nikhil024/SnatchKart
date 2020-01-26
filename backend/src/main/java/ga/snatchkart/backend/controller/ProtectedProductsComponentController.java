package ga.snatchkart.backend.controller;

import ga.snatchkart.backend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secure/products")
public class ProtectedProductsComponentController {

	@Autowired
	private ProductService productService;

	@PutMapping("/save")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<String> saveAllProducts() {
		return productService.saveAllProducts();
	}
}
