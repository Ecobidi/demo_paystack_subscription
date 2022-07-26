package com.example.paystack_subscribtion;

import com.example.paystack_subscribtion.dtos.CreateSubscriptionRequestDTO;
import com.example.paystack_subscribtion.dtos.CreateSubscriptionResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;


@SpringBootApplication
public class PaystackSubscribtionApplication {

//	private final RestTemplate restTemplate;
//
//	@Value("${mysecret.key}")
//	private String secretKey;
//
//
//	public PaystackSubscribtionApplication(RestTemplateBuilder builder) {
//		this.restTemplate = builder.build();
//	}

	public static void main(String[] args) {
		SpringApplication.run(PaystackSubscribtionApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		System.out.println("Commandline Runner Stuff");
////		var url = "https://api.paystack.co/subscription";
////
////		HttpHeaders headers = new HttpHeaders();
////
////		headers.setContentType(MediaType.APPLICATION_JSON);
////		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
////		headers.set("Authorization", "Bearer " + secretKey);
////
//////		System.out.println(headers);
////
//////		HttpEntity httpEntity = new HttpEntity(headers);
////
////		CreateSubscriptionRequestDTO requestBody = new CreateSubscriptionRequestDTO();
////
////		requestBody.setCustomer("obidi.ceo@gmail.com");
////		requestBody.setPlan("PLN_mdzoelwhymzuxc6");
////
////		HttpEntity<CreateSubscriptionRequestDTO> httpEntity =
////				new HttpEntity<>(requestBody, headers);
////
////		System.out.println(httpEntity);
////
////		ResponseEntity<CreateSubscriptionResponseDTO> response = restTemplate.postForEntity(url, httpEntity, CreateSubscriptionResponseDTO.class);
////
////		System.out.println(response);
//	}
}
