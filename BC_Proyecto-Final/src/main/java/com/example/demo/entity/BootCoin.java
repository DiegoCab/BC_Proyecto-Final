package com.example.demo.entity;

import lombok.Data;

@Data
public class BootCoin {
	
	public String transactionNumber;

	public String purchaseTax;
	
	public String sellTax;
	
	public double amount;
	
	public String payType;
}
