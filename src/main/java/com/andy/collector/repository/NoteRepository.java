package com.andy.collector.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.andy.collector.repository.model.NoteDao;

@Repository
public interface NoteRepository extends MongoRepository<NoteDao, Integer>{
}
