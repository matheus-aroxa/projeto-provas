package services;

import Exceptions.EmailException;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailService {

    private final Session session;
    private final String username = "matheusaroxa13@gmail.com";

    public EmailService() {

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        this.session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, "qzsg cshf jppb cdyl");
            }
        });
    }

    public void enviar(String destinatario, String assunto, String corpo) {
        try {
            Message message = new MimeMessage(this.session);
            message.setFrom(new InternetAddress(this.username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            message.setSubject(assunto);
            message.setText(corpo);

            Transport.send(message);

        } catch (MessagingException e) {
            throw new EmailException("Erro ao enviar o e-mail", e);
        }
    }
}