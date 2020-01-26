package ga.snatchkart.backend.controller;

import com.sun.security.auth.UserPrincipal;
import ga.snatchkart.backend.modal.Cart;
import ga.snatchkart.backend.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secure/cart")
public class ProtectedCartComponentController {
	
	@Autowired
	private CartService cartService;
	
	@GetMapping("/get")
	public ResponseEntity<Cart> getCartOfUser(UserPrincipal principalInfo){
		return new ResponseEntity<Cart>(new Cart(), HttpStatus.OK);
	}

}