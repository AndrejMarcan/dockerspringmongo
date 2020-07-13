package com.andy.collector.service;

import org.springframework.stereotype.Service;

import com.andy.collector.dto.CardDTO;
import com.andy.collector.dto.MonsterCardDTO;
import com.andy.collector.dto.NoteDTO;
import com.andy.collector.dto.SpellCardDTO;
import com.andy.collector.dto.TrapCardDTO;
import com.andy.collector.dto.UserDTO;
import com.andy.collector.repository.model.CardDao;
import com.andy.collector.repository.model.MonsterCardDao;
import com.andy.collector.repository.model.NoteDao;
import com.andy.collector.repository.model.SpellCardDao;
import com.andy.collector.repository.model.TrapCardDao;
import com.andy.collector.repository.model.UserDao;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

@Service
public class MapperService {
	private MapperFactory factoryMongo;
	
	MapperService(){
		factoryMongo = new DefaultMapperFactory.Builder().build();
		
		
		//mongo dao 
		factoryMongo.classMap(CardDTO.class, CardDao.class).byDefault().register();
		factoryMongo.classMap(SpellCardDTO.class, SpellCardDao.class).byDefault().register();
		factoryMongo.classMap(TrapCardDTO.class, TrapCardDao.class).byDefault().register();
		factoryMongo.classMap(MonsterCardDTO.class, MonsterCardDao.class).byDefault().register();
		factoryMongo.classMap(UserDTO.class, UserDao.class).byDefault().register();
		factoryMongo.classMap(NoteDTO.class, NoteDao.class).byDefault().register();
	}

	public MapperFacade getFacadeMongo() {
		return factoryMongo.getMapperFacade();
	}

	public MapperFactory getFactoryMongo() {
		return factoryMongo;
	}

	public void setFactoryMongo(MapperFactory factory) {
		this.factoryMongo = factory;
	}
	
	
}
