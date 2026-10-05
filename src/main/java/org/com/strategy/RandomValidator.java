package org.com.strategy;

import org.com.model.Card;

import java.util.Random;

public class RandomValidator implements CardValidator {

private Random random=new Random ();
@Override
public boolean validateCard (Card card, String pin) {
	
	if (card == null ||
			    card.getCardNo() == null || card.getCardNo().isBlank() ||
			    card.getCardHolderName() == null || card.getCardHolderName().isBlank() ||
			    card.getSecurityCode() == null || card.getSecurityCode().isBlank() || pin.isBlank ()) {
		return false;
	}
	return  random.nextBoolean ();
}
}
