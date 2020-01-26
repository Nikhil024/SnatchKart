package ga.snatchkart.backend.services.impl;

import ga.snatchkart.backend.enumration.AuthProvider;
import ga.snatchkart.backend.enumration.UserRole;
import ga.snatchkart.backend.exceptions.BadRequestException;
import ga.snatchkart.backend.modal.Login;
import ga.snatchkart.backend.modal.Mail;
import ga.snatchkart.backend.modal.Register;
import ga.snatchkart.backend.modal.Users;
import ga.snatchkart.backend.repository.UsersRepository;
import ga.snatchkart.backend.services.AuthenticationService;
import ga.snatchkart.backend.services.JWTTokenService;
import ga.snatchkart.backend.services.MailService;
import ga.snatchkart.backend.services.SequenceGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationServiceImpl.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTTokenService tokenService;

    @Autowired
    private SequenceGenerator sequenceGeneratorService;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MailService mailService;

    @Override
    public ResponseEntity<String> login(Login loginRequest, HttpServletResponse response) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = tokenService.generateToken(loginRequest.getUsername());
        return new ResponseEntity<String>(token, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> register(Register registerRequest, HttpServletResponse response) throws IOException, MessagingException {
        if (usersRepository.existsByEmail(registerRequest.getEmail())) {
            throw new BadRequestException("Email address already in use.");
        }

        // Creating user's account
        Users user = new Users();
        user.setId(sequenceGeneratorService.generateSequence(Users.SEQUENCE_NAME));
        user.setName(registerRequest.getName());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(registerRequest.getPassword());
        user.setProvider(AuthProvider.LOCAL);
        user.setRole(UserRole.ROLE_USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        usersRepository.save(user);


        Mail mail = new Mail();
        mail.setEmail(user.getEmail());//replace with your desired email
        mail.setSubject("Email with Spring boot and thymeleaf template!");

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("name", "Developer!");
        model.put("location", "United States");
        model.put("sign", "Java Developer");
        mail.setProps(model);

        logger.info("END... Email sent success");


        mailService.sendEmail(mail);
        return new ResponseEntity<String>("User registered successfully@", HttpStatus.OK);
    }
}
