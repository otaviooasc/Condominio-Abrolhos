package com.condominium.abrolhos.entity;

public class Condominium {
	
	private Long id;
	private String name;
	private Double inputMonth;
	private Double outMonth;
	private Double previousMonthBalance;
	
	public Condominium() {}
	
	public Condominium(Long id, String name, Double inputMonth, Double outMonth, Double previousMonthBalance) {
		super();
		this.id = id;
		this.name = name;
		this.inputMonth = inputMonth;
		this.outMonth = outMonth;
		this.previousMonthBalance = previousMonthBalance;
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

	public Double getInputMonth() {
		return inputMonth;
	}

	public void setInputMonth(Double inputMonth) {
		this.inputMonth = inputMonth;
	}

	public Double getOutMonth() {
		return outMonth;
	}

	public void setOutMonth(Double outMonth) {
		this.outMonth = outMonth;
	}

	public Double getPreviousMonthBalance() {
		return previousMonthBalance;
	}

	public void setPreviousMonthBalance(Double previousMonthBalance) {
		this.previousMonthBalance = previousMonthBalance;
	}
}