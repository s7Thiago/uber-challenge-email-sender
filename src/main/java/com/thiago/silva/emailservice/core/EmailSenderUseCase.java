package com.thiago.silva.emailservice.core;

import com.thiago.silva.emailservice.model.Email;

/**
 * EmailSenderUseCase
 */
public interface EmailSenderUseCase {

    void send(Email email);

}