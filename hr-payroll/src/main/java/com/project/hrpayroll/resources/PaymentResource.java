package com.project.hrpayroll.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.project.hrpayroll.entities.Payment;
import com.project.hrpayroll.services.PaymentService;

@RestController
@RequestMapping(value = "payments")
public class PaymentResource {

	@Autowired
	private PaymentService service;
	
	@HystrixCommand(fallbackMethod = "getPaymentAlternative")
	@GetMapping(value = "/{workderId}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable Long workderId, @PathVariable Integer days) {
		Payment payment = service.getPayment(workderId, days);
		return ResponseEntity.ok(payment);
	}
	
	public ResponseEntity<Payment> getPaymentAlternative(Long workderId, Integer days) {
		Payment payment = new Payment("Boladao", 400.0, days);
		return ResponseEntity.ok(payment);
	}
}
