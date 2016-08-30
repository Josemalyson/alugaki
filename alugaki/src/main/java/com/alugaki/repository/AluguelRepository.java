package com.alugaki.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alugaki.model.Aluguel;

public interface AluguelRepository extends JpaRepository<Aluguel, Long> {

}
