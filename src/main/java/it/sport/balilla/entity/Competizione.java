package it.sport.balilla.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import it.sport.balilla.model.PosizioneClassifica;

@Entity
public class Competizione {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column
	private String nome;
	
	@OneToMany (fetch = FetchType.LAZY)
	private List<Partita> partite;
	
	@OneToMany (fetch = FetchType.LAZY, mappedBy = "competizione")
	private List<Giocatore> partecipanti;

	public List<PosizioneClassifica<Giocatore>> calcolaClassifica () {
		HashMap<Giocatore, PosizioneClassifica<Giocatore>> allPosizioni = new HashMap<>();
		for (Giocatore gio: partecipanti) {
			PosizioneClassifica<Giocatore> posizione = new PosizioneClassifica<>();
			posizione.setElemento(gio);
			allPosizioni.put(gio, posizione);
		}
		for (Partita p: partite) {
			if (p.isGiocata()) {
				allPosizioni.get(p.getVincitori().get(0)).vittoria();
				allPosizioni.get(p.getVincitori().get(1)).vittoria();
				allPosizioni.get(p.getPerdenti().get(0)).sconfitta();
				allPosizioni.get(p.getPerdenti().get(1)).sconfitta();
			}
		}
		List<PosizioneClassifica<Giocatore>> classifica = new ArrayList<>();
		for (PosizioneClassifica<Giocatore> entry: allPosizioni.values()) {
			classifica.add(entry);
		}
		classifica.sort(null);
		return classifica;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Partita> getPartite() {
		return partite;
	}

	public void setPartite(List<Partita> partite) {
		this.partite = partite;
	}

	public List<Giocatore> getPartecipanti() {
		return partecipanti;
	}

	public void setPartecipanti(List<Giocatore> partecipanti) {
		this.partecipanti = partecipanti;
	}
	
}
