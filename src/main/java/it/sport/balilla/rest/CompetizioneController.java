package it.sport.balilla.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.sport.balilla.entity.Competizione;
import it.sport.balilla.repository.CompetizioneRepository;

@RestController
public class CompetizioneController {

	@Autowired
	private CompetizioneRepository competizioneRepository;
	
	@GetMapping (path = "/competizione")
	public Iterable<Competizione> getAllLeghe () {
		return competizioneRepository.findAll();
	}
	
	@GetMapping (path = "/competizione/{idCompetizione}")
	public ResponseEntity<Competizione> getCompetizione (@PathVariable(name = "idCompetizione") int idCompetizione) {
		Optional<Competizione> competizioneOpt = competizioneRepository.findById(idCompetizione);
		return ResponseEntity.of (competizioneOpt);
	}
	
	@PutMapping (path = "/competizione")
	public ResponseEntity<Competizione> updateCompetizione ( @RequestBody Competizione competizione) {
		Optional<Competizione> compOptional = competizioneRepository.findById(competizione.getId());
		if (compOptional.isPresent()) {
			compOptional.get().setNome(competizione.getNome());
			return ResponseEntity.ok(compOptional.get());
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping (path = "/competizione")
	public ResponseEntity<Competizione> insertCompetizione (@RequestBody Competizione competizione) {
		competizione = competizioneRepository.save(competizione);
		return ResponseEntity.created(null).build();
	}
	
	@DeleteMapping (path = "/competizione/{idCompetizione}")
	public ResponseEntity<Competizione> deleteCompetizione (@PathVariable(name = "idCompetizione") int idCompetizione) {
		Optional<Competizione> compOptional = competizioneRepository.findById(idCompetizione);
		if (compOptional.isPresent()) {
			competizioneRepository.deleteById(idCompetizione);
			return ResponseEntity.ok().build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
}
