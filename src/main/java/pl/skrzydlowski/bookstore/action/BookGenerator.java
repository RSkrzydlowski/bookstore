package pl.skrzydlowski.bookstore.action;

import java.util.LinkedList;
import java.util.List;

import pl.skrzydlowski.bookstore.App;
import pl.skrzydlowski.bookstore.entity.BookInformation;
import pl.skrzydlowski.bookstore.entity.Books;

public class BookGenerator {
	
	public void generateBooks() {
		App.session.beginTransaction();
		
		List<BookInformation> bookInformationList = new LinkedList<BookInformation>();
		List<Books> bookList = new LinkedList<Books>();
		
		bookInformationList.add(new BookInformation("Pascal", "Informatyka"));
		bookList.add(new Books("Niewidzialny w sieci. Sztuka zacierania œladów", 
				"Mitnick Kevin", bookInformationList.get(0)));
		
		bookInformationList.add(new BookInformation("Helion", "Informatyka"));
		bookList.add(new Books("HTML, CSS i JavaScript dla ka¿dego ", 
				"Lemay Laura", bookInformationList.get(1)));
		
		bookInformationList.add(new BookInformation("Helion", "Informatyka"));
		bookList.add(new Books("Sztuka podstêpu. £ama³em ludzi, nie has³a ", 
				"Mitnick Kevin", bookInformationList.get(2)));
		
		bookInformationList.add(new BookInformation("Helion", "Informatyka"));
		bookList.add(new Books("Deep Learning. Praca z jêzykiem Python i bibliotek¹ Keras", 
				"Chollet Francois", bookInformationList.get(3)));
		
		bookInformationList.add(new BookInformation("Naukowe PWN", "Informatyka"));
		bookList.add(new Books("Data Science i uczenie maszynowe", 
				"Szeliga Marcin", bookInformationList.get(4)));
		
		bookInformationList.add(new BookInformation("Naukowe PWN", "Informatyka"));
		bookList.add(new Books("Zrozumieæ programowanie", 
				"Coldwind Gynvael", bookInformationList.get(5)));
		
		bookInformationList.add(new BookInformation("Naukowe PWN", "Informatyka"));
		bookList.add(new Books("Wstêp do sztucznej inteligencji", 
				"Flasiñski Mariusz", bookInformationList.get(6)));
		
		bookInformationList.add(new BookInformation("Wielka Litera", "Biografia"));
		bookList.add(new Books("Brzydki, z³y i szczery", 
				"Ostrowski Adam", bookInformationList.get(7)));
		
		bookInformationList.add(new BookInformation("Insignis", "Biografia"));
		bookList.add(new Books("Steve Jobs", 
				"Isaacson Walter", bookInformationList.get(8)));
		
		bookInformationList.add(new BookInformation("Spo³eczny Instytut Wydawniczy Znak", "Biografia"));
		bookList.add(new Books("Elon Musk. Biografia twórcy PayPala, Tesli, SpaceX", 
				"Vance Ashlee", bookInformationList.get(9)));
		
		bookInformationList.add(new BookInformation("Pascal", "Biografia"));
		bookList.add(new Books("Czapkins. Historia Tomka Mackiewicza", 
				"Szczepañski Dominik", bookInformationList.get(10)));
	
		bookInformationList.add(new BookInformation("Insignis", "Biografia"));
		bookList.add(new Books("Leonardo da Vinci", 
				"Isaacson Walter", bookInformationList.get(11)));
		
		bookInformationList.add(new BookInformation("Helion", "Poradnik"));
		bookList.add(new Books("Sekrety mistrza fotografii cyfrowej", 
				"Kelby Scott", bookInformationList.get(12)));
		
		bookInformationList.add(new BookInformation("Czarna Owca", "Poradnik"));
		bookList.add(new Books("Jak kochaj¹ nas psy. Tajemnice psiego mózgu", 
				"Berns Gregory", bookInformationList.get(13)));
		
		bookInformationList.add(new BookInformation("Kobiece", "Poradnik"));
		bookList.add(new Books("Najnudniejsza ksi¹¿ka œwiata", 
				"McCoy K.", bookInformationList.get(14)));
		
		bookInformationList.add(new BookInformation("Edipresse Ksi¹¿ki", "Literatura Obyczajowa"));
		bookList.add(new Books("365 dni", 
				"Lipiñska Blanka", bookInformationList.get(15)));
		
		bookInformationList.add(new BookInformation("Edipresse Ksi¹¿ki", "Literatura Obyczajowa"));
		bookList.add(new Books("Kolejne 365 dni", 
				"Lipiñska Blanka", bookInformationList.get(16)));
		
		bookInformationList.add(new BookInformation("Zwierciad³o", "Literatura Obyczajowa"));
		bookList.add(new Books("Stulecie Winnych", 
				"Grabowska Albena", bookInformationList.get(17)));
		
		bookInformationList.add(new BookInformation("Editio", "Literatura Obyczajowa"));
		bookList.add(new Books("Drwal. Mi³oœæ, która narodzi³a siê z natury ", 
				"Haner K.N.", bookInformationList.get(18)));
		
		
		
		for(int i = 0; i < bookInformationList.size(); i++) {
			App.session.save(bookInformationList.get(i));
			App.session.save(bookList.get(i));
		}
    	App.session.getTransaction().commit();
	}
}
