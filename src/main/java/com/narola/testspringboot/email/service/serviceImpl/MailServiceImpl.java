package com.narola.testspringboot.email.service.serviceImpl;

import com.narola.testspringboot.email.service.IMailService;
import com.narola.testspringboot.email.service.model.EmailDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements IMailService {

    private String fromAddress="nandansreachout@gmail.com";
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private EmailDetails details;
    @Override
    public String sendSimpleMail()
    {

        // Try block to check for exceptions
        try {

            // Creating a simple mail message
            SimpleMailMessage mailMessage
                    = new SimpleMailMessage();

            // Setting up necessary details
            mailMessage.setFrom(fromAddress);
            mailMessage.setTo(details.getRecipient());
            mailMessage.setText(details.getMsgBody());
            mailMessage.setSubject(details.getSubject());

            // Sending the mail
            javaMailSender.send(mailMessage);
            return "Mail Sent Successfully...";
        }

        // Catch block to handle the exceptions
        catch (Exception e) {
            return "Error while Sending Mail";
        }
    }

    @Override
    public String sendMailWithAttachment(EmailDetails details) {
        return null;
    }
}
