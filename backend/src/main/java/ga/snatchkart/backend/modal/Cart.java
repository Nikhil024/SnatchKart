package ga.snatchkart.backend.modal;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Cart implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private BigInteger id;
	@NotNull
	private LocalDateTime cartDate;
	private List<Product> products;
	private Payment paymentDetails;
	@NotNull
	private LocalDateTime lastUpdated;
}
