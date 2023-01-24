package gestioneventi;

import java.time.LocalDate;

import dao.EventoDAO;
import model.TipoEvento;

public class App extends EventoDAO {

	public static void main(String[] args) {
		
		boolean insertEvent = true;
		boolean deleteEvent = false;
		boolean getEvent = false;
		boolean updateEvent = false;
		
		if( insertEvent ) {
			insertEvent("Evento 1", LocalDate.parse("2023-04-21"), "Descrizione evento 1", TipoEvento.PUBBLICO, 1000);
			insertEvent("Evento 2", LocalDate.parse("2023-05-22"), "Descrizione evento 2", TipoEvento.PUBBLICO, 150);
			insertEvent("Evento 3", LocalDate.parse("2024-01-26"), "Descrizione evento 3", TipoEvento.PRIVATO, 30);
		}
		
		if( deleteEvent ) {
			deleteEventById(2);
		}
		
		if( updateEvent ) {
			updateEventById(4, "Festa di compleanno Gaetano", LocalDate.parse("2023-12-08"), "Vi aspetto alla mia festa!", TipoEvento.PRIVATO, 25);
		}
		
		if( getEvent ) {
			getEventById(4);
		}

	}

}
