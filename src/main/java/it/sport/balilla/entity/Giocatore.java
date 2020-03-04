package it.sport.balilla.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Giocatore {

	@Id
	private int id;
	
	@Column
	private String nome;
	
	@Column
	private String cognome;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn
	private Competizione competizione;

	public Giocatore() {
	}
	public Giocatore(int i) {
		setId(i);
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
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public Competizione getCompetizione() {
		return competizione;
	}
	public void setCompetizione(Competizione competizione) {
		this.competizione = competizione;
	}
	
}
