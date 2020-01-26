package ga.snatchkart.backend.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Map;

public interface JWTTokenService {
    String generateToken(String username);
    Boolean validateToken(String token);
    String extractUsername(String token);
}
