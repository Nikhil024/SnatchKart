package ga.snatchkart.backend.modal;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Register implements Serializable {
    private String name;
    private String email;
    private String password;
}
