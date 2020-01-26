package ga.snatchkart.backend.services;

import ga.snatchkart.backend.modal.Mail;

import javax.mail.MessagingException;
import java.io.IOException;

public interface MailService {
    void sendEmail(Mail mail) throws MessagingException, IOException;
}
