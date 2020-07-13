package com.andy.collector.enums;

public enum Editions {
	FE("First Edition", "gold"),
	LE("Limited Edition", "silver"),
	UE("Unlimited Edition", "silver");
	
	private String edition;
	private String color;

	
	Editions(String edition, String color){
		this.edition = edition;
		this.color = color;
	}
	
	public String getEdition() {
		return edition;
	}
	
	public String getColor() {
		return color;
	}
	
	public static Editions editionPicker(String edition) {
		Editions editions = null;
		
		switch(edition) {
        case "FE":
        	editions = Editions.FE;
        	break;
        case "UE":
        	editions = Editions.UE;
        	break;
        case "LE":
        	editions = Editions.LE;
        	break;
        }
		return editions;
	}
	
	public static Editions editionPickerLonger(String editionLong) {
		Editions editions = null;
		
		switch(editionLong) {
        case "First Edition":
        	editions = Editions.FE;
        	break;
        case "Unlimited Edition":
        	editions = Editions.UE;
        	break;
        case "Limited Edition":
        	editions = Editions.LE;
        	break;
        }
		return editions;
	}
}
