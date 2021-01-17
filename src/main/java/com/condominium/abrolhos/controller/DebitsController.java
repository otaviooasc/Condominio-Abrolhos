package com.condominium.abrolhos.controller;

import java.net.URI;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.condominium.abrolhos.dto.DebitsDto;
import com.condominium.abrolhos.entity.Debits;
import com.condominium.abrolhos.service.DebitsService;

@RestController
@RequestMapping("/debits")
@CrossOrigin(origins = "http://localhost:4200")
public class DebitsController {

    @Autowired
    DebitsService service;

    @SuppressWarnings("unchecked")
	@GetMapping("/list")
    public ResponseEntity<List<Debits>> list() {
        List<Debits> list = service.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Debits> findById(@PathVariable("id") Long id){
        if(!service.existsById(id)) {
            return new ResponseEntity("Id not found", HttpStatus.NOT_FOUND);
        }
        Debits debits = service.findOneById(id).get();
        return new ResponseEntity(debits, HttpStatus.OK);
    }

    @GetMapping("/detailname/{name}")
    public ResponseEntity<?> findById(@PathVariable("name") String name){
        if(service.findByName(name).isEmpty()){
            return new ResponseEntity("Name invalid", HttpStatus.NOT_FOUND);
        }
        Debits debits = service.findByName(name).get();
        return new ResponseEntity(debits, HttpStatus.OK);
    }
    
    
    @PostMapping
	public ResponseEntity<DebitsDto> insert(@RequestBody DebitsDto dto) {
    	if(service.findByName(dto.getName()).isEmpty()) {
    		dto = service.insert(dto);
    		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
    				.buildAndExpand(dto.getId()).toUri();
    		return ResponseEntity.created(uri).body(dto);    		
    	}else {
    		return new ResponseEntity("Name exists", HttpStatus.BAD_REQUEST);
    	}
	}
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id){
    	if(service.existsById(id)) {
    		service.delete(id);
    		return new ResponseEntity("Successfully deleted", HttpStatus.OK);
    	}else {
    		return new ResponseEntity("Not Found", HttpStatus.NOT_FOUND);
    	}
    }
}
