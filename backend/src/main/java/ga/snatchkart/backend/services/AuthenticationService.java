package ga.snatchkart.backend.services;

import ga.snatchkart.backend.modal.Login;
import ga.snatchkart.backend.modal.Register;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface AuthenticationService {
    ResponseEntity<String> login(Login loginRequest, HttpServletResponse response);
    ResponseEntity<String> register(Register registerRequest, HttpServletResponse response) throws IOException, MessagingException;
}
