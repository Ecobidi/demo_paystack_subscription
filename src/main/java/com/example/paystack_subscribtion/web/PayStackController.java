package com.example.paystack_subscribtion.web;

import com.example.paystack_subscribtion.dtos.*;
import com.example.paystack_subscribtion.services.SubscriptionService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Collections;

@RestController
@CrossOrigin
@RequestMapping(path = "/v1")
public class PayStackController {
    @Value("${mysecret.key}")
    private String secretKey;

    private final SubscriptionService subscriptionService;

    public PayStackController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @GetMapping("/test/{name}")
    public ResponseEntity<String> testing12(@PathVariable("name") String name) {
        System.out.println("hello " + name);
        return new ResponseEntity<>("Hello " + name, HttpStatus.OK);
    }

    @PostMapping("/plan")
    public ResponseEntity<CreateSubscriptionPlanResponseDTO> createPlan(@Valid @RequestBody CreateSubscriptionPlanRequestDTO body) {
        try {
            HttpHeaders headers = new HttpHeaders();
            CreateSubscriptionPlanResponseDTO responseDTO = subscriptionService.createPlan(body);
            return new ResponseEntity<>(responseDTO, headers, HttpStatus.CREATED);
        } catch (HttpStatusCodeException ex) {
            System.out.println(ex);
            return ResponseEntity.status(ex.getStatusCode()).body(null);
        }
    }

    @PostMapping("/subscription")
    public ResponseEntity<CreateSubscriptionResponseDTO> createSubscription(@Valid @RequestBody CreateSubscriptionRequestDTO body) {
        try {
            CreateSubscriptionResponseDTO responseDto = subscriptionService.createSubscription(body);
            if (responseDto == null) {
                System.out.println("No existing payment authorization found");
                throw new ResponseStatusException(
                        HttpStatus.FAILED_DEPENDENCY, "No Pre-Existing Authorization To Charge From", null);
            }
            return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
        } catch(HttpStatusCodeException ex) {
            System.out.println(ex);
            throw new ResponseStatusException(
                    ex.getStatusCode(), ex.getResponseBodyAsString(), ex);
        }
    }

    @PostMapping("/subscription-on-transaction")
    public ResponseEntity<CreateSubscriptionResponseDTO> createSubscriptionOnInitializeTransaction(@Valid @RequestBody CreateSubscriptionOnInitializationRequestDTO body) {
        try {
            CreateSubscriptionResponseDTO responseDTO = subscriptionService.createSubscriptionOnTransactionInitialization(body);
            if (responseDTO == null) {
                throw new ResponseStatusException(
                        HttpStatus.FAILED_DEPENDENCY, "No Pre-Existing Authorization To Charge From", null);
            }
            return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
        } catch(HttpStatusCodeException ex) {
            System.out.println(ex);
            throw new ResponseStatusException(
                    ex.getStatusCode(), ex.getResponseBodyAsString(), ex);
        }
    }

    @CrossOrigin(origins = {"https://52.31.139.75", "https://52.49.173.169", "https://52.214.14.220"})
    public void webHookEventHandler() {

    }

    private HttpHeaders getPreparedHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + secretKey);
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        return headers;
    }

}
