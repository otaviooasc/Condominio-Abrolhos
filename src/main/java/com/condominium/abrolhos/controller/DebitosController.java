package com.condominium.abrolhos.controller;

import com.condominium.abrolhos.entity.Debitos;
import com.condominium.abrolhos.service.DebitosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/debitos")
@CrossOrigin(origins = "http://localhost:4200")
public class DebitosController {

    @Autowired
    DebitosService service;

    @GetMapping("/list")
    public ResponseEntity<List<Debitos>> list() {
        List<Debitos> lista = service.list();
        return new ResponseEntity(lista, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Debitos> findById(@PathVariable("id") Long id){
        if(!service.existsById(id)) {
            return new ResponseEntity("Não foi encontrado o id", HttpStatus.NOT_FOUND);
        }
        Debitos debitos = service.findOneById(id).get();
        return new ResponseEntity(debitos, HttpStatus.OK);
    }
}
