package com.java.bank.api.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RefreshScope
public class BankService {

    Logger logger= LoggerFactory.getLogger(BankService.class);

    public String banking() throws JsonProcessingException {
        //rest call
        logger.info("bank-Service response : ");
        String response ="Success";
        return response;
    }
}
