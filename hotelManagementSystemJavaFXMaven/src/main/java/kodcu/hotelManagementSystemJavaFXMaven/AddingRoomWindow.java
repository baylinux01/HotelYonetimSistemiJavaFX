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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class AddingRoomWindow extends Application {
	static Dao dao=new Dao();
	static TextField textField=new TextField();
	protected static String language;
	protected static ComboBox<String> cblanguage;
	protected static Label label,labelB;
	protected static TextField textFieldA,textFieldB;
	protected static Button button, button1,goBackToProgramWindowButton,saveRoomButton;
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
			
			
			EventHandler<ActionEvent> changeLanguageEventHandler=new EventHandler<ActionEvent>() 
			{
				@Override
				public void handle(ActionEvent event) 
				{
					language=cblanguage.getValue();
					if(language.equals("English"))
					{
						label.setText("Enter Room Number");
						saveRoomButton.setText("Save Room");
						goBackToProgramWindowButton.setText("Go Back");
						primaryStage.setTitle("Room Adding Page");
						
					}
					if(language.equals("Türkçe"))
					{
						label.setText("Oda no giriniz");
						saveRoomButton.setText("Odayı Kaydet");
						goBackToProgramWindowButton.setText("Geri Dön");
						primaryStage.setTitle("Oda Ekleme Sayfası");
					}
					
					
				}
			};
			cblanguage=new ComboBox<String>();
			cblanguage.setPrefSize(100, 20);
			cblanguage.setLayoutX(210);
			cblanguage.setLayoutY(0);
			cblanguage.getItems().addAll("English","Türkçe");
			if(language.equals("English"))
			cblanguage.getSelectionModel().select(0);
			if(language.equals("Türkçe"))
			cblanguage.getSelectionModel().select(1);
			cblanguage.setOnAction(changeLanguageEventHandler);
			pane.getChildren().add(cblanguage);
			
			label=new Label("Enter Room Number");
			if(language!=null && language.equals("Türkçe"))
				label.setText("Oda no giriniz");
			if(language!=null && language.equals("English"))
				label.setText("Enter Room Number");
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
							if(language.equals("English"))
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
							if(language.equals("Türkçe"))
							{
								Alert alert=new Alert(AlertType.INFORMATION);
								alert.setTitle("İşlem Başarılı");
								alert.setHeaderText("İşlem Başarılı");
								alert.setContentText("İşlem başarıyla tamamlandı");
								ButtonType bt=alert.showAndWait().orElse(null);
								if(bt.equals(ButtonType.OK))
								{
									
								}
								return;
							}
							
						}
						else
						{
							if(language.equals("English"))
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
							if(language.equals("Türkçe"))
							{
								Alert alert=new Alert(AlertType.INFORMATION);
								alert.setTitle("Dikkat");
								alert.setHeaderText("Dikkat");
								alert.setContentText("Operasyon başarısız. "
										+ "Lütfen girdiğiniz sayının eşsiz ve geçerli olduğundan emin olun");
								ButtonType bt=alert.showAndWait().orElse(null);
								if(bt.equals(ButtonType.OK))
								{
									
								}
								return;
							}
							
						}
					}
					else
					{
						if(language.equals("English"))
						{
							
							Alert alert=new Alert(AlertType.INFORMATION);
							alert.setTitle("Uyarı");
							alert.setHeaderText("Dikkat");
							alert.setContentText("Unsuccessful. Please make sure that the number is unique and "
									+ "is a number starting without zero ");
							ButtonType bt=alert.showAndWait().orElse(null);
							if(bt.equals(ButtonType.OK))
							{
								
							}
							return;
						}
						if(language.equals("Türkçe"))
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
					
					
				}
				
			};
			
			saveRoomButton=new Button("Save Room");
			if(language!=null && language.equals("Türkçe"))
				saveRoomButton.setText("Odayı Kaydet");
			if(language!=null && language.equals("English"))
				saveRoomButton.setText("Save Room");
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
					Scene sceneProgramWindow=new Scene(rootProgramWindow,1300,700);
					Stage stageProgramWindow=new Stage();
					stageProgramWindow.setScene(sceneProgramWindow);
					stageProgramWindow.getIcons().add(
							new Image(ProgramWindow.class
							.getResourceAsStream("hotelLogo.png")));
					
					//stageOpenAidatPayerAddingWindow.show();
					
					ProgramWindow programWindow=new ProgramWindow();
					try {
						programWindow.language=language;
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
			
			goBackToProgramWindowButton=new Button("Go Back");
			if(language!=null && language.equals("Türkçe"))
				goBackToProgramWindowButton.setText("Geri Dön");
			if(language!=null && language.equals("English"))
				goBackToProgramWindowButton.setText("Go Back");
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
