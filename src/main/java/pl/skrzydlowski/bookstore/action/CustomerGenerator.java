package pl.skrzydlowski.bookstore.action;

import java.util.List;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import pl.skrzydlowski.bookstore.App;
import pl.skrzydlowski.bookstore.entity.Address;
import pl.skrzydlowski.bookstore.entity.BookInformation;
import pl.skrzydlowski.bookstore.entity.Books;
import pl.skrzydlowski.bookstore.entity.Contact;
import pl.skrzydlowski.bookstore.entity.Customer;

public class CustomerGenerator {
	
	private String firstNames[] = { "Adam", "Adrian", "Albert", "Aleksander", "Bartosz", "B�a�ej", "Bogdan", "Cezary", "Czes�aw", "Dominik", "Damian", "Jan", "Franciszek", "Gustaw", "Grzegorz", "Henryk", "Micha�", "Miko�aj", "Marcin", "Marek", "Piotr", "Pawe�", "Robert", "Rafa�", "Stanis�aw", "Sebastian", "Seweryn", "Wiktor", "Witold", "Wojciech", "Zdzis�aw" };
	private String lastNames[] = { "Kowalski", "Nowak", "Wi�niewski", "Lewandowski", "Kami�ski", "Zawadzki", "W�jcik", "Kowalczyk", "Zieli�ski", "Szyma�ski", "D�browski", "Koz�owski", "Jankowski", "Mazur", "Wojciechowski", "Kwiatkowski", "Krawczyk", "Kaczmarek", "Piotrowski", "Grabowski", "Zaj�c", "Paw�owski", "Michalski", "Kr�l", "Wieczorek", "Jab�o�ski", "Wr�bel", "Nowakowski", "Majewski", "Olszewski", "St�pie�", "Malinowski", "Jaworski", "Adamczyk", "Dudek" };
	private String streetNames[] = {"Agrestowa", "Albatrasowa", "Astronaut�w", "Barytowa", "Bieszczadzka", "Bobrowa", "Boczna", "Brzozowa", "Bukowa", "Cedrowa", "Cicha", "Cisowa", "Cmentarna", "Dereniowa", "Dzia�kowa", "Fabryczna", "Gajowa", "Galenowa", "Jagodowa", "Janowska", "Jarz�bek", "Jasna", "Jod�owa", "Karpacka", "Kasztanowa", "Kryszta�owa", "Krzywa", "Legnicka", "Leszczy�ska", "Le�na", "��kowa", "Miedziana", "Miodowa", "Mleczna" };
	private String cityNames[] = { "Warszawa", "Pozna�", "Zgierz", "Gda�sk", "Ko�obrzeg", "Zielona G�ra", "Rawa Mazowiecka", "Bydgoszcz", "Toru�", "Rzesz�w", "Krak�w", "Wroc�aw", "Gliwice"};
	
	public static final ObservableList<Customer> customerData = FXCollections.observableArrayList();
	
	public void generateCustomers(int count, VBox vBox) {
		String firstName = "";
		String lastName = "";
		String zipCode1, zipCode2, zipCode;
		String street = "", streetNumber = "";
		String city = "";
		String email, phoneNumber;
		int fragmentNumber;
		Random generator = new Random();
		
        App.session.beginTransaction();
        for(int i = 0; i < count; i++) {
        	firstName = firstNames[(int) (generator.nextDouble() * firstNames.length)];
        	lastName = lastNames[(int) (generator.nextDouble() * lastNames.length)];
        	zipCode1 = Integer.toString((int)( generator.nextDouble() * 89) + 10);
        	zipCode2 = Integer.toString((int)( generator.nextDouble() * 500) + 100);
        	zipCode = zipCode1 + "-" + zipCode2;
        	street = streetNames[(int) (generator.nextDouble() * streetNames.length)];
        	streetNumber = Integer.toString((int)( generator.nextDouble() * 199) + 1);
        	city = cityNames[(int) (generator.nextDouble() * cityNames.length)];
        	email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@gmail.com";
        	fragmentNumber = generator.nextInt(300) + 500;
        	phoneNumber = Integer.toString(fragmentNumber);
        	fragmentNumber = generator.nextInt(800) + 100;
        	phoneNumber += "-" + Integer.toString(fragmentNumber);
        	fragmentNumber = generator.nextInt(800) + 100;
        	phoneNumber += "-" + Integer.toString(fragmentNumber);
        	Address address = new Address(city, zipCode, street, streetNumber);
        	
        	Customer customer = new Customer(firstName, lastName, address);
        	Contact contact = new Contact(email, phoneNumber, customer);
        	App.session.save(address);
        	App.session.save(customer);
        	App.session.save(contact);
        	int random = generator.nextInt(10);
        	if (random > 7) {
        		email = lastName.toLowerCase() + "." + firstName.toLowerCase() + "@gmail.com";
        		fragmentNumber = generator.nextInt(300) + 500;
            	phoneNumber = Integer.toString(fragmentNumber);
            	fragmentNumber = generator.nextInt(800) + 100;
            	phoneNumber += "-" + Integer.toString(fragmentNumber);
            	fragmentNumber = generator.nextInt(800) + 100;
            	phoneNumber += "-" + Integer.toString(fragmentNumber);
            	Contact contact2 = new Contact(email, phoneNumber, customer);
            	App.session.save(contact2);
        	}
        }
        
        
        
        
        Query query = App.session.createQuery("from Customer");
        List<Customer> customerList = query.list();
        
        vBox.getChildren().clear();
        
		for (int i = 0; i < customerList.size(); i++) {
			vBox.getChildren().add(new Label(Integer.toString(i + 1) + ". " + customerList.get(i).getFirstName() + " " + customerList.get(i).getLastName()));
		}
		
		
    	
		App.session.getTransaction().commit();
	}
	
	
}
