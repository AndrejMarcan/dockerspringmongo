package com.andy.collector.dto;

public class MonsterCardDTO extends CardDTO{
	private String type;
	private String summMethod;
	private String attribute;
	private String atk;
	private String def;
	private String level;

	public MonsterCardDTO() {};
    
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
