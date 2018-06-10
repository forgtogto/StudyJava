package fx_lightSystem.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
 
public class room_controller implements Initializable	{
	
	@FXML private Button bt1;
	@FXML private Button bt2;
	@FXML private ImageView base;
	@FXML private Label text1;
	@FXML private Label text2;
	
 
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	//	btlivroom.setOnAction(e->handlebtlivroom(e));
		bt1.setOnAction(e->handlebtback(e));

	}
	
	public void handlebtback(ActionEvent e) {
		 
			try {
				Stage primaryStage = new Stage();
				Parent main= FXMLLoader.load(getClass().getResource("view/living.fxml"));
				Scene scene1 = new Scene(main);
				primaryStage.setTitle("Controll My House ver0.01");
				primaryStage.setWidth(710);       
				primaryStage.setHeight(470);      
				primaryStage.setResizable(false);   
				primaryStage.setScene(scene1);
				primaryStage.show();
				 
			} catch (IOException e1) {e1.printStackTrace();}
			 
 
	}
	public void handleBtnCancelAction(ActionEvent event) {
		Platform.exit();
	}
	
	
}