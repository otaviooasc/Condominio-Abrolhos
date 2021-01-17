package com.condominium.abrolhos.repository;

import com.condominium.abrolhos.entity.Debits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DebitsRepository extends JpaRepository<Debits, Long> {

    Optional<Debits> findByName(String name);
}
