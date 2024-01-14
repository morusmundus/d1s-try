package com.example.server.service.messages;

import com.example.server.dto.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final JavaMailSender mailSender;
    private final ConfigMessages configMessages;

    public void sendMail(Message message) {
        SimpleMailMessage smm = new SimpleMailMessage();
        smm.setFrom(configMessages.getUsername());
        smm.setSubject(message.getSubject());
        smm.setText(message.getMessage());
        smm.setTo(message.getReceiver());

        mailSender.send(smm);
    }

}
