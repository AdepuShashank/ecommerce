package com.shashank.ecom.Services;

import org.springframework.stereotype.Service;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentLink;
import com.stripe.model.Price;
import com.stripe.param.PaymentLinkCreateParams;
import com.stripe.param.PriceCreateParams;

@Service
public class StripePaymentService implements PaymentService {
	
	@Override
	public String getPaymentLink(Long id, Double totalAmount , String email) throws StripeException {
		Stripe.apiKey = "rk_test_51QkioUIJhV7zWzG3VQ9M59Bk6liloG40pONxUwMZVoRUPgVzau95tTrzOJc0KRpc5AuImSr5tmfVDkAKeMGp4oUX00cQrFuGXj";

		PriceCreateParams params =
		  PriceCreateParams.builder()
		    .setCurrency("usd")
		    .setUnitAmount(Math.round(totalAmount*100))
		    
		    .setProductData(
		      PriceCreateParams.ProductData.builder().setName(email).build()
		    )
		    .putMetadata("orderId", String.valueOf(id))
		    .build();

		Price price = Price.create(params);
		
		PaymentLinkCreateParams paymentLinkParams =
				  PaymentLinkCreateParams.builder()
				    .addLineItem(
				      PaymentLinkCreateParams.LineItem.builder()
				        .setPrice(price.getId())
				        .setQuantity(1L)
				        .build()
				    )
				    .setAfterCompletion(
				    		PaymentLinkCreateParams.AfterCompletion.builder()
				    		.setType(PaymentLinkCreateParams.AfterCompletion.Type.REDIRECT)
				    		.setRedirect(PaymentLinkCreateParams.AfterCompletion.Redirect.builder()
				    				.setUrl("http://localhost:8080/user")
				    				.build()
				    		)
				    		.build()
				    )				    			
				    .build();
				PaymentLink paymentLink;
				paymentLink = PaymentLink.create(paymentLinkParams);
		return paymentLink.getUrl();
	}
}
