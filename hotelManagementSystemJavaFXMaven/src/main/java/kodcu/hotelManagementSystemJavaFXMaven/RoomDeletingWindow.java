package kodcu.hotelManagementSystemJavaFXMaven;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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


public class RoomDeletingWindow extends Application {
	static Dao dao=new Dao();
	static TextField textField=new TextField();
	static ComboBox<Long> cb=new ComboBox<Long>();
	protected static String language;
	protected static ComboBox<String> cblanguage;
	protected static Label label,label1;
	protected static TextField textFieldA,textFieldB;
	protected static Button button, button1,deleteRoomButton,goBackToProgramWindowButton;
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
						label.setText("Choose Room Number");
						deleteRoomButton.setText("Delete Room");
						goBackToProgramWindowButton.setText("Go Back");
						primaryStage.setTitle("Room Deletion Page");
						
					}
					if(language.equals("Türkçe"))
					{
						label.setText("Oda no seçiniz");
						deleteRoomButton.setText("Odayı Sil");
						goBackToProgramWindowButton.setText("Geri Dön");
						primaryStage.setTitle("Oda Silme Sayfası");
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
			
			label=new Label("Choose Room Number");
			if(language!=null && language.equals("Türkçe"))
				label.setText("Oda no seçiniz");
			if(language!=null && language.equals("English"))
				label.setText("Choose Room Number");
			label.setPrefSize(200, 20);
			label.setLayoutX(0);
			label.setLayoutY(50);
			pane.getChildren().add(label);
			
			List<Room> rooms=dao.getAllRooms();
			List<Long> roomNos=new ArrayList<Long>();
			for(Room room: rooms)
			{
				roomNos.add(room.getRoomNo());
			}
			cb.setPrefSize(200, 20);
			cb.setLayoutX(0);
			cb.setLayoutY(50);
			cb.getItems().clear();
			cb.getItems().addAll(roomNos);
			pane.getChildren().add(cb);
			
			
			EventHandler<ActionEvent> deleteRoomEventHandler=new EventHandler<ActionEvent>() 
			{

				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					long roomNo=0;
					int result1=0;
					int result2=0;
					if(cb.getValue()!=null)
					{
						if(language.equals("English"))
						{
							Alert alert=new Alert(AlertType.CONFIRMATION);
							alert.setTitle("Caution");
							alert.setHeaderText("Caution");
							alert.setContentText("if you do that, both the room and the "
									+ "reservations about room"
									+ " will be deleted! Are you sure!");
							ButtonType bt=alert.showAndWait().orElse(null);
							if(bt.equals(ButtonType.OK))
							{
								roomNo=Long.valueOf(cb.getValue().toString());
								try {
									
									result1=dao.deleteFromReservationTableByRoomNo(roomNo);
									result2=dao.deleteFromRoomTable(roomNo);
									
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								List<Room> rooms=null;
								try {
									rooms = dao.getAllRooms();
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								List<Long> roomNos=new ArrayList<Long>();
								for(Room room: rooms)
								{
									roomNos.add(room.getRoomNo());
								}
								cb.getItems().clear();
								cb.getItems().addAll(roomNos);
								if(result2>0)
								{
									Alert alert1=new Alert(AlertType.INFORMATION);
									alert1.setTitle("Success");
									alert1.setHeaderText("Success");
									alert1.setContentText("Operation was successful");
									ButtonType bt1=alert1.showAndWait().orElse(null);
									if(bt1.equals(ButtonType.OK))
									{
										
									}
									
								}
								else
								{
									Alert alert3=new Alert(AlertType.CONFIRMATION);
									alert3.setTitle("Caution");
									alert3.setHeaderText("Error");
									alert3.setContentText("There was a mistake");
									ButtonType bt3=alert3.showAndWait().orElse(null);
									if(bt3.equals(ButtonType.OK))
									{
										
									}
								}
								
							}
							
						}
						if(language.equals("Türkçe"))
						{
							Alert alert=new Alert(AlertType.CONFIRMATION);
							alert.setTitle("Dikkat");
							alert.setHeaderText("Dikkat");
							alert.setContentText("Bunu yaparsanız hem oda hem de "
									+ "oda ile ilgili rezervasyonlar silinecektir"
									+ " Emin misiniz?");
							ButtonType bt=alert.showAndWait().orElse(null);
							if(bt.equals(ButtonType.OK))
							{
								roomNo=Long.valueOf(cb.getValue().toString());
								try {
									
									result1=dao.deleteFromReservationTableByRoomNo(roomNo);
									result2=dao.deleteFromRoomTable(roomNo);
									
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								List<Room> rooms=null;
								try {
									rooms = dao.getAllRooms();
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								List<Long> roomNos=new ArrayList<Long>();
								for(Room room: rooms)
								{
									roomNos.add(room.getRoomNo());
								}
								cb.getItems().clear();
								cb.getItems().addAll(roomNos);
								
								if(result2>0)
								{
									Alert alert1=new Alert(AlertType.INFORMATION);
									alert1.setTitle("İşlem Başarılı");
									alert1.setHeaderText("İşlem Başarılı");
									alert1.setContentText("İşlem başarıyla tamamlanmıştır");
									ButtonType bt1=alert1.showAndWait().orElse(null);
									if(bt1.equals(ButtonType.OK))
									{
										
									}
									
								}
								else
								{
									Alert alert3=new Alert(AlertType.CONFIRMATION);
									alert3.setTitle("Dikkat");
									alert3.setHeaderText("Hata");
									alert3.setContentText("Bir hata oluştu");
									ButtonType bt3=alert3.showAndWait().orElse(null);
									if(bt3.equals(ButtonType.OK))
									{
										
									}
								}
								
							}
						}
						
						
					}
					
					
					
				}
				
			};
			
			deleteRoomButton=new Button("Delete Room");
			if(language!=null && language.equals("Türkçe"))
				deleteRoomButton.setText("Odayı Sil");
			if(language!=null && language.equals("English"))
				deleteRoomButton.setText("Delete Room");
			deleteRoomButton.setPrefSize(200, 20);
			deleteRoomButton.setLayoutX(0);
			deleteRoomButton.setLayoutY(110);
			pane.getChildren().add(deleteRoomButton);
			deleteRoomButton.setOnAction(deleteRoomEventHandler);
			
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
