package com.condominium.abrolhos.dto;

import javax.validation.constraints.NotBlank;

import com.condominium.abrolhos.entity.Debits;

public class DebitsDto {

    @NotBlank
    private Long id;
    private String name;
    private Double price;
    private String date;
    private String payday;

	DebitsDto(){}

    public DebitsDto(Long id,String name, Double price, String date, String payday) {
    	this.id = id;
        this.name = name;
        this.price = price;
        this.date = date;
        this.payday = payday;
    }
    
    public DebitsDto(Debits debits) {
    	id = debits.getId();
        name = debits.getName();
        price = debits.getPrice();
        date = debits.getDate();
        payday = debits.getPayday();
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public String getPayday() {
		return payday;
	}
	
	public void setPayday(String payday) {
		this.payday = payday;
	}
}
