package fx_lightSystem;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class house_main extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("view/mainpage.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("Controll My House ver0.01");
		primaryStage.setWidth(710);
		primaryStage.setHeight(470);
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);

	}

}