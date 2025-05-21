package cat.ycamacho.freetable_api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import cat.ycamacho.freetable_api.models.dto.ReservationDTO;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendNewReservationEmail(ReservationDTO booking, String resEmail, String resName, String resPhone) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("yosarca@gmail.com"); // Remitente
        message.setTo(booking.getClientEmail());                      // Destinatario
        message.setSubject("Confirmación de reserva :" + resName);            // Asunto
        String body = "Querido usuario, tiene una nueva reserva programada el día " + booking.getDate() + 
            " a las " + booking.getHour() + " h en el restaurante " + resName + ".\nPuede realizar modificaciones " + 
            " a través de nuestra página web o contactar directamente al resturante.\nEmail: " + resEmail + "\nTeléfono: " + resPhone;        
        
        message.setText(body);                  // Cuerpo del mensaje
        mailSender.send(message);
    }
}
