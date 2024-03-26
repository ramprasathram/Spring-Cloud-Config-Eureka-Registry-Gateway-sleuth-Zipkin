package com.java.bank.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.java.bank.api.service.BankService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bank")
public class BankController {

    Logger logger= LoggerFactory.getLogger(BankController.class);

    @Autowired
    private BankService service;
    
    @GetMapping("/banking")
    public ResponseEntity<String> banking() throws JsonProcessingException {
        logger.info("bank-Service Controller : ");
        String response = service.banking();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
