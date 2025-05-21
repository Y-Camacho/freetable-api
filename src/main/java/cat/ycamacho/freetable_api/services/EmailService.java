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
        String body = String.format(
            "Hola %s,\n\n" +
            "¡Gracias por reservar con nosotros!\n\n" +
            "🗓️ Fecha: %s\n" +
            "🕒 Hora: %s h\n" +
            "📍 Restaurante: %s\n\n" +
            "Puedes gestionar tu reserva desde nuestra página web o contactando directamente al restaurante:\n" +
            "✉️ Email: %s\n" +
            "📞 Teléfono: %s\n\n" +
            "¡Te esperamos!\n\n" +
            "Atentamente,\n" +
            "El equipo de FreeTable",
            booking.getClientFullName(),   // si tienes el nombre del cliente
            booking.getDate(),
            booking.getHour(),
            resName,
            resEmail,
            resPhone
        );
     
        
        message.setText(body);                  // Cuerpo del mensaje
        mailSender.send(message);
    }
}
