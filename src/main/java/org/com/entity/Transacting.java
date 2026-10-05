package org.com.entity;

import org.com.enums.Transactiontype;
import org.com.model.Card;

public class Transacting implements  AtmSystemI{




public  Transacting(AtmSystem context)  {
	
	
	try {
		Thread.sleep (5000);;
		
		for(int i=1;i<=5;i++) {
			System.out.println ("TRANSACTING......");
			
		}
	}catch ( Exception e ){
	
	}finally {
		
		context.setAtmState (new TransactionDone ());
		
	}
	
}



@Override
public void insertCard (AtmSystem context, Card card) {
	
	throw new IllegalStateException ("cant take a card in the transacting state");

}

@Override
public void ejectCard (AtmSystem context) {
	throw new IllegalStateException ("cant take a card in the transacting state");

}

@Override
public void enterPin (AtmSystem context,String pin) {
	throw new IllegalStateException ("cant take a card in the transacting state");

}

@Override
public void enterChoice (AtmSystem context, Transactiontype transactiontype) {
	
	System.out.println ("WOO WE have successfully complete your"+transactiontype +"!!!!!!");
	
	context.setAtmState (new TransactionDone ());

}
}
