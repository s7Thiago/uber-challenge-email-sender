package com.thiago.silva.emailservice.core.mapper;

import org.mapstruct.Mapper;

import com.thiago.silva.emailservice.core.request.EmailRequest;
import com.thiago.silva.emailservice.model.Email;

/**
 * EmailMapper
 */
@Mapper(componentModel = "spring")
public interface EmailMapper {

    Email fromRequestToEmail(EmailRequest request);
}
