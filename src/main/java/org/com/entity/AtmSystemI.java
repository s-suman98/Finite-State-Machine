package org.com.entity;

import org.com.enums.Transactiontype;
import org.com.model.Card;

public interface AtmSystemI {
	
	public void insertCard(AtmSystem context ,Card card);
	public  void ejectCard(AtmSystem context);
	public  void enterPin(AtmSystem context,String pin);
	public void enterChoice(AtmSystem context, Transactiontype transactiontype);
	
}
