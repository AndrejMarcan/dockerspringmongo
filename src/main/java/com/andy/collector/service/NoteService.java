package com.andy.collector.service;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andy.collector.dto.CardDTO;
import com.andy.collector.dto.NoteDTO;
import com.andy.collector.repository.NoteRepository;
import com.andy.collector.repository.model.NoteDao;

import ma.glasnost.orika.MapperFacade;

/**
 * Service class for note objects. 
 * 
 * @version		0.1 14. July 2020
 * @author 		Andrej Marcan
 */

@Service
public class NoteService {
	@Autowired
	private NoteRepository noteRepository;
	
	@Autowired
	private CardService cardService;
	
	private MapperFacade mapper;
	
	public NoteService(@Autowired MapperService mapperService) {
		this.mapper = mapperService.getFacadeMongo();
	}
	
	//add new note to card
	public void addNoteToCard(NoteDTO noteDTO, Integer id) {
		noteDTO.setIdCard(id);
		
		NoteDao note = mapper.map(noteDTO, NoteDao.class);		
		CardDTO cardDTO = cardService.findCardById(id);
		Collection<NoteDTO> notesDTO = cardDTO.getNotes();	
		notesDTO.add(noteDTO);	
		cardDTO.setId(id);
		cardDTO.setNotes(notesDTO);
		
		cardService.editCard(cardDTO, id);
		noteRepository.save(note);
	}
	
	//edit note by id
	public void editNoteByIdCard(NoteDTO noteDTO, int idCard, int id) {	
		noteDTO.setId(id);
	    noteDTO.setIdCard(idCard);	
	    			     
	    CardDTO cardDTO = cardService.findCardById(idCard);
		Collection<NoteDTO> notesDTO = cardDTO.getNotes();	
		notesDTO.remove(getNoteById(id, notesDTO));
		notesDTO.add(noteDTO);
		cardDTO.setId(idCard);
		cardDTO.setNotes(notesDTO);
		
		NoteDao note = mapper.map(noteDTO, NoteDao.class);
		noteRepository.save(note);
		cardService.editCard(cardDTO, idCard);
	}
	
	//delete note from card by id
	public void deleteNoteById(int id_card, int id_note) {
		CardDTO cardDTO = cardService.findCardById(id_card);
		Collection<NoteDTO> notesDTO = cardDTO.getNotes();	
		notesDTO.remove(getNoteById(id_note, notesDTO));
		cardDTO.setNotes(notesDTO);
		
		noteRepository.deleteById(id_note);
		cardService.editCard(cardDTO, id_card);	
	}
	
	//delete all notes from card
	public void deleteAllNotesFromCard(int id_card) {
		CardDTO cardDTO = cardService.findCardById(id_card);
		Collection<NoteDTO> notesDTO = cardDTO.getNotes();	
		notesDTO.clear();
		cardDTO.setNotes(notesDTO);
		
		cardService.editCard(cardDTO, id_card);		
	}
	
	public void deleteAllNotesForCardId(int id_card) {
		CardDTO cardDTO = cardService.findCardById(id_card);
		Collection<NoteDTO> notesDTO = cardDTO.getNotes();	
		notesDTO.stream().forEach(p -> noteRepository.deleteById(p.getId()));
	}
	
	//show note with id
	public NoteDTO showNote(Integer id) {
		Optional<NoteDao> note = noteRepository.findById(id);
		
		if(note.isPresent()) {
			NoteDTO noteDTO = mapper.map(note.get(), NoteDTO.class);
			return noteDTO;
		} else {
			return null;
		}
	}
	
	private NoteDTO getNoteById(int id, Collection<NoteDTO> notes) {
		Predicate<NoteDTO> byId = p -> p.getId()==id;
		return filterNote(byId, notes);
	}
	

	private NoteDTO filterNote(Predicate<NoteDTO> strategy, Collection<NoteDTO> notes) {
		return notes.stream().filter(strategy).findFirst().orElse(null);
	}
	
}
