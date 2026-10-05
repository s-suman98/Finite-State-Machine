package org.com.entity;

import org.com.enums.Transactiontype;
import org.com.model.Card;
import java.util.Scanner;

public class Transacting implements AtmSystemI {


public Transacting(){

}

@Override
public void insertCard(AtmSystem context, Card card) {
	throw new IllegalStateException("cant take a card in the transacting state");
}

@Override
public void ejectCard(AtmSystem context) {
	throw new IllegalStateException("cant take a card in the transacting state");
}

@Override
public void enterPin(AtmSystem context, String pin) {
	throw new IllegalStateException("cant take a card in the transacting state");
}

@Override
public void enterChoice(AtmSystem context, Transactiontype transactiontype) {
	// DO THE ACTUAL WORK HERE
	System.out.println("Processing: " + transactiontype);
	
	Scanner scanner = new Scanner(System.in);
	
	try {
		// Process different transaction types
		switch (transactiontype) {
			case CHECK_BALANCE:
				processCheckBalance(scanner, context);
				break;
			
			case WITHDRAW:
				processWithdraw(scanner, context);
				break;
			
			case DEPOSIT:
				processDeposit(scanner, context);
				break;
			
			default:
				System.out.println("Unknown transaction type");
		}
		
		Thread.sleep(5000);  // Simulate processing
		
		for (int i = 1; i <= 5; i++) {
			System.out.println("TRANSACTING......");
			Thread.sleep(1000);
		}
		
	} catch (Exception e) {
		System.out.println("Error: " + e.getMessage());
	} finally {
		// ONLY transition after work is done
		System.out.println("Transaction complete!");
		context.setAtmState(new TransactionDone());
	}
}

private void processCheckBalance(Scanner scanner, AtmSystem context) {
	System.out.println("\n========== CHECK BALANCE ==========");
	System.out.println("Checking balance for card: " + context.getCard().getCardNo());
	
	// Simulate account balance
	double balance = 5000.00;
	System.out.println("Account Balance: $" + balance);
	System.out.println("====================================\n");
}

private void processWithdraw(Scanner scanner, AtmSystem context) {
	System.out.println("\n========== WITHDRAW MONEY ==========");
	System.out.println("Available denominations: 100, 50, 20, 10");
	
	System.out.print("Enter amount to withdraw: $");
	double amount = 0;
	
	try {
		amount = scanner.nextDouble();
		
		// Validate denomination
		if (amount <= 0) {
			System.out.println("ERROR: Amount must be greater than 0");
			return;
		}
		
		if (amount % 10 != 0) {
			System.out.println("ERROR: Amount must be multiple of 10 (denominations: 10, 20, 50, 100)");
			return;
		}
		
		// Check balance
		double balance = 5000.00;
		if (amount > balance) {
			System.out.println("ERROR: Insufficient balance. Your balance: $" + balance);
			return;
		}
		
		// Simulate cash dispensing
		System.out.println("\nDispensing cash...");
		dispenseCash(amount);
		
		double newBalance = balance - amount;
		System.out.println("Withdrawal successful!");
		System.out.println("Amount withdrawn: $" + amount);
		System.out.println("New balance: $" + newBalance);
		System.out.println("====================================\n");
		
	} catch (Exception e) {
		System.out.println("ERROR: Invalid input. Please enter a valid amount.");
		scanner.nextLine(); // Clear invalid input
	}
}

private void processDeposit(Scanner scanner, AtmSystem context) {
	System.out.println("\n========== DEPOSIT MONEY ==========");
	
	System.out.print("Enter amount to deposit: $");
	double amount = 0;
	
	try {
		amount = scanner.nextDouble();
		
		// Validate input
		if (amount <= 0) {
			System.out.println("ERROR: Amount must be greater than 0");
			return;
		}
		
		// Simulate deposit acceptance
		System.out.println("\nProcessing deposit...");
		System.out.println("Please insert cash into the machine...");
		Thread.sleep(2000);
		
		// Check balance
		double balance = 5000.00;
		double newBalance = balance + amount;
		
		System.out.println("Deposit successful!");
		System.out.println("Amount deposited: $" + amount);
		System.out.println("New balance: $" + newBalance);
		System.out.println("====================================\n");
		
	} catch (Exception e) {
		System.out.println("ERROR: Invalid input. Please enter a valid amount.");
		scanner.nextLine(); // Clear invalid input
	}
}

private void dispenseCash(double amount) {
	// Dispense money in optimal denominations
	int[] denominations = {100, 50, 20, 10};
	
	System.out.println("Dispensing:");
	for (int denom : denominations) {
		int count = (int) (amount / denom);
		if (count > 0) {
			System.out.println("  $" + denom + " x " + count);
			amount -= (count * denom);
		}
	}
}
}
