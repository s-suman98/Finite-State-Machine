package org.com.entity;

import org.com.enums.Transactiontype;
import org.com.model.Card;

public class Idle implements AtmSystemI {
@Override
public void insertCard(AtmSystem context, Card card) {
	
	context.setCard (card);
	context.setAtmState (new CardInserted ());
}

@Override
public void ejectCard (AtmSystem context) {
	context.setCard (null);
	context.setAtmState (this);

}

@Override
public void enterPin (AtmSystem context,String pin) {
	
	throw new IllegalStateException ("you cant entre pin in idle  state");

}

@Override
public void enterChoice (AtmSystem context, Transactiontype transactiontype) {
	
	throw new IllegalStateException ("you cant select the transaction in idel state");
	

}
}
