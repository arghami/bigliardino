package it.indra.balilla.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.indra.balilla.entity.Competizione;

@Repository
public interface CompetizioneRepository extends CrudRepository<Competizione, Integer>{

}
