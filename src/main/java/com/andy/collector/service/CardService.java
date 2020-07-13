package com.andy.collector.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andy.collector.dto.CardDTO;
import com.andy.collector.dto.MonsterCardDTO;
import com.andy.collector.dto.SpellCardDTO;
import com.andy.collector.dto.TrapCardDTO;
import com.andy.collector.repository.CardRepository;
import com.andy.collector.repository.model.CardDao;
import com.andy.collector.repository.model.MonsterCardDao;
import com.andy.collector.repository.model.SpellCardDao;
import com.andy.collector.repository.model.TrapCardDao;

import ma.glasnost.orika.MapperFacade;

/**
 * Service class for card objects. 
 * 
 * @version		0.1 14. July 2020
 * @author 		Andrej Marcan
 */

@Service
public class CardService {
	private MapperFacade mapperMongo;
	
	@Autowired
	private CardRepository cardRepositoryMongo;
	
	
	CardService(@Autowired MapperService mapperService) {
		this.mapperMongo = mapperService.getFacadeMongo();
	}
	
	
	//add new spell card to DB
	public void addNewCard(CardDTO cardDTO) {
		if(cardDTO.getCardType().equalsIgnoreCase("Monster Card")) {
			addNewMonsterCard(cardDTO);
		} else if(cardDTO.getCardType().equalsIgnoreCase("Spell Card")) {
			addNewSpellCard(cardDTO);
		} else if(cardDTO.getCardType().equalsIgnoreCase("Trap Card")) {
			addNewTrapCard(cardDTO);
		}
	}

	//edit monster card details by ID
	public void editCard(CardDTO cardDTO, int id) {
		if(cardDTO.getCardType().equalsIgnoreCase("Monster Card")) {
			editMonsterCard(cardDTO, id);
		} else if(cardDTO.getCardType().equalsIgnoreCase("Spell Card")) {
			editSpellCard(cardDTO, id);
		} else if(cardDTO.getCardType().equalsIgnoreCase("Trap Card")) {
			editTrapCard(cardDTO, id);
		}
	}
	
	//delete card by id
	public void deleteCardById(int id) {
		cardRepositoryMongo.deleteById(id);
	}
	
	//get list of all cards
	public List<CardDTO> getAllCards(){    
		List<CardDao> cards = new ArrayList<>();
		cards = cardRepositoryMongo.findAll();
		List<CardDTO> cardsDTO = cards.stream().map(p -> mapForFindAll(p)).collect(Collectors.toList());
		
		return cardsDTO;
	}
	
	//delete all cards from db
	public void deleteAll() {
		cardRepositoryMongo.deleteAll();
	}
	
	//get card by id
	public CardDTO findCardById(int id){
		Optional<CardDao> cardOpt = cardRepositoryMongo.findById(id);
		
		if(cardOpt.isPresent()) {		
			CardDao card = cardOpt.get();
			CardDTO cardDTO = mapForFindAll(card);
			return cardDTO;
		} else {
			return null;
		}
	}
	
	//add new spell card to DB
	private void addNewSpellCard(CardDTO cardDTO) {
		CardDao card = mapperMongo.map((SpellCardDTO) cardDTO, SpellCardDao.class);		    
		cardRepositoryMongo.save(card);
	}
		
	//add new spell card to DB
	private void addNewTrapCard(CardDTO cardDTO) {
		CardDao card = mapperMongo.map((TrapCardDTO) cardDTO, TrapCardDao.class);		    
		cardRepositoryMongo.save(card);
	}
		
	//add new spell card to DB
	private void addNewMonsterCard(CardDTO cardDTO) {
		CardDao card = mapperMongo.map((MonsterCardDTO) cardDTO, MonsterCardDao.class);		
		cardRepositoryMongo.save(card);
	}
	
	//edit monster card details by ID
	private void editMonsterCard(CardDTO cardDTO, int id) {
	    MonsterCardDao monsterCard = mapperMongo.map((MonsterCardDTO) cardDTO, MonsterCardDao.class);
	    monsterCard.setId(id);
	    
	    cardRepositoryMongo.save(monsterCard);
	}
	
	//edit spell card details by id
	private void editSpellCard(CardDTO cardDTO, int id) {
	    SpellCardDao spellCard = mapperMongo.map((SpellCardDTO) cardDTO, SpellCardDao.class);
	    spellCard.setId(id);
	    
	    cardRepositoryMongo.save(spellCard);
	}
	
	//edit trap card details by id
	private void editTrapCard(CardDTO cardDTO, int id) {
	    TrapCardDao trapCard = mapperMongo.map((TrapCardDTO) cardDTO, TrapCardDao.class);
	    trapCard.setId(id);
	    
	    cardRepositoryMongo.save(trapCard);
	}
	
	private CardDTO mapForFindAll(CardDao card) {
		CardDTO cardDTO =null;
		
		switch(card.getCardType()) {
			case "Spell Card":
	        	cardDTO = mapperMongo.map((SpellCardDao) card, SpellCardDTO.class);
	        	break;
	        case "Trap Card":
	        	cardDTO = mapperMongo.map((TrapCardDao) card, TrapCardDTO.class);
	        	break;
	        case "Monster Card":
	        	cardDTO = mapperMongo.map((MonsterCardDao) card, MonsterCardDTO.class);
	        	break;
	    	default:
	    		cardDTO = null;
		}	
		return cardDTO;
	}
}
