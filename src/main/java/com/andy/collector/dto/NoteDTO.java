package com.andy.collector.dto;

public class NoteDTO {
	private int id;
	private int idCard;
	private String note;
	
	public NoteDTO() {}
	
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdCard() {
		return idCard;
	}

	public void setIdCard(int idCard) {
		this.idCard = idCard;
	}
	
}
