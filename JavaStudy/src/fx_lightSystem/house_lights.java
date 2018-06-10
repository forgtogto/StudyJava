package fx_lightSystem;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class house_lights implements Initializable {
 
	@FXML private Button btlivroom, btlivroomter;
 	@FXML private Button btroom1, btroom1ter;
	@FXML private Button btroom2, btroom2ter;
	@FXML private Button btroom3, btroom3ter;
	@FXML private Button btkitchen, btenterence;
 	
	@FXML private Button btback;
	@FXML private Button btallon;
	@FXML private Button btalloff;
	@FXML private ImageView imageivroom, imagelivroomter;
	@FXML private ImageView imageroom1, imageroom1ter;
	@FXML private ImageView imageroom2, imageroom2ter;
	@FXML private ImageView imageroom3, imageroom3ter;
	@FXML private ImageView imagekitchen, imageenterence;
	@FXML private CheckBox ck1, ck2, ck3, ck4, ck5, ck6, ck7, ck8, ck9, ck10;
							 

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btback.setOnAction(event->handlebtbackAction(event));
		btlivroom.setOnAction(e->handlebtlivroom(e));
	}
	
	public void handlebtlivroom(ActionEvent e) {
		try {
			Parent login= FXMLLoader.load(getClass().getResource("view/living.fxml"));
			StackPane root = (StackPane) btlivroom.getScene().getRoot();
			root.getChildren().add(login);
			
			
			login.setTranslateX(710);
			Timeline timeline = new Timeline();
			KeyValue keyValue = new KeyValue(login.translateXProperty(), 0);
			KeyFrame keyFrame = new KeyFrame(Duration.millis(100), 

			keyValue);
			timeline.getKeyFrames().add(keyFrame);
			timeline.play();
		} catch(Exception e1) {
			e1.printStackTrace();
		} 
		}
 
	public void handlebtonAction(ActionEvent e) {
		ck1.setSelected(true); imageivroom.setVisible(true);
		ck2.setSelected(true); imagelivroomter.setVisible(true);
		ck3.setSelected(true); imageroom1.setVisible(true);
		ck4.setSelected(true); imageroom1ter.setVisible(true);
		ck5.setSelected(true); imageroom2.setVisible(true);
		ck6.setSelected(true); imageroom2ter.setVisible(true);
		ck7.setSelected(true); imageroom3.setVisible(true);
		ck8.setSelected(true); imageroom3ter.setVisible(true);
		ck9.setSelected(true); imagekitchen.setVisible(true);
		ck10.setSelected(true); imageenterence.setVisible(true);
	}	
	public void handlebtoffAction(ActionEvent e) {
		ck1.setSelected(false); imageivroom.setVisible(false);
		ck2.setSelected(false); imagelivroomter.setVisible(false);
		ck3.setSelected(false); imageroom1.setVisible(false);
		ck4.setSelected(false); imageroom1ter.setVisible(false);
		ck5.setSelected(false); imageroom2.setVisible(false);
		ck6.setSelected(false); imageroom2ter.setVisible(false);
		ck7.setSelected(false); imageroom3.setVisible(false);
		ck8.setSelected(false); imageroom3ter.setVisible(false);
		ck9.setSelected(false); imagekitchen.setVisible(false);
		ck10.setSelected(false); imageenterence.setVisible(false);
	}	
	
	
	public void handleChkAction(ActionEvent e) {
		
		if(ck1.isSelected()) {   imageivroom.setVisible(true);	}
		else {ck1.setSelected(false);imageivroom.setVisible(false);	}
		if(ck2.isSelected()) { ck2.setSelected(true); imagelivroomter.setVisible(true);	}
		else {ck2.setSelected(false);imagelivroomter.setVisible(false);	}
		if(ck3.isSelected()) { ck3.setSelected(true); imageroom1.setVisible(true);	}
		else {ck3.setSelected(false);imageroom1.setVisible(false);	}
		if(ck4.isSelected()) { ck4.setSelected(true); imageroom1ter.setVisible(true);	}
		else {ck4.setSelected(false);imageroom1ter.setVisible(false);	}
		if(ck5.isSelected()) { ck5.setSelected(true); imageroom2.setVisible(true);	}
		else {ck5.setSelected(false);imageroom2.setVisible(false);	}
		if(ck6.isSelected()) { ck6.setSelected(true); imageroom2ter.setVisible(true);	}
		else {ck6.setSelected(false);imageroom2ter.setVisible(false);	}
		if(ck7.isSelected()) { ck7.setSelected(true); imageroom3.setVisible(true);	}
		else {ck7.setSelected(false);imageroom3.setVisible(false);	}
		if(ck8.isSelected()) { ck8.setSelected(true); imageroom3ter.setVisible(true);	}
		else {ck8.setSelected(false);imageroom3ter.setVisible(false);	}
		if(ck9.isSelected()) { ck9.setSelected(true); imagekitchen.setVisible(true);	}
		else {ck9.setSelected(false);imagekitchen.setVisible(false);	}
		if(ck10.isSelected()) { ck10.setSelected(true); imageenterence.setVisible(true);	}
		else {ck10.setSelected(false);imageenterence.setVisible(false);	}
	}
 

	public void handlebtbackAction(ActionEvent event) { Platform.exit(); }

}
