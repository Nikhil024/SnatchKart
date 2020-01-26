package ga.snatchkart.backend.controller;

import ga.snatchkart.backend.modal.Login;
import ga.snatchkart.backend.modal.Register;
import ga.snatchkart.backend.services.AuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping("/public/auth")
public class PublicAuthenticationComponentController {

    private static final Logger logger = LoggerFactory.getLogger(PublicAuthenticationComponentController.class);

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<String> authenticateUser(@Valid @RequestBody Login loginRequest,
                                                   HttpServletResponse response) {
        return authenticationService.login(loginRequest, response);
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signUpUser(@Valid @RequestBody Register registerRequest,
                                                   HttpServletResponse response) throws MessagingException, IOException {
        return authenticationService.register(registerRequest, response);
    }
}
