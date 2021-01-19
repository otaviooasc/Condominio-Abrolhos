package com.condominium.abrolhos.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.condominium.abrolhos.dto.DebitsDto;
import com.condominium.abrolhos.entity.Debits;
import com.condominium.abrolhos.repository.DebitsRepository;

@Service
public class DebitsService {

    @Autowired
    DebitsRepository repository;

    @Transactional(readOnly = true)
    public List<Debits> list() {
        return repository.findAll();
    }
    
    @Transactional(readOnly = true)
    public Optional<Debits> findOneById(Long id) {
        return repository.findById(id);
    }
    
    @Transactional(readOnly = true)
    public boolean existsById(Long id) {
        if(repository.findById(id).isEmpty()){
            return false;
        }
        return true;
    }
    
    @Transactional(readOnly = true)
    public Optional<Debits> findByName(String name) {
        return repository.findByName(name);
    }
    
    @Transactional(readOnly = true)
    public void deleteById(Long id) {
    	repository.deleteById(id);
    }
    
    @Transactional
	public DebitsDto insert(DebitsDto dto){
    	LocalDate date = LocalDate.now();
		Debits debts = new Debits(null, dto.getName(), dto.getPrice(), String.valueOf(date), null);
		debts = repository.save(debts);
		return new DebitsDto(debts);
	}
	
    @Transactional
    public void delete(Long id) {
    	repository.deleteById(id);
    }
    
    @Transactional
    public DebitsDto update(Long id) {
    	Debits debits = repository.getOne(id);
    	debits = repository.save(debits);
    	return new DebitsDto(debits);
    }
    
    @Transactional
    public DebitsDto setPaidOut(Long id) {
    	Debits entity = repository.getOne(id);
    	entity.setPayday(String.valueOf(LocalDate.now()));
    	entity = repository.save(entity);
    	return new DebitsDto(entity);
    }
}
