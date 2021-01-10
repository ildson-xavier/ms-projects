package com.project.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.hrpayroll.entities.Payment;
import com.project.hrpayroll.entities.Worker;
import com.project.hrpayroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {

//	@Value("${hr-worker.host}")
//	private String workerHost;
//	
//	@Autowired
//	private RestTemplate restTemplate;
	
	@Autowired
	private WorkerFeignClient workerFeignClient;
	
	public Payment getPayment(long workerId, int days) {
		Map<String, String> urlVariables = new HashMap<>();
		urlVariables.put("id", ""+workerId);
		
//		Worker worker = restTemplate.getForObject(workerHost + "workers/{id}", Worker.class, urlVariables);
		Worker worker = workerFeignClient.findById(workerId).getBody();
		
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
