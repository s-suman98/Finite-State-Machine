package org.com.entity;

import org.com.enums.Transactiontype;
import org.com.exception.InvalidPinException;
import org.com.model.Card;
import org.com.strategy.CardValidator;
import org.com.strategy.RandomValidator;

public class CardInserted implements AtmSystemI {


private  CardValidator cardValidator=new RandomValidator ();
@Override
public void insertCard (AtmSystem context , Card card) {
	
	throw new IllegalStateException ("you cant entre pin in idle  state");

	
}

@Override
public void ejectCard (AtmSystem context) {
	
	
	context.setAtmState (new Idle ());
	
}

@Override
public void enterPin (AtmSystem context,String pin) {
	
	if( cardValidator.validateCard (context.getCard (), pin) ){
		
		context.setAtmState (new Autheticated ());
	
	}else{
		
		throw new InvalidPinException ("Pin entered is not valid for the card "+context.getCard ());
		
	}
	
	
	
	
	
}

@Override
public void enterChoice (AtmSystem context, Transactiontype transactiontype) {
	
	throw new IllegalStateException ("choice cant be entredg in the card Inserted");
	
	
}
}
