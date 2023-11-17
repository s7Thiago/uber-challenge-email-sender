package com.thiago.silva.emailservice.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thiago.silva.emailservice.application.EmailSenderService;
import com.thiago.silva.emailservice.core.exceptions.EmailServiceException;
import com.thiago.silva.emailservice.core.mapper.EmailMapper;
import com.thiago.silva.emailservice.core.request.EmailRequest;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/email")
public class EmailSenderController {

    private final EmailSenderService service;
    private final EmailMapper mapper;

    // Injecting access key from properties file
    @Value("${cloud.aws.credentials.access-key}")
    private String accessKey;

    @PostMapping("/send")
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest payload) {

        try {

            this.service.send(mapper.fromRequestToEmail(payload));
            return ResponseEntity.ok("E-mail enviado com sucesso!");

        } catch (EmailServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
