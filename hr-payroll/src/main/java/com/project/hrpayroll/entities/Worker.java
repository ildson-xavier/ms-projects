package com.project.hrpayroll.entities;

import java.io.Serializable;

public class Worker implements Serializable{

	private static final long serialVersionUID = 6144582048652474038L;

	private Long id;
	private String name;
	private Double dailyIncome;
	
	public Worker() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getDailyIncome() {
		return dailyIncome;
	}

	public void setDailyIncome(Double dailyIncome) {
		this.dailyIncome = dailyIncome;
	}
	
	
}
