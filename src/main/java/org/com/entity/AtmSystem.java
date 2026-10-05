package org.com.entity;


import lombok.Data;
import lombok.Getter;
import org.com.enums.Transactiontype;
import org.com.model.Card;

@Data
public class AtmSystem {

private  AtmSystemI atmState;

private Card card;


public AtmSystem(){
	this.atmState=new Idle ();
}



public void insertCard ( Card card) {
	atmState.insertCard (this,card);
	
}


public void ejectCard () {
	atmState.ejectCard (this);
	
}

public void enterPin ( String pin) {
	
	try {
		atmState.enterPin (this, pin);
		
	}catch ( Exception e ){
		System.out.println (e.getMessage ());
	}
	
}


public void enterChoice ( Transactiontype transactiontype) {
	atmState.enterChoice (this,transactiontype);
	
}
}
