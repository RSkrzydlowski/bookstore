package pl.skrzydlowski.bookstore.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.TreeMap;

import org.hibernate.query.Query;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import pl.skrzydlowski.bookstore.App;
import pl.skrzydlowski.bookstore.action.BookGenerator;
import pl.skrzydlowski.bookstore.action.CustomerGenerator;
import pl.skrzydlowski.bookstore.action.LoanGenerator;
import pl.skrzydlowski.bookstore.entity.BookInformation;
import pl.skrzydlowski.bookstore.entity.Books;
import pl.skrzydlowski.bookstore.entity.Customer;

public class MenuController {

	private MainController mainController;

	public static final ObservableList<Customer> salaryData = FXCollections.observableArrayList();

	@FXML
	private VBox vBoxCustomers, vBoxBooks, vBoxLoans;
	@FXML
	private ComboBox<String> typeBox;

	private String type = "";

	@FXML
	public void initialize() {
		typeBox.getItems().addAll("Wszystkie", "Informatyka", "Biografia", "Poradnik", "Literatura Obyczajowa");
		typeBox.getSelectionModel().selectFirst();
	}

	@FXML
	public void generateData() {
		CustomerGenerator customerGenerator = new CustomerGenerator();
		customerGenerator.generateCustomers(1000, vBoxCustomers);
		LoanGenerator loanGenerator = new LoanGenerator();
		loanGenerator.loanGenerator(vBoxLoans);
	}

	@FXML
	public void typeBoxAction() {
		type = typeBox.getSelectionModel().getSelectedItem();
		vBoxBooks.getChildren().clear();
		if (type.equals("Wszystkie")) {
			Query query = App.session.createQuery("from Books b");
			List<Books> bookList = query.list();
			for(int i = 0; i < bookList.size(); i++) {
				vBoxBooks.getChildren().add(new Label(bookList.get(i).getTitle()));
			}
		} else {
			Query query = App.session.createQuery("from BookInformation where type='" + type + "'");
			List<BookInformation> bookInformationList = query.list();
			List<Integer> listInt = new LinkedList<Integer>();
			for(int i = 0; i < bookInformationList.size(); i++) {
				listInt.add((int) bookInformationList.get(i).getId());
			}
			for(int i = 0; i < listInt.size(); i++) {
				query = App.session.createQuery("from Books where id=" + listInt.get(i));
				List<Books> bookList = query.list();
				vBoxBooks.getChildren().add(new Label(bookList.get(0).getTitle()));
			}
			
		}
		
	}

	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}
}
