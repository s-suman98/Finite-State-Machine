package org.com;

import org.com.entity.AtmSystem;
import org.com.enums.Transactiontype;
import org.com.model.Card;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
public static void main (String[] args) {
	
	
	AtmSystem atmSystem = new AtmSystem ();
	
	
	Card card = Card.builder ().cardHolderName ("ANISH SUMAN").cardNo ("1234-2345-6789-4567").securityCode ("700").build ();
	
	atmSystem.insertCard (card);
	
	atmSystem.enterPin ("1234");
	
	atmSystem.enterChoice (Transactiontype.CHECK_BALANCE);
	
	atmSystem.ejectCard ();
	
	
}
}