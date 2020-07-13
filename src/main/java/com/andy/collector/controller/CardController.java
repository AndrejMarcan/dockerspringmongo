package com.andy.collector.controller;

/**
 * RestController class for card endpoints.
 * 
 * @version		0.1 14. July 2020
 * @author 		Andrej Marcan
 */
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andy.collector.dto.CardDTO;
import com.andy.collector.dto.MonsterCardDTO;
import com.andy.collector.dto.SpellCardDTO;
import com.andy.collector.dto.TrapCardDTO;
import com.andy.collector.service.CardService;
import com.andy.collector.service.NoteService;

import io.swagger.v3.oas.annotations.Hidden;

@RestController
@RequestMapping("/collector")
public class CardController {
		private final CardService cardService;
		private final NoteService noteService;
		
	CardController(@Autowired CardService cardService, @Autowired NoteService noteService){
		this.cardService = cardService;
		this.noteService = noteService;
	}
	
	@PostMapping(value = "/spell-add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addCard(@RequestBody SpellCardDTO spellCardDTO) throws SQLException {
		
		try {
			cardService.addNewCard(spellCardDTO);
			return new ResponseEntity<String>("spell saved",HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.CONFLICT);
		}
	}
	
	@PostMapping(value = "/trap-add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addCard(@RequestBody TrapCardDTO trapCardDTO) throws SQLException {
		
		try {
			cardService.addNewCard(trapCardDTO);
			return new ResponseEntity<String>("trap saved",HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.CONFLICT);
		}
		
	}
	
	@PostMapping(value = "/monster-add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addCard(@RequestBody MonsterCardDTO monsterCardDTO) throws SQLException {
		
		try {
			cardService.addNewCard(monsterCardDTO);
			return new ResponseEntity<String>("monster saved",HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.CONFLICT);
		}
	}
	
	@PutMapping(value = "/edit-monster/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateCard(@PathVariable("id") String id, @RequestBody MonsterCardDTO cardDTO) throws SQLException {

		try {
			cardService.editCard(cardDTO, Integer.valueOf(id));
			return new ResponseEntity<String>("monster edited",HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("card not found",HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(value = "/edit-trap-card/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateCard(@PathVariable("id") String id, @RequestBody TrapCardDTO cardDTO) throws SQLException {

		try {
			cardService.editCard(cardDTO, Integer.valueOf(id));
			return new ResponseEntity<String>("trap edited",HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("card not found",HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(value = "/edit-spell-card/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateCard(@PathVariable("id") String id, @RequestBody SpellCardDTO cardDTO) throws SQLException {

		try {
			cardService.editCard(cardDTO, Integer.valueOf(id));
			return new ResponseEntity<String>("spell edited",HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("card not found",HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteCard(@PathVariable("id") String id){
		
		try {
			noteService.deleteAllNotesForCardId(Integer.valueOf(id));
			cardService.deleteCardById(Integer.valueOf(id));
			return new ResponseEntity<String>("delete succesful",HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("card not found",HttpStatus.NOT_FOUND);
		}
	}
	
	@Hidden
	@DeleteMapping(value = "/delete/ALL", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteAllCard(){
		try {
			cardService.deleteAll();
			return new ResponseEntity<String>("ALL CARDS WERE DELETED",HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value = "/show-all-cards", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CardDTO>> showAllCards() throws SQLException {
		List<CardDTO> cards = cardService.getAllCards();
		
		if(cards != null) {
			return new ResponseEntity<List<CardDTO>> (cards, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<CardDTO>> (HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping(value = "/show-card/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CardDTO> showCardById(@PathVariable("id") String id) throws SQLException {
		CardDTO cardDTO = cardService.findCardById(Integer.valueOf(id));
		
		if(cardDTO != null) {
			return new ResponseEntity<CardDTO> (cardDTO, HttpStatus.OK);
		} else {
			return new ResponseEntity<CardDTO> (HttpStatus.NOT_FOUND);
		}		
	}
	
	
}
