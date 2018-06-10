package fx_lightSystem.view;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import fx_lightSystem.dto.sql_house;
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
import javafx.stage.Stage;

 
public class house_contoller implements Initializable	{
	
	@FXML private Button btlogin;
	@FXML private TextField texid;
	@FXML private TextField texpw;
	@FXML private Label lbloginment;
 
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		btlogin.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				try {handleBtloginAction(event);} 
				catch (IOException e) {e.printStackTrace();}}});
	}
	
	public void handleBtnCancelAction(ActionEvent event) {
		Platform.exit();
	}
	
	public void handleBtloginAction(ActionEvent event) throws IOException {
		sql_house.dbcheck_in();
		String id = texid.getText(); 	String pw = texpw.getText();
		String url = "jdbc:mysql://localhost:3306/mytest";
		String sqlid = "root";
		String sqlpass= "qwer";
		String query;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; 
		Connection conn = null;
		
		query = "select * from login"; 
		  
		  try {
		   conn = DriverManager.getConnection(url, sqlid, sqlpass);
		   stmt = conn.createStatement();
		   rs = stmt.executeQuery(query);
		   
		   while (rs.next())
		   {
			   if(id.equals(rs.getString("id")) && pw.equals(rs.getString("pw"))) 
				{
					lbloginment.setText("로그인 성공!");
					Stage primaryStage = new Stage();
					Parent root1 = FXMLLoader.load(getClass().getResource("house_lights.fxml"));
					Scene scene = new Scene(root1);
					
					primaryStage.setTitle("Controll My House ver0.01");
					primaryStage.setWidth(710);       
					primaryStage.setHeight(470);      
					primaryStage.setResizable(false); 
					primaryStage.setScene(scene);
					primaryStage.show();
					 
					return;
				}else {lbloginment.setText("다시 로그인하셈!");}
		   	}
		   	rs.close();
		   	stmt.close();
		   	conn.close();
	  } catch (SQLException ee) {
	   System.err.println("error = " + ee.toString());
	  }

	}
	
	
}
