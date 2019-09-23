package pl.skrzydlowski.bookstore.action;

import java.util.List;

import org.hibernate.query.Query;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import pl.skrzydlowski.bookstore.App;
import pl.skrzydlowski.bookstore.entity.Books;
import pl.skrzydlowski.bookstore.entity.Customer;
import pl.skrzydlowski.bookstore.entity.Loan;

public class LoanGenerator {

	private int i = 0;
	
	public void loanGenerator(VBox vBoxLoans) {
		while(i < 20) {
			Query query = App.session.createQuery("from Books");
			List<Books> bookList = query.list();
			query = App.session.createQuery("from Customer");
			List<Customer> customerList = query.list();
			
			int idBook = (int) ((Math.random() * bookList.size()) + 1);
			query = App.session.createQuery("from Books where id=" + idBook);
			List<Books> book = query.list();
			
				int idCustomer = (int) ((Math.random() * customerList.size()) + 1);
				query = App.session.createQuery("from Customer where id=" + idCustomer);
				List<Customer> customer = query.list();
				Loan loan = new Loan(customer.get(0) ,book.get(0));
				App.session.save(loan);
				vBoxLoans.getChildren().add(new Label(customer.get(0).getFirstName() + " " + customer.get(0).getLastName() + " wypo¿yczy³ " + "\"" + book.get(0).getTitle() + "\""));
				i++;
			
		}
	}
}
