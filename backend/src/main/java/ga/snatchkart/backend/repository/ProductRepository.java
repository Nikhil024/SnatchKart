package ga.snatchkart.backend.repository;

import java.util.List;

import ga.snatchkart.backend.modal.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
	
	List<Product> findByInOffer(Boolean inOffer);

}
