package it.indra.balilla.model;

public class PosizioneClassifica<T> implements Comparable<PosizioneClassifica<T>>{

	private T elemento;
	private int punti;
	private int partiteGiocate;
	private int vittorie;
	private int sconfitte;

	public void vittoria() {
		partiteGiocate ++;
		punti += 2;
		vittorie ++;
	}
	public void sconfitta() {
		partiteGiocate ++;
		sconfitte ++;
	}
	public T getElemento() {
		return elemento;
	}
	public void setElemento(T elemento) {
		this.elemento = elemento;
	}
	public int getPunti() {
		return punti;
	}
	public void setPunti(int punti) {
		this.punti = punti;
	}
	public int getPartiteGiocate() {
		return partiteGiocate;
	}
	public void setPartiteGiocate(int partiteGiocate) {
		this.partiteGiocate = partiteGiocate;
	}
	public int getVittorie() {
		return vittorie;
	}
	public void setVittorie(int vittorie) {
		this.vittorie = vittorie;
	}
	public int getSconfitte() {
		return sconfitte;
	}
	public void setSconfitte(int sconfitte) {
		this.sconfitte = sconfitte;
	}
	@Override
	public int compareTo(PosizioneClassifica<T> o) {
		return this.punti-o.punti;
	}
	
}
