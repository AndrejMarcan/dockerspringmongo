package com.andy.collector.dto;

public class SpellCardDTO extends CardDTO{
	private String type;	//card type

    public SpellCardDTO() {}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String getCardType() {
		return "Spell Card";
	}
}
