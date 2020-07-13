/*
 * Copyright (c) ...
 */
package com.andy.collector.repository.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
/**
 * The MonsterCard class provides methods for adding a new monster card to database,
 * edit data for monster card in database and to get data for monster card from the database.
 * 
 * @version		0.1 14. May 2020
 * @author 		Andrej Marcan
 */

@Document(collection = "Cards")
public class MonsterCardDao extends CardDao {
	
	@Field("type")
	private String type;
	
	@Field("summMethod")
	private String summMethod;
	
	@Field("attribute")
	private String attribute;
	
	@Field("atk")
	private String atk;
	
	@Field("def")
	private String def;
	
	@Field("level")
	private String level;

	public MonsterCardDao() {};
    
	  public void setLevel(String level) {
	  this.level = level;
	}
	
	public void setAttribute(String atribute) {
	  this.attribute = atribute;
	}
	
	public void setAtk(String atk) {
	  this.atk = atk;
	}
	
	public void setDef(String def) {
	  this.def = def;
	}
	
	public void setSummMethod(String summMethod) {
	  this.summMethod = summMethod;
	}
	
	public String getAttribute() {
	  return attribute;
	}
	
	public String getLevel() {
	  return level;
	}
	
	public String getAtk() {
	  return atk;
	}
	
	public String getDef() {
	  return def;
	}
	
	public String getSummMethod() {
	  return summMethod;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String getCardType() {
		return "Monster Card";
	}
}



















