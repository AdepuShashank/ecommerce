package com.shashank.ecom.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.shashank.ecom.Exceptions.OrderNotFoundException;
import com.shashank.ecom.Services.PaymentService;
import com.shashank.ecom.models.Order;
import com.stripe.exception.StripeException;
import com.stripe.model.Event;
import com.stripe.net.Webhook;

@RestController
public class PaymentController {
	private PaymentService paymentService;
	private final RestTemplate restTemplate;
	
	public PaymentController(PaymentService paymentService, RestTemplate restTemplate) {
		this.paymentService = paymentService;
		this.restTemplate = restTemplate;
	}
	
	@GetMapping("/payment/{orderId}")
	public String makePayment(@PathVariable("orderId") long orderId)throws OrderNotFoundException, StripeException {
		Order orderFromDB = restTemplate.getForObject("http://localhost:8080/order/"+ orderId , Order.class);
		
		String paymentLink;
		paymentLink = paymentService.getPaymentLink(orderId, orderFromDB.getPrice(), orderFromDB.getUser().getEmail());
		
		return paymentLink;
	}
	
	@PostMapping("/webhook")
	public void handleWebhook(
			@RequestBody String payload,
			@RequestHeader("Stripe-Signature") String signatureHeader) {
//		
		try {
			Event event = Webhook.constructEvent(payload, signatureHeader, "whsec_e80ac78fc56f236cd23b282034322bf2498f1f154b8d6e2a9c4990223fc6b9c3");
			System.out.println(event.getType());
			
		}
		catch (Exception e)
		{
			System.out.println("Error" + e.getMessage());
		}
		
	}
}
