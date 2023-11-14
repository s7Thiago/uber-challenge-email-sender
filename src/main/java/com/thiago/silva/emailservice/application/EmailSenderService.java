package com.thiago.silva.emailservice.application;

import org.springframework.beans.factory.annotation.Autowired;

import com.thiago.silva.emailservice.adapters.EmailSenderGateway;
import com.thiago.silva.emailservice.core.EmailSenderUseCase;
import com.thiago.silva.emailservice.model.Email;

public class EmailSenderService implements EmailSenderUseCase {

    // Portão de entrada para o mundo externo
    private final EmailSenderGateway gateway;

    @Autowired
    public EmailSenderService(EmailSenderGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public void send(Email email) {
       this.gateway.send(email);
    }

}
