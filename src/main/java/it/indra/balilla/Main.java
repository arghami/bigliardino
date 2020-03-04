package it.indra.balilla;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import it.indra.balilla.entity.Giocatore;
import it.indra.balilla.entity.Partita;

public class Main {

	public static void main(String[] args) {
		List<Giocatore> players = new ArrayList<Giocatore>();
		
		int LENGTH = 5;
		for (int i=1; i<=LENGTH; i++) {
			players.add(new Giocatore(i));
		}

		HashSet<Partita> partite = new HashSet<Partita>();
		calcolaAbbinamenti (players, partite, 4);
		
		System.out.println(String.format("Generate %d partite", partite.size()));
		partite.forEach( p -> System.out.println(p));
	}

	private static void calcolaAbbinamenti(List<Giocatore> players, HashSet<Partita> partite, int depth, Giocatore... extracted) {
		
		for (int i=0; i<players.size(); i++) {
			if (depth == 1) {
				Giocatore estratto = players.get(i);
				Partita p = new Partita();
				p.setGiocA1(extracted[0]);
				p.setGiocA2(extracted[1]);
				p.setGiocB1(extracted[2]);
				p.setGiocB2(estratto);
				partite.add(p);
			}
			else {
				ArrayList<Giocatore> playersCopy = new ArrayList<Giocatore>(players);
				Giocatore nuovoEstratto = playersCopy.remove(i);
				calcolaAbbinamenti(playersCopy, partite, depth-1, merge(extracted, nuovoEstratto));
			}
		}
		
	}

	private static Giocatore[] merge(Giocatore[] arrayPartenza, Giocatore newElement) {
		Giocatore [] esteso = new Giocatore[arrayPartenza.length +1];
		for (int i=0; i<arrayPartenza.length; i++) {
			esteso[i] = arrayPartenza[i];
		}
		esteso[arrayPartenza.length] = newElement;
		return esteso;
	}
	

}
