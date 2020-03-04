package it.sport.balilla.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.sport.balilla.entity.Partita;

@Repository
public interface PartitaRepository extends CrudRepository<Partita, Integer>{

}
