package com.andy.collector.dto;

public class TrapCardDTO extends CardDTO{
	private String type; //card type
    
    public TrapCardDTO() {};
    
    
    public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String getCardType() {
		return "Trap Card";
	}
}
