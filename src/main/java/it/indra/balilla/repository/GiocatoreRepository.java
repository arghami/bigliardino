package it.indra.balilla.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.indra.balilla.entity.Giocatore;

@Repository
public interface GiocatoreRepository extends CrudRepository<Giocatore, Integer>{

}
