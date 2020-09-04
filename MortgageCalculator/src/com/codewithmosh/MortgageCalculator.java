package com.codewithmosh;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {

	public static void main(String[] args) {
		final byte MONTHS_IN_YEAR = 12;
		final byte PERCENT = 100;
		
		int principal = 0;
		float monthlyInterest = 0;
		int numberOfPayment = 0;
		
		Scanner scanner = new Scanner(System.in); 
		
		while (true) {
			System.out.print("Principal ($1K - $1M): ");
			principal = scanner.nextInt();
			if (principal >= 1_000 && principal <= 1_000_000)
				break;
			System.out.println("Enter a number between 1_000 and 1_000_000.");
		}
		
		while (true) {
			System.out.print("Annual interest Rate: ");
			float annualInterest = scanner.nextFloat();
			if (annualInterest >= 1 && annualInterest <= 30) {
				monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;				
				break;
			}
			System.out.println("Enter a value between 1 and 30");
		}
		
		while (true) {
			System.out.print("Period (Years): ");
			byte years = scanner.nextByte();
			if (years >= 1 && years <= 30) {
				numberOfPayment = years * MONTHS_IN_YEAR;
				break;
			}
			System.out.println("Enter a value between 1 and 30");
		}
		
		double mortgage = principal 
				* (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayment)) 
				/ (Math.pow(1 + monthlyInterest, numberOfPayment) - 1);
		
		String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
		System.out.println("Mortgage: " + mortgageFormatted);
	}

}
