package it.sport.balilla.entity;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Partita {

	@Id
	private int id;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn
	private Giocatore giocA1;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn
	private Giocatore giocA2;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn
	private Giocatore giocB1;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn
	private Giocatore giocB2;
	
	@Column
	private int giornata;
	
	@Column
	private boolean giocata;
	
	@Column
	private short vincitore;
	
	@Column
	private Date data;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Giocatore> getVincitori (){
		if (giocata) {
			if (vincitore == 1) {
				return Arrays.asList(giocA1, giocA2);
			}
			else {
				return Arrays.asList(giocB1, giocB2);
			}
		}
		return Arrays.asList();
	}
	public List<Giocatore> getPerdenti (){
		if (giocata) {
			if (vincitore == 1) {
				return Arrays.asList(giocB1, giocB2);
			}
			else {
				return Arrays.asList(giocA1, giocA2);
			}
		}
		return Arrays.asList();
	}
	public int getGiornata() {
		return giornata;
	}
	public void setGiornata(int giornata) {
		this.giornata = giornata;
	}
	public boolean isGiocata() {
		return giocata;
	}
	public void setGiocata(boolean giocata) {
		this.giocata = giocata;
	}
	public short getVincitore() {
		return vincitore;
	}
	public void setVincitore(short vincitore) throws Exception {
		if (vincitore==1 || vincitore==2) {
			this.vincitore = vincitore;
		}
		throw new Exception();
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Giocatore getGiocA1() {
		return giocA1;
	}
	public void setGiocA1(Giocatore giocA1) {
		this.giocA1 = giocA1;
	}
	public Giocatore getGiocA2() {
		return giocA2;
	}
	public void setGiocA2(Giocatore giocA2) {
		this.giocA2 = giocA2;
	}
	public Giocatore getGiocB1() {
		return giocB1;
	}
	public void setGiocB1(Giocatore giocB1) {
		this.giocB1 = giocB1;
	}
	public Giocatore getGiocB2() {
		return giocB2;
	}
	public void setGiocB2(Giocatore giocB2) {
		this.giocB2 = giocB2;
	}
	
	@Override
	public boolean equals(Object that) {
		if (that instanceof Partita) {
			boolean uguali = teamString(this, 1).equals(teamString(that, 1)) &&
					teamString(this, 2).equals(teamString(that, 2));
			uguali = uguali || teamString(this, 1).equals(teamString(that, 2)) &&
					teamString(this, 2).equals(teamString(that, 1));
			return uguali;
		}
		return super.equals(that);
	}
	
	@Override
	public int hashCode() {
		int t1 = giocA1.getId()+giocA2.getId();
		int t2 = giocB1.getId()+giocB2.getId();
		if (t1>t2) {
			return t1+1000*t2;
		}
		else {
			return t2+1000*t1;
		}
	}
	
	private String teamString (Object that, int i) {
		if (that instanceof Partita) {
			Partita p = (Partita) that;
			int part1, part2;
			if (i==1) {
				part1 = p.giocA1.getId();
				part2 = p.giocA2.getId();
			}
			else {
				part1 = p.giocB1.getId();
				part2 = p.giocB2.getId();
			}
			if (part1>part2) {
				int t = part2;
				part2 = part1;
				part1 = t;
			}
			return part1+"_"+part2;
		}
		return "";
	}
	
	@Override
	public String toString() {
		return String.format("%d & %d vs %d & %d",
				giocA1.getId(), giocA2.getId(), giocB1.getId(), giocB2.getId());
	}
}
