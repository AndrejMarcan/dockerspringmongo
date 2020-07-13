package com.andy.collector.enums;

/**
 * The Rarities enum serves as the list of all possible rarities of the cards.   
 * 
 * @version		0.1 15. May 2020
 * @author 		Andrej Marcan
 */
public enum Rarities {
	COM("Common"),
	RARE("Rare"),
	SUR("Super Rare"),
	UR("Ultra Rare"),
	SR("Secret Rare"),
	ULT("Ultimate Rare"),
	GHOST("Ghost Rare"),
	SP("Special");
	
	private String rarity;
	
	Rarities(String rarity){
		this.rarity = rarity;
	}
	
	public String getRarity() {
		return rarity;
	}
	
	public static Rarities rarityPicker(String rarityShort) {
		Rarities rarity = null;
		
		switch(rarityShort) {
        case "COM":
        	rarity = Rarities.COM;
        	break;
        case "RARE":
        	rarity = Rarities.RARE;
        	break;
        case "SUR":
        	rarity = Rarities.SUR;
        	break;
        case "UR":
        	rarity = Rarities.UR;
        	break;
        case "SR":
        	rarity = Rarities.SR;
        	break;
        case "ULT":
        	rarity = Rarities.ULT;
        	break;
        case "SP":
        	rarity = Rarities.SP;
        	break;
        case "GHOST":
        	rarity = Rarities.GHOST;
        	break;
        }
		return rarity;
	}
	
	public static Rarities rarityPickerLonger(String rarityLong) {
		Rarities rarity = null;
		
		switch(rarityLong) {
        case "Common":
        	rarity = Rarities.COM;
        	break;
        case "Rare":
        	rarity = Rarities.RARE;
        	break;
        case "Super Rare":
        	rarity = Rarities.SUR;
        	break;
        case "Ultra Rare":
        	rarity = Rarities.UR;
        	break;
        case "Secret Rare":
        	rarity = Rarities.SR;
        	break;
        case "Ultimate Rare":
        	rarity = Rarities.ULT;
        	break;
        case "Special":
        	rarity = Rarities.SP;
        	break;
        case "Ghost Rare":
        	rarity = Rarities.GHOST;
        	break;
        }
		return rarity;
	}
}
