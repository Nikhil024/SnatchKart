package ga.snatchkart.backend.modal;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Document
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String name;
	@NotNull
	private Double value;
	@NotNull
	private ProductCategory productCategory;
	@NotNull
	@Indexed(unique = true, sparse = true)
	private String sku;
	private Boolean inOffer;
	private Double offerPrice;
	private Boolean inStock;
	private Long stocks;

	private LocalDateTime createdOn;
	@NotNull
	private LocalDateTime lastUpdated;

	public Product(String name, @NotNull Double value, @NotNull ProductCategory productCategory, @NotNull String sku,
			Boolean inOffer, Double offerPrice, Boolean inStock, Long stocks, LocalDateTime createdOn,
			@NotNull LocalDateTime lastUpdated) {
		super();
		this.name = name;
		this.value = value;
		this.productCategory = productCategory;
		this.sku = sku;
		this.inOffer = inOffer;
		this.offerPrice = offerPrice;
		this.inStock = inStock;
		this.stocks = stocks;
		this.createdOn = createdOn;
		this.lastUpdated = lastUpdated;
	}

}