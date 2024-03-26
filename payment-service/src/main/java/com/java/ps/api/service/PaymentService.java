package com.java.ps.api.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.ps.api.entity.Payment;
import com.java.ps.api.repository.PaymentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Random;
import java.util.UUID;

@Service
public class PaymentService {
    
    @Autowired
    private PaymentRepository repository;
    
    Logger logger= LoggerFactory.getLogger(PaymentService.class);

    @Value("${microservice.modePayment-service.endpoints.endpoint.uri}")
    private String ENDPOINT_URL;

    @Autowired
    @Lazy
    private RestTemplate template;
    
    public Payment doPayment(Payment payment) throws JsonProcessingException {
        payment.setPaymentStatus(paymentProcessing());
        payment.setTransactionId(UUID.randomUUID().toString());
        logger.info("Payment-Service Request : {}",new ObjectMapper().writeValueAsString(payment));
        String response = template.getForObject(ENDPOINT_URL,String.class);
        logger.info("Response from ModePayment-Service : {}",response);
        return repository.save(payment);
    }


    public String paymentProcessing(){
        //api should be 3rd party payment gateway (paypal,paytm...)
        return new Random().nextBoolean()?"success":"false";
    }


    public Payment findPaymentHistoryByOrderId(int orderId) throws JsonProcessingException {
        Payment payment=repository.findByOrderId(orderId);
        logger.info("paymentService findPaymentHistoryByOrderId : {}",new ObjectMapper().writeValueAsString(payment));
        return payment ;
    }
}
