package dao;

import java.time.LocalDate;

import model.Evento;
import model.TipoEvento;
import utils.JpaUtil;

public class EventoDAO extends JpaUtil {
	
	public static void insertEvent(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti) {
		
		try {
			Evento e = new Evento();
			e.setTitolo(titolo);
			e.setDataEvento(dataEvento);
			e.setDescrizione(descrizione);;
			e.setTipoEvento(tipoEvento);
			e.setNumeroMassimoPartecipanti(numeroMassimoPartecipanti);
			
			t.begin();
			em.persist(e);
			t.commit();
			
		} catch(Exception e) {
			System.out.println("Errore nell'inserimento dell'evento");
		}
		
	}
	
	public static void getEventById(int id) {
		Evento e = em.find(Evento.class, id);
		
		if(e == null) {
			System.out.println("L'evento con l'id " + id + " non è stato trovato");
			return;
		}
		
		System.out.println("Dati Evento #" + id);
		System.out.printf("Titolo: %s, Data evento: %s, Descrizione: %s, Tipo: %s, Numero massimo partecipanti: %d%n",
				e.getTitolo(), e.getDataEvento(), e.getDescrizione(), e.getTipoEvento(), e.getNumeroMassimoPartecipanti());
	}
	
	public static void deleteEventById(int id) {
		Evento e = em.find(Evento.class, id);
		
		if(e == null) {
			System.out.println("L'evento con l'id " + id + " non è stato trovato");
			return;
		}
		
		t.begin();
		em.remove(e);
		t.commit();
		
		System.out.println("L'evento con l'id " + id + " è stato eliminato");
	}
	
	public static void updateEventById(int id, String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti) {
		Evento e = em.find(Evento.class, id);
		
		if(e == null) {
			System.out.println("L'evento con l'id " + id + " non è stato trovato");
			return;
		}
		
		try {
			e.setTitolo(titolo);
			e.setDataEvento(dataEvento);
			e.setDescrizione(descrizione);
			e.setTipoEvento(tipoEvento);
			e.setNumeroMassimoPartecipanti(numeroMassimoPartecipanti);
			
			t.begin();
			em.persist(e);
			t.commit();
			
			System.out.println("L'evento con l'id " + id + " è stato modificato");
			
		} catch(Exception e1) {
			System.out.println("Errore nell'aggiornamento dell'evento");
		}
		
	}

	
}
