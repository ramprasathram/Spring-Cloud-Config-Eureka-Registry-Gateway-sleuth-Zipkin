package com.java.cloud.gateway;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallbackController {

    @RequestMapping("/orderFallBack")
    public Mono<String> orderServiceFallBack() {
        return Mono.just("Order Service is taking too long to respond or is down. Please try again later");
    }
    @RequestMapping("/paymentFallback")
    public Mono<String> paymentServiceFallBack() {
        return Mono.just("Payment Service is taking too long to respond or is down. Please try again later");
    }
    @RequestMapping("/ModePaymentFallback")
    public Mono<String> modePaymentServiceFallBack() {
        return Mono.just("Mode Payment Service is taking too long to respond or is down. Please try again later");
    }
    @RequestMapping("/bankFallback")
    public Mono<String> bankServiceFallBack() {
        return Mono.just("Bank Service is taking too long to respond or is down. Please try again later");
    }
}
