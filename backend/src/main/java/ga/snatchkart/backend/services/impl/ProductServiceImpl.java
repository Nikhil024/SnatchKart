package ga.snatchkart.backend.services.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import ga.snatchkart.backend.modal.Product;
import ga.snatchkart.backend.modal.ProductCategory;
import ga.snatchkart.backend.repository.ProductRepository;
import ga.snatchkart.backend.services.ProductCategoryService;
import ga.snatchkart.backend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductCategoryService productCategoryService;

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public ResponseEntity<String> saveAllProducts() {
		List<Product> product = new ArrayList<>();
		List<ProductCategory> productCategories = new ArrayList<>();

		product.add(new Product("Samsung Galaxy Note 8", 64000D, new ProductCategory("SMG-8", LocalDateTime.now()),
				"SMG-8", true, 30000D, true, 10L, LocalDateTime.now(), LocalDateTime.now()));
		product.add(new Product("Samsung Galaxy Note 9", 68000D, new ProductCategory("SMG-9", LocalDateTime.now()),
				"SMG-9", true, 42000D, true, 10L, LocalDateTime.now(), LocalDateTime.now()));
		product.add(new Product("Samsung Galaxy Note 10", 72000D, new ProductCategory("SMG-10", LocalDateTime.now()),
				"SMG-10", true, 55000D, false, 10L, LocalDateTime.now(), LocalDateTime.now()));
		product.add(new Product("Samsung Galaxy Note 11", 84000D, new ProductCategory("SMG-11", LocalDateTime.now()),
				"SMG-11", false, null, true, 10L, LocalDateTime.now(), LocalDateTime.now()));
		product.add(new Product("Samsung Galaxy Note 12", 90000D, new ProductCategory("SMG-12", LocalDateTime.now()),
				"SMG-12", false, null, true, 10L, LocalDateTime.now(), LocalDateTime.now()));
		product.add(new Product("Samsung Galaxy Note 13", 93000D, new ProductCategory("SMG-13", LocalDateTime.now()),
				"SMG-13", true, 38000D, true, 10L, LocalDateTime.now(), LocalDateTime.now()));
		product.add(new Product("Samsung Galaxy Note 14", 98000D, new ProductCategory("SMG-14", LocalDateTime.now()),
				"SMG-14", false, null, false, 10L, LocalDateTime.now(), LocalDateTime.now()));

		try {
			product.forEach(products -> {
				if (!productCategories.contains(products.getProductCategory())) {
					productCategories.add(products.getProductCategory());
				}
			});
			productCategoryService.saveAllProductCategories(productCategories);
			productRepository.saveAll(product);
			return new ResponseEntity<String>("Added Products", HttpStatus.OK);
		} catch (DuplicateKeyException de) {
			return new ResponseEntity<String>("Products Already exists, please check request!" + de.toString(),
					HttpStatus.CONFLICT);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Products saving Failure!", HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public List<Product> getAllProductsByOffers() {
		return productRepository.findByInOffer(true);
	}

}