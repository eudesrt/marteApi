package com.br.marte.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.marte.api.model.Status;

public interface StatusRepository extends JpaRepository<Status, Long> {

}
