package org.com.enums;

public enum CurrnecyType {
	
	HUNDRED (100),
	FIFTY (50),
	TWENTY (20),
	TEN (10);

private int value;


CurrnecyType (int value) {
	this.value = value;
}

public int getValue () {
	return this.value;
}


}
