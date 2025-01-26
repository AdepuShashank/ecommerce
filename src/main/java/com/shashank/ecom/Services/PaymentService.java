package com.shashank.ecom.Services;

import com.stripe.exception.StripeException;

public interface PaymentService {
	 public String getPaymentLink(Long id, Double totalAmount, String email) throws StripeException;
}
