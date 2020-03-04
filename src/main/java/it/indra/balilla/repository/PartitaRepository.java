package it.indra.balilla.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.indra.balilla.entity.Partita;

@Repository
public interface PartitaRepository extends CrudRepository<Partita, Integer>{

}
