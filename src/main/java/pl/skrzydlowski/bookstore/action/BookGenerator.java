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
		bookList.add(new Books("Niewidzialny w sieci. Sztuka zacierania �lad�w", 
				"Mitnick Kevin", bookInformationList.get(0)));
		
		bookInformationList.add(new BookInformation("Helion", "Informatyka"));
		bookList.add(new Books("HTML, CSS i JavaScript dla ka�dego ", 
				"Lemay Laura", bookInformationList.get(1)));
		
		bookInformationList.add(new BookInformation("Helion", "Informatyka"));
		bookList.add(new Books("Sztuka podst�pu. �ama�em ludzi, nie has�a ", 
				"Mitnick Kevin", bookInformationList.get(2)));
		
		bookInformationList.add(new BookInformation("Helion", "Informatyka"));
		bookList.add(new Books("Deep Learning. Praca z j�zykiem Python i bibliotek� Keras", 
				"Chollet Francois", bookInformationList.get(3)));
		
		bookInformationList.add(new BookInformation("Naukowe PWN", "Informatyka"));
		bookList.add(new Books("Data Science i uczenie maszynowe", 
				"Szeliga Marcin", bookInformationList.get(4)));
		
		bookInformationList.add(new BookInformation("Naukowe PWN", "Informatyka"));
		bookList.add(new Books("Zrozumie� programowanie", 
				"Coldwind Gynvael", bookInformationList.get(5)));
		
		bookInformationList.add(new BookInformation("Naukowe PWN", "Informatyka"));
		bookList.add(new Books("Wst�p do sztucznej inteligencji", 
				"Flasi�ski Mariusz", bookInformationList.get(6)));
		
		bookInformationList.add(new BookInformation("Wielka Litera", "Biografia"));
		bookList.add(new Books("Brzydki, z�y i szczery", 
				"Ostrowski Adam", bookInformationList.get(7)));
		
		bookInformationList.add(new BookInformation("Insignis", "Biografia"));
		bookList.add(new Books("Steve Jobs", 
				"Isaacson Walter", bookInformationList.get(8)));
		
		bookInformationList.add(new BookInformation("Spo�eczny Instytut Wydawniczy Znak", "Biografia"));
		bookList.add(new Books("Elon Musk. Biografia tw�rcy PayPala, Tesli, SpaceX", 
				"Vance Ashlee", bookInformationList.get(9)));
		
		bookInformationList.add(new BookInformation("Pascal", "Biografia"));
		bookList.add(new Books("Czapkins. Historia Tomka Mackiewicza", 
				"Szczepa�ski Dominik", bookInformationList.get(10)));
	
		bookInformationList.add(new BookInformation("Insignis", "Biografia"));
		bookList.add(new Books("Leonardo da Vinci", 
				"Isaacson Walter", bookInformationList.get(11)));
		
		bookInformationList.add(new BookInformation("Helion", "Poradnik"));
		bookList.add(new Books("Sekrety mistrza fotografii cyfrowej", 
				"Kelby Scott", bookInformationList.get(12)));
		
		bookInformationList.add(new BookInformation("Czarna Owca", "Poradnik"));
		bookList.add(new Books("Jak kochaj� nas psy. Tajemnice psiego m�zgu", 
				"Berns Gregory", bookInformationList.get(13)));
		
		bookInformationList.add(new BookInformation("Kobiece", "Poradnik"));
		bookList.add(new Books("Najnudniejsza ksi��ka �wiata", 
				"McCoy K.", bookInformationList.get(14)));
		
		bookInformationList.add(new BookInformation("Edipresse Ksi��ki", "Literatura Obyczajowa"));
		bookList.add(new Books("365 dni", 
				"Lipi�ska Blanka", bookInformationList.get(15)));
		
		bookInformationList.add(new BookInformation("Edipresse Ksi��ki", "Literatura Obyczajowa"));
		bookList.add(new Books("Kolejne 365 dni", 
				"Lipi�ska Blanka", bookInformationList.get(16)));
		
		bookInformationList.add(new BookInformation("Zwierciad�o", "Literatura Obyczajowa"));
		bookList.add(new Books("Stulecie Winnych", 
				"Grabowska Albena", bookInformationList.get(17)));
		
		bookInformationList.add(new BookInformation("Editio", "Literatura Obyczajowa"));
		bookList.add(new Books("Drwal. Mi�o��, kt�ra narodzi�a si� z natury ", 
				"Haner K.N.", bookInformationList.get(18)));
		
		
		
		for(int i = 0; i < bookInformationList.size(); i++) {
			App.session.save(bookInformationList.get(i));
			App.session.save(bookList.get(i));
		}
    	App.session.getTransaction().commit();
	}
}
