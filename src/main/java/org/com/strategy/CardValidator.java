package org.com.strategy;

import org.com.model.Card;

public interface CardValidator {
	
	boolean validateCard(Card card, String pin);
}
