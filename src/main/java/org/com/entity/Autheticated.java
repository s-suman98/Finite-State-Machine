package org.com.entity;

import org.com.enums.Transactiontype;
import org.com.model.Card;

public class Autheticated implements  AtmSystemI{

@Override
public void insertCard (AtmSystem context, Card card) {
	
	throw new IllegalStateException ("you cant insert a card in the autheticated state");
	
	
}

@Override
public void ejectCard (AtmSystem context) {
	throw new IllegalStateException ("you cant eject a card in the autheticated state");
	
	
}

@Override
public void enterPin (AtmSystem context, String pin) {
	throw new IllegalStateException ("you cant enter a pin in alredy authnticaetd");
	
}

@Override
public void enterChoice (AtmSystem context, Transactiontype transactiontype) {
	
	
	context.setAtmState (new Transacting (context));
	
	
	
	
	
}
}
