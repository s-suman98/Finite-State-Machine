package org.com.model;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Card {

private  String cardNo;
private  String cardHolderName;
private String securityCode;
}
