package org.com.entity;

import org.com.enums.Transactiontype;
import org.com.model.Card;

public class TransactionDone implements AtmSystemI{
@Override
public void insertCard (AtmSystem context, Card card) {
	
	throw new IllegalStateException ("cant take a card in the transaction compelte state");

}

@Override
public void ejectCard (AtmSystem context) {
	
	context.setCard (null);
	context.setAtmState (new Idle ());

}

@Override
public void enterPin (AtmSystem context, String pin) {
	
	throw new IllegalStateException ("pin cant be intered in transactioon completed state");

}

@Override
public void enterChoice (AtmSystem context, Transactiontype transactiontype) {
	
	throw new IllegalStateException ("can take choice to do transaction after transaction finish");

}
}
