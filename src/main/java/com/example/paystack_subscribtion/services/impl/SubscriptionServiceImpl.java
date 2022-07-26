package com.example.paystack_subscribtion.services.impl;

import com.example.paystack_subscribtion.dtos.*;
import com.example.paystack_subscribtion.services.SubscriptionService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    @Value("${mysecret.key}")
    private String secretKey;

    private final RestTemplate restTemplate;

    public SubscriptionServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public CreateSubscriptionPlanResponseDTO createPlan(CreateSubscriptionPlanRequestDTO dto) throws HttpStatusCodeException {
        System.out.println("createPlan() service");
        String url = "https://api.paystack.co/plan";
        System.out.println(dto);
        HttpHeaders headers = getPreparedHeaders();
        HttpEntity<CreateSubscriptionPlanRequestDTO> httpEntity =
                new HttpEntity<>(dto, headers);
        ResponseEntity<CreateSubscriptionPlanResponseDTO> response = restTemplate.postForEntity(url,
                httpEntity,
                CreateSubscriptionPlanResponseDTO.class);
        System.out.println(response);

        return response.getBody();
    }

    @Override
    public CreateSubscriptionResponseDTO createSubscription(CreateSubscriptionRequestDTO dto) throws HttpStatusCodeException {
        System.out.println("createSubscription() service");
        // in case only email is sent
        dto.setCustomer(dto.getCustomer() == null ? dto.getEmail() : dto.getCustomer());
        System.out.println(dto);
        boolean hasExistingPaymentAuthorization =
                checkIfCustomerHasExistingPaymentAuthorization(dto.getEmail() != null ? dto.getEmail() : dto.getCustomer());
        if (!hasExistingPaymentAuthorization) {
            return null;
        }
        String url = "https://api.paystack.co/subscription";
        HttpHeaders headers = getPreparedHeaders();
        HttpEntity<CreateSubscriptionRequestDTO> httpEntity = new HttpEntity<>(dto, headers);

        ResponseEntity<CreateSubscriptionResponseDTO> subscriptionResponseDTO
                = restTemplate.postForEntity(url, httpEntity, CreateSubscriptionResponseDTO.class);
        System.out.println(subscriptionResponseDTO);
        return subscriptionResponseDTO.getBody();
    }

    @Override
    public CreateSubscriptionResponseDTO createSubscriptionOnTransactionInitialization(CreateSubscriptionOnInitializationRequestDTO dto) {
        System.out.println("createSubscriptionOnTransactionInitialization() service");
        System.out.println(dto);
        boolean hasExistingPaymentAuthorization =
                checkIfCustomerHasExistingPaymentAuthorization(dto.getEmail());
        if (!hasExistingPaymentAuthorization) {
            return null;
        }
        String url = "https://api.paystack.co/transaction/initialize";
        HttpHeaders headers = getPreparedHeaders();
        HttpEntity<CreateSubscriptionOnInitializationRequestDTO> httpEntity = new HttpEntity<>(dto, headers);

        ResponseEntity<CreateSubscriptionResponseDTO> subscriptionResponseDTO
                = restTemplate.postForEntity(url, httpEntity, CreateSubscriptionResponseDTO.class);
        System.out.println(subscriptionResponseDTO);
        return subscriptionResponseDTO.getBody();
    }

    private boolean checkIfCustomerHasExistingPaymentAuthorization(String email_or_code) throws HttpStatusCodeException {
        PaystackCustomerResponseDTO customerResponseDTO = fetchCustomer(email_or_code);
        System.out.println("found customer " + customerResponseDTO);
        int numberOfAuthorizations = customerResponseDTO.getData().getAuthorizations().length;
        return numberOfAuthorizations > 0;
    }

    private PaystackCustomerResponseDTO fetchCustomer(String email_or_code) throws HttpStatusCodeException {
        String url = "https://api.paystack.co/customer/" + email_or_code;
        HttpHeaders headers = getPreparedHeaders();
        HttpEntity httpEntity = new HttpEntity(headers);
        return restTemplate.exchange(url, HttpMethod.GET, httpEntity, PaystackCustomerResponseDTO.class).getBody();
    }


    private HttpHeaders getPreparedHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + secretKey);
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        return headers;
    }
}
