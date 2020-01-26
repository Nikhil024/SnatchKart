package ga.snatchkart.backend.services.impl;

import java.util.List;

import ga.snatchkart.backend.modal.ProductCategory;
import ga.snatchkart.backend.repository.ProductCategoryRepository;
import ga.snatchkart.backend.services.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

	@Autowired
	private ProductCategoryRepository productCategoryRepository;
	
	@Override
	public void saveAllProductCategories(List<ProductCategory> productCategories) {
		productCategoryRepository.saveAll(productCategories);
	}

}
