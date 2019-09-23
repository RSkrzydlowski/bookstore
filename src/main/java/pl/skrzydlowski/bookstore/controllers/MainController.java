package pl.skrzydlowski.bookstore.controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;

public class MainController 
{

	@FXML
	private StackPane mainStackPane;
	
	
	
	@FXML
	public void initialize()
	{
		loadMenuScreen();
	}
	
	
	public void loadMenuScreen()
	{
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/MenuScreen.fxml"));
		Pane pane = null;
		try {
			pane = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		MenuController menuController = loader.getController();
		menuController.setMainController(this);
		setScreen(pane);
	}
	
	public void setScreen(Pane pane)
	{
		Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
		mainStackPane.setPrefSize(primScreenBounds.getWidth(), primScreenBounds.getHeight());
		mainStackPane.getChildren().clear();
		mainStackPane.getChildren().add(pane);
	}
	
	
	
}
