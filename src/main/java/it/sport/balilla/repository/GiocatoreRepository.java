package it.sport.balilla.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.sport.balilla.entity.Giocatore;

@Repository
public interface GiocatoreRepository extends CrudRepository<Giocatore, Integer>{

}
