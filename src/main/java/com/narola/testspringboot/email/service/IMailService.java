package com.narola.testspringboot.email.service;

import com.narola.testspringboot.email.service.model.EmailDetails;

public interface IMailService {

    String sendSimpleMail();

    String sendMailWithAttachment(EmailDetails details);
}