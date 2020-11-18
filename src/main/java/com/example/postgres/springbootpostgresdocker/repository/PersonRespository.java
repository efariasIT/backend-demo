package com.example.postgres.springbootpostgresdocker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.postgres.springbootpostgresdocker.entity.PersonModel;

/**
 * @author efarias
 *
 */
@Repository
public interface PersonRespository extends JpaRepository<PersonModel, Long>{

}
