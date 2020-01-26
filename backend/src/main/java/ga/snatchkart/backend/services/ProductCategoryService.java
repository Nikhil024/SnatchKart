package ga.snatchkart.backend.services;

import java.util.List;

import ga.snatchkart.backend.modal.ProductCategory;

public interface ProductCategoryService {
	void saveAllProductCategories(List<ProductCategory> productCategories);
}
