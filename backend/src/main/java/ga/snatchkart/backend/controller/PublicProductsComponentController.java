package ga.snatchkart.backend.controller;

import java.util.List;

import ga.snatchkart.backend.modal.Product;
import ga.snatchkart.backend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/public/products")
public class PublicProductsComponentController {

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/inOffer")
    public List<Product> getAllProductsWithOffers() {
        return productService.getAllProductsByOffers();
    }
}
