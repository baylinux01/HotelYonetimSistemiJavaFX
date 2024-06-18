package kodcu.hotelManagementSystemJavaFXMaven;

import java.sql.SQLException;

import javafx.application.Application;
import javafx.event.ActionEvent;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class AddingRoomWindow extends Application {
	static Dao dao=new Dao();
	static TextField textField=new TextField();
	@Override
	public void start(Stage primaryStage) throws InterruptedException {
		try {
			
			
			Group root = new Group();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			Pane pane=new Pane();
			pane.setPrefSize(340, 340);
			pane.setLayoutX(90);
			pane.setLayoutY(20);
			root.getChildren().add(pane);
			
			Label label=new Label("Enter Room Number");
			label.setPrefSize(200, 20);
			label.setLayoutX(0);
			label.setLayoutY(50);
			pane.getChildren().add(label);
			
			
			textField.setPrefSize(200,20);
			textField.setLayoutX(0);
			textField.setLayoutY(70);
			pane.getChildren().add(textField);
			
			EventHandler<ActionEvent> saveRoomEventHandler=new EventHandler<ActionEvent>() 
			{

				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					int result=0;
					if(textField.getText()!=null&& textField.getText()
							.matches("^[1-9][0-9]{0,}$"))
					{
						try {
							result=dao.insertIntoRoomTable(Long.valueOf(textField.getText()));
						} catch (NumberFormatException | SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						if(result>0)
						{
							Alert alert=new Alert(AlertType.INFORMATION);
							alert.setTitle("Success");
							alert.setHeaderText("Success");
							alert.setContentText("Successfully Completed");
							ButtonType bt=alert.showAndWait().orElse(null);
							if(bt.equals(ButtonType.OK))
							{
								
							}
							return;
						}
						else
						{
							Alert alert=new Alert(AlertType.INFORMATION);
							alert.setTitle("Caution");
							alert.setHeaderText("Caution");
							alert.setContentText("Operation is unsuccessful. "
									+ "Please make sure the data you send to be unique and valid");
							ButtonType bt=alert.showAndWait().orElse(null);
							if(bt.equals(ButtonType.OK))
							{
								
							}
							return;
						}
					}
					else
					{
						Alert alert=new Alert(AlertType.INFORMATION);
						alert.setTitle("Uyarı");
						alert.setHeaderText("Dikkat");
						alert.setContentText("İşlem Başarısız. Girdiğiniz oda numarasının benzersiz olmasına "
								+ "sıfır ile başlamayacak şekilde 1 veya daha "
								+ "büyük olmasına dikkat edip tekrar deneyin");
						ButtonType bt=alert.showAndWait().orElse(null);
						if(bt.equals(ButtonType.OK))
						{
							
						}
						return;
					}
					
					
				}
				
			};
			
			Button saveRoomButton=new Button("Save Room");
			saveRoomButton.setPrefSize(200, 20);
			saveRoomButton.setLayoutX(0);
			saveRoomButton.setLayoutY(110);
			pane.getChildren().add(saveRoomButton);
			saveRoomButton.setOnAction(saveRoomEventHandler);
			
			EventHandler<ActionEvent> goBackToProgramWindowEventHandler=new EventHandler<ActionEvent>() 
			{

				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					Group rootProgramWindow=new Group();
					Scene sceneProgramWindow=new Scene(rootProgramWindow,1200,700);
					Stage stageProgramWindow=new Stage();
					stageProgramWindow.setScene(sceneProgramWindow);
					stageProgramWindow.getIcons().add(
							new Image(ProgramWindow.class
							.getResourceAsStream("hotelLogo.png")));
					
					//stageOpenAidatPayerAddingWindow.show();
					stageProgramWindow.setTitle("Main Page");
					ProgramWindow programWindow=new ProgramWindow();
					try {
						programWindow.start(stageProgramWindow);
//						comboBox.getItems().clear();
//						textField.setText("");
//						textField2.setText("");
//						textField3.setText("");
//						textField4.setText("");
//						passwordField.setText("");
						primaryStage.hide();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}
				
			};
			
			Button goBackToProgramWindowButton=new Button("Go Back");
			goBackToProgramWindowButton.setPrefSize(200, 20);
			goBackToProgramWindowButton.setLayoutX(0);
			goBackToProgramWindowButton.setLayoutY(150);
			pane.getChildren().add(goBackToProgramWindowButton);
			goBackToProgramWindowButton.setOnAction(goBackToProgramWindowEventHandler);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		launch(args);
		
	}

	
}
