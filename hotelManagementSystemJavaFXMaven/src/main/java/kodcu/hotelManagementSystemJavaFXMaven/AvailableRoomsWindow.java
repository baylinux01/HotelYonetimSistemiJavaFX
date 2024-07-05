package kodcu.hotelManagementSystemJavaFXMaven;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;



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
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class AvailableRoomsWindow extends Application {
	static Dao dao=new Dao();
	static TextField textField=new TextField();
	static Date startDate=null;
	static Date dateEnd=null;
	static long year=0;
	static long month=0;
	static long day=0;
	static long daysToStay=0;
	static long pricePerDay=0;
	static long totalPrice=daysToStay*pricePerDay;
	static String paidOrUnpaid="";
	static List<Room> availableRooms=null;
	static String clientNameAndSurname="";
	static String clientPhoneNumber="";
	static String clientAddress="";
	static ListView<Long> listView=new ListView();
	protected static String language;
	protected static ComboBox<String> cblanguage;
	protected static Label labelA,labelB;
	protected static TextField textFieldA,textFieldB;
	protected static Button button, button1,goBackToProgramWindowButton,saveReservationButton;
	@Override
	public void start(Stage primaryStage) throws InterruptedException {
		try {
			
			
			Group root = new Group();
			Scene scene = new Scene(root,400,500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
			
			
			
			
			Pane pane=new Pane();
			pane.setPrefSize(340, 470);
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
						saveReservationButton.setText("Save Reservation");
						goBackToProgramWindowButton.setText("Go Back");
						primaryStage.setTitle("Available Rooms");
						
					}
					if(language.equals("Türkçe"))
					{
						saveReservationButton.setText("Rezervasyonu Kaydet");
						goBackToProgramWindowButton.setText("Geri Dön");
						primaryStage.setTitle("Müsait Odalar");
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
			
			
			listView.setPrefSize(200,320);
			listView.setLayoutX(0);
			listView.setLayoutY(0);
			pane.getChildren().add(listView);
			listView.getItems().clear();
			
			
			
			
			EventHandler<ActionEvent> saveReservationEventHandler=new EventHandler<ActionEvent>() 
			{

				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					Reservation reservation=new Reservation();
					long roomNo=(long)listView.getSelectionModel().selectedItemProperty().getValue();
					if(roomNo>0) reservation.setRoomNo(roomNo);
					
					LocalDate localDateToStart=LocalDate.of((int)year,(int) month,(int) day);
					Date dateToStart=Date.from(localDateToStart.atStartOfDay(ZoneId.systemDefault()).toInstant());
					dateEnd=new Date(dateToStart.getTime()+daysToStay*86400000);
					String DATE_FORMAT="dd-MM-yyyy";
					SimpleDateFormat sdf=new SimpleDateFormat(DATE_FORMAT);
					String endDate=sdf.format(dateEnd);
					String startDate=sdf.format(dateToStart);
					reservation
					.setReservationStartDate(startDate);
					reservation.setReservationEndDate(endDate);
					reservation.setDaysToStay(daysToStay);
					reservation.setPricePerDay(pricePerDay);
					reservation.setTotalPrice(totalPrice);
					reservation.setPaidOrUnpaid(paidOrUnpaid);
					reservation.setClientNameAndSurname(clientNameAndSurname);
					reservation.setClientCellPhone(clientPhoneNumber);
					reservation.setClientAddress(clientAddress);
					
					int result=0;
					try {
						result=dao.insertIntoReservationTable(reservation.getRoomNo(),
								reservation.getReservationStartDate(), reservation.getReservationEndDate(),
								reservation.getDaysToStay(),reservation.getPricePerDay(),reservation.getTotalPrice(),
								reservation.getPaidOrUnpaid(),
								reservation.getClientNameAndSurname(),reservation.getClientCellPhone(),
								reservation.getClientAddress());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(result>0)
					{
						if(language.equals("English"))
						{
							Alert alert=new Alert(AlertType.INFORMATION);
							alert.setTitle("Success");
							alert.setHeaderText("Reservation have been succesffully formed");
							alert.setContentText("You can see reservations by choosing room number "
									+ "from Main Page");
							ButtonType bt=alert.showAndWait().orElse(null);
							if(bt.equals(ButtonType.OK))
							{
								
							}
							
							
						}
						if(language.equals("Türkçe"))
						{
							Alert alert=new Alert(AlertType.INFORMATION);
							alert.setTitle("İşlem Başarılı");
							alert.setHeaderText("Rezervasyon Başarıyla oluşturuldu");
							alert.setContentText("Reservasyonları ana sayfadan oda numarası "
									+ "seçerek takip edebilirsiniz");
							ButtonType bt=alert.showAndWait().orElse(null);
							if(bt.equals(ButtonType.OK))
							{
								
							}
						}
						
						Group rootProgramWindow=new Group();
						Scene sceneProgramWindow=new Scene(rootProgramWindow,1200,700);
						Stage stageProgramWindow=new Stage();
						stageProgramWindow.setScene(sceneProgramWindow);
//						stageOpenDBChoosingWindow.getIcons().add(
//								new Image(DBChoosingWindow.class
//								.getResourceAsStream("aidatTakipLogo.jpg")));
						
						//stageOpenAidatPayerAddingWindow.show();
						stageProgramWindow.setTitle("Main Page");
						ProgramWindow programWindow=new ProgramWindow();
						try {
							programWindow.language=language;
							programWindow.start(stageProgramWindow);
//							comboBox.getItems().clear();
//							textField.setText("");
//							textField2.setText("");
//							textField3.setText("");
//							textField4.setText("");
//							passwordField.setText("");
							primaryStage.hide();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					
					
					
				}
				
			};
			
			saveReservationButton=new Button("Save Reservation");
			if(language!=null && language.equals("Türkçe"))
				saveReservationButton.setText("Rezervasyonu Kaydet");
			if(language!=null && language.equals("English"))
				saveReservationButton.setText("Save Reservation");
			saveReservationButton.setPrefSize(200, 20);
			saveReservationButton.setLayoutX(0);
			saveReservationButton.setLayoutY(340);
			pane.getChildren().add(saveReservationButton);
			saveReservationButton.setOnAction(saveReservationEventHandler);
			
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
			goBackToProgramWindowButton.setLayoutY(380);
			pane.getChildren().add(goBackToProgramWindowButton);
			goBackToProgramWindowButton.setOnAction(goBackToProgramWindowEventHandler);
			
			startDate=AddingReservationWindow.getDateToStart();
			dateEnd=AddingReservationWindow.getDateToEnd();
			year=AddingReservationWindow.getYear();
			month=AddingReservationWindow.getMonth();
			day=AddingReservationWindow.getDay();
			daysToStay=AddingReservationWindow.getDaysToStay();
			pricePerDay=AddingReservationWindow.getPricePerDay();
			totalPrice=pricePerDay*daysToStay;
			paidOrUnpaid=AddingReservationWindow.getPaidOrUnpaid();
			
			
			
			availableRooms=AddingReservationWindow.getAvailableRooms();
			
			Comparator<Room> myComparator=Comparator.comparing(Room::getRoomNo);
			List<Room> sortedAvailableRoomList=availableRooms.stream()
					.sorted(myComparator).collect(Collectors.toList());
			//Collections.reverse(sortedAvailableRoomList);
			Set<Room> sortedAvailableRoomSet=new LinkedHashSet<Room>(sortedAvailableRoomList);
			clientNameAndSurname=AddingReservationWindow.getClientNameAndSurname();
			clientPhoneNumber=AddingReservationWindow.getClientPhoneNumber();
			 clientAddress=AddingReservationWindow.getClientAddress();
			 listView.getItems().clear();
			 if(sortedAvailableRoomSet!=null&&sortedAvailableRoomSet.size()>0)
			 {
				 
				 for(Room room: sortedAvailableRoomSet)
					{
					 	if(room!=null)
					 	{
					 		listView.getItems().add(room.getRoomNo());
					 	}
						
					}
			 }
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		launch(args);
		
	}

	
}
