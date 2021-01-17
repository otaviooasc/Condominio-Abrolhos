package com.condominium.abrolhos.service;

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
		Debits debts = new Debits(null, dto.getName(), dto.getPrice(), dto.getDate());
		debts = repository.save(debts);
		return new DebitsDto(debts);
	}
	
    @Transactional
    public void delete(Long id) {
    	repository.deleteById(id);
    }
}
