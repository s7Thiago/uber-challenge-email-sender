package com.thiago.silva.emailservice.infra.ses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.AmazonClientException;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;
import com.thiago.silva.emailservice.adapters.EmailSenderGateway;
import com.thiago.silva.emailservice.core.exceptions.EmailServiceException;
import com.thiago.silva.emailservice.model.Email;

@Service
public class SesEmailSender implements EmailSenderGateway {

    private final AmazonSimpleEmailService ses;

    @Autowired
    public SesEmailSender(AmazonSimpleEmailService ses) {
        this.ses = ses;
    }

    @Override
    public void send(Email email) {

        SendEmailRequest request = new SendEmailRequest()
                .withSource("thyagosousasilva@gmail.com")
                .withDestination(new Destination().withToAddresses(email.getTo()))
                .withMessage(new Message()
                        .withSubject(new Content(email.getSubject()))
                        .withBody(new Body().withText(new Content(email.getBody()))));

                        try {
                            this.ses.sendEmail(request);
                        } catch (AmazonClientException ex) {
                            throw new EmailServiceException("Erro: Falha ao enviar o e-mail ( SES )", ex);
                        }

    }

}
