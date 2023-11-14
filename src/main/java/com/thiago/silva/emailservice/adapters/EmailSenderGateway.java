package com.thiago.silva.emailservice.adapters;

import com.thiago.silva.emailservice.model.Email;

/**
 * EmailSenderGateway
 * Contrato para que a aplicação interaja com serviços externos
 * 
 */
public interface EmailSenderGateway {
    void send(Email email);
}