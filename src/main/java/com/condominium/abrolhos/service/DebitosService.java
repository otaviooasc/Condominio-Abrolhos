package com.condominium.abrolhos.service;

import com.condominium.abrolhos.entity.Debitos;
import com.condominium.abrolhos.repository.DebitosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DebitosService {

    @Autowired
    DebitosRepository repository;

    public List<Debitos> list() {
        return repository.findAll();
    }

    public Optional<Debitos> findOneById(Long id) {
        return repository.findById(id);
    }

    public boolean existsById(Long id) {
        if(repository.findById(id).isEmpty()){
            return false;
        }
        return true;
    }
}
