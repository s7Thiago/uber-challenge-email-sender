package com.thiago.silva.emailservice.core;

import com.thiago.silva.emailservice.model.Email;

/**
 * EmailSenderUseCase
 * Representa o contrato interno de implementação de uma
 * ação de enviar email (A regra de negócio)
 *
 */
public interface EmailSenderUseCase {

    void send(Email email);

}