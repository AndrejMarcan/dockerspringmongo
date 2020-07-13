package com.andy.collector.dto;

import java.util.ArrayList;
import java.util.Collection;

import com.andy.collector.enums.Editions;
import com.andy.collector.enums.Rarities;

public abstract class CardDTO {
	private int id;
    private String name;
	private Rarities rarity;
	private Editions edition;
	private String set;			
	private String language;	  
	private Collection<NoteDTO> notes = new ArrayList<>();
	private final String cardType = getCardType();
	
	public CardDTO() {}
    
	public abstract String getCardType();
	
    public String getName() {
        return name;
    }
    
    public Rarities getRarity() {
        return rarity;
    }
    
    public Editions getEdition() {
        return edition;
    }
    
    public String getSet() {
        return set;
    }
    
    public String getLanguage() {
        return language;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setRarity(Rarities rarity) {
        this.rarity = rarity;
    }
    
    public void setEdition(Editions edition) {
        this.edition = edition;
    }
    
    public void setSet(String set) {
        this.set = set;
    }
    
    public void setLanguage(String language) {
        this.language=language;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Collection<NoteDTO> getNotes() {
		return notes;
	}

	public void setNotes(Collection<NoteDTO> notes) {
		this.notes = notes;
	}
}
