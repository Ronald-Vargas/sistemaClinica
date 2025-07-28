
package Login;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;


public class EmailSender {
    
    
    //Obtener servidor de MailTrap
    private final String host = "sandbox.smtp.mailtrap.io";
    private final int port = 2525;
    private final String username = "aa1cb13ff8347d";
    private final String password = "68541abcaad93f";
    
    
    public boolean sendEmail(String toEmail, String subject, String body) {
    
    //Activa la autenficicacion y el cifrado
        //Llama el host y el puerto
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", String.valueOf(port));

    
   
        
        //AUtentificar el emisor del correo
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        
        
        try {
            
            //Creacion del mensaje
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("noreply@demo.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject(subject);
            message.setText(body);

            Transport.send(message);
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
        
        
        }
    
    
}
