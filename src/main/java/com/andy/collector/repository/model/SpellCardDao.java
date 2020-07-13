/*
 * Copyright (c) ...
 */
package com.andy.collector.repository.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
/**
 * The SpellCard class provides methods for adding a new spell card to database, edit data for spell card
 * in database and to get data for spell card from the database.    
 * 
 * @version		0.1 14. May 2020
 * @author 		Andrej Marcan
 */

@Document(collection = "Cards")
public class SpellCardDao extends CardDao {
	
	@Field("type")
    private String type;	//card type
    
    public SpellCardDao() {}

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









