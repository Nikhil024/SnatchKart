package ga.snatchkart.backend.modal;

import ga.snatchkart.backend.enumration.AuthProvider;
import ga.snatchkart.backend.enumration.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Users {
    @Id
    private Long id;
    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";
    private String email;
    private String name;
    private UserRole role;
    private String password;
    private AuthProvider provider;
    private String imageUrl;
    private String providerId;
}
