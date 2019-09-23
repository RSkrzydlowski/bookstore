package pl.skrzydlowski.bookstore;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import pl.skrzydlowski.bookstore.action.BookGenerator;

public class App extends Application {
	
	public static SessionFactory sessionFactory = new Configuration().configure()
            .buildSessionFactory();
	public static Session session = sessionFactory.openSession();
    public static void main(String[] args) {
    	launch(args);
    }

    
    @Override
	public void start(Stage primaryStage) throws Exception 
	{
		Screen screen = Screen.getPrimary();
		Rectangle2D bounds = screen.getPrimary().getVisualBounds();
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/MainScreen.fxml"));
		StackPane stackPane = loader.load();
		Scene scene = new Scene(stackPane, bounds.getWidth(), bounds.getHeight());
		
		BookGenerator bookGenerator = new BookGenerator();
		bookGenerator.generateBooks();
		primaryStage.setX(bounds.getMinX());
		primaryStage.setY(bounds.getMinY());
		primaryStage.setWidth(bounds.getWidth());
		primaryStage.setHeight(bounds.getHeight());
		primaryStage.setScene(scene);
		primaryStage.setTitle("Bookstore");
		primaryStage.setMaximized(true);
		primaryStage.show();
		
	}
    
    
}