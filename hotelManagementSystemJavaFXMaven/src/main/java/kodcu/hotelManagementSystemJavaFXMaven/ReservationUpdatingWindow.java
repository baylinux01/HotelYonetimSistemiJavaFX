package kodcu.hotelManagementSystemJavaFXMaven;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class ReservationUpdatingWindow extends Application {
	static Dao dao=new Dao();
	static Set<Room> availableRooms=new LinkedHashSet<Room>();
	static TextField textField=new TextField();
	static TextField textField2=new TextField();
	static TextField textField2a=new TextField();
	static ListView listView=new ListView();
	static TextField textField3=new TextField();
	static TextField textField4=new TextField();
	static TextArea textArea=new TextArea();
	static long day=32;
	static long month=13;
	static long year=1000;
	static long daysToStay=1000;
	static long pricePerDay=0;
	static long totalPrice=pricePerDay*daysToStay;
	static String paidOrUnpaid="Unpaid";
	static Date dateToStart=null;
	static Date dateToEnd=null;
	static String clientAddress="";
	static String clientNameAndSurname="";
	static String clientPhoneNumber="";
	static ReservationToShow oldReservationToShow=null;
	static Reservation oldReservation=null;
	static long oldReservationYear=0;
	static long oldReservationMonth=0;
	static long oldReservationDay=0;
	protected static String language;
	protected static ComboBox<String> cblanguage,comboBox2;
	protected static Label label00,label0,label,label2,label3,label4,label4a,label4b,label5,label6,label7;
	protected static TextField textFieldA,textFieldB;
	protected static Button checkReservationButton, goBackToProgramWindowButton;
	
	
	public static String getClientAddress() {
		return clientAddress;
	}

	public static void setClientAddress(String clientAddress) {
		AddingReservationWindow.clientAddress = clientAddress;
	}

	public static String getClientNameAndSurname() {
		return clientNameAndSurname;
	}

	public static void setClientNameAndSurname(String clientNameAndSurname) {
		AddingReservationWindow.clientNameAndSurname = clientNameAndSurname;
	}

	public static String getClientPhoneNumber() {
		return clientPhoneNumber;
	}

	public static void setClientPhoneNumber(String clientPhoneNumber) {
		AddingReservationWindow.clientPhoneNumber = clientPhoneNumber;
	}

	public static Set<Room> getAvailableRooms() {
		return availableRooms;
	}

	public static void setAvailableRooms(Set<Room> availableRooms) {
		AddingReservationWindow.availableRooms = (List<Room>) availableRooms;
	}

	public static long getDay() {
		return day;
	}

	public static void setDay(long day) {
		AddingReservationWindow.day = day;
	}

	public static long getMonth() {
		return month;
	}

	public static void setMonth(long month) {
		AddingReservationWindow.month = month;
	}

	public static long getYear() {
		return year;
	}

	public static void setYear(long year) {
		AddingReservationWindow.year = year;
	}

	public static long getDaysToStay() {
		return daysToStay;
	}

	public static void setDaysToStay(long daysToStay) {
		AddingReservationWindow.daysToStay = daysToStay;
	}

	public static Date getDateToStart() {
		return dateToStart;
	}

	public static void setDateToStart(Date dateToStart) {
		AddingReservationWindow.dateToStart = dateToStart;
	}

	public static Date getDateToEnd() {
		return dateToEnd;
	}

	public static void setDateToEnd(Date dateToEnd) {
		AddingReservationWindow.dateToEnd = dateToEnd;
	}

	static int count=0;
	@Override
	public void start(Stage primaryStage) throws InterruptedException {
		try {
			
			
			Group root = new Group();
			Scene scene = new Scene(root,400,720);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			EventHandler closeRequestEventHandler=new EventHandler()
			{

				@Override
				public void handle(Event event) {
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
			primaryStage.setOnCloseRequest(closeRequestEventHandler);
			
			oldReservationToShow=ProgramWindow.tableView.getSelectionModel().getSelectedItem();
			oldReservation=new Reservation(oldReservationToShow);
			oldReservationYear=Long.valueOf(oldReservation.getReservationStartDate().split("-")[2]);
			oldReservationMonth=Long.valueOf(oldReservation.getReservationStartDate().split("-")[1]);
			oldReservationDay=Long.valueOf(oldReservation.getReservationStartDate().split("-")[0]);
			
			Pane pane=new Pane();
			pane.setPrefSize(340, 720);
			pane.setLayoutX(90);
			pane.setLayoutY(0);
			root.getChildren().add(pane);
			
			EventHandler<ActionEvent> changeLanguageEventHandler=new EventHandler<ActionEvent>() 
			{
				@Override
				public void handle(ActionEvent event) 
				{
					language=cblanguage.getValue();
					if(language.equals("English"))
					{
						label00.setText("Reservation No: "+oldReservation.getReservationNo());
						label0.setText("Room No: "+oldReservation.getRoomNo());
						label.setText("Choose reservation start day");
						label2.setText("Choose reservation start month");
						comboBox2.getItems().clear();
						comboBox2.getItems().addAll("January","February","March",
								"April","May","June","July","August","September",
								"October","November","December");
						//pane.getChildren().add(comboBox2);
						if(oldReservationMonth==1) comboBox2.setValue("January");
						if(oldReservationMonth==2) comboBox2.setValue("February");
						if(oldReservationMonth==3) comboBox2.setValue("March");
						if(oldReservationMonth==4) comboBox2.setValue("April");
						if(oldReservationMonth==5) comboBox2.setValue("May");
						if(oldReservationMonth==6) comboBox2.setValue("June");
						if(oldReservationMonth==7) comboBox2.setValue("July");
						if(oldReservationMonth==8) comboBox2.setValue("August");
						if(oldReservationMonth==9) comboBox2.setValue("September");
						if(oldReservationMonth==10) comboBox2.setValue("October");
						if(oldReservationMonth==11) comboBox2.setValue("November");
						if(oldReservationMonth==12) comboBox2.setValue("December");
						label3.setText("Type reservation start year e.g:2025");
						label4.setText("Type how many days to stay e.g:13");
						label4a.setText("Price Per Day");
						label4b.setText("Paid Or Unpaid");
						listView.getItems().clear();
						listView.getItems().addAll("Unpaid","Paid");
						if(oldReservation.getPaidOrUnpaid().equals("Unpaid"))
							listView.getSelectionModel().select(0);
							if(oldReservation.getPaidOrUnpaid().equals("Paid"))
								listView.getSelectionModel().select(1);
						label5.setText("Client Name and Surname");
						label6.setText("Client Phone Number");
						label7.setText("Client Address");
						checkReservationButton.setText("Update Reservation");
						goBackToProgramWindowButton.setText("Go Back");
						primaryStage.setTitle("Reservation Updating Page");
						
					}
					if(language.equals("Türkçe"))
					{
						label00.setText("Reservasyon No: "+oldReservation.getReservationNo());
						label0.setText("Oda No: "+oldReservation.getRoomNo());
						label.setText("Reservasyon başlangıç günü");
						label2.setText("Reservasyon başlangıç ayı");
						comboBox2.getItems().clear();
						comboBox2.getItems().addAll("Ocak","Şubat","Mart",
								"Nisan","Mayıs","Haziran","Temmuz","Ağustos","Eylül",
								"Ekim","Kasım","Aralık");
						//pane.getChildren().add(comboBox2);
						if(oldReservationMonth==1) comboBox2.setValue("Ocak");
						if(oldReservationMonth==2) comboBox2.setValue("Şubat");
						if(oldReservationMonth==3) comboBox2.setValue("Mart");
						if(oldReservationMonth==4) comboBox2.setValue("Nisan");
						if(oldReservationMonth==5) comboBox2.setValue("Mayıs");
						if(oldReservationMonth==6) comboBox2.setValue("Haziran");
						if(oldReservationMonth==7) comboBox2.setValue("Temmuz");
						if(oldReservationMonth==8) comboBox2.setValue("Ağustos");
						if(oldReservationMonth==9) comboBox2.setValue("Eylül");
						if(oldReservationMonth==10) comboBox2.setValue("Ekim");
						if(oldReservationMonth==11) comboBox2.setValue("Kasım");
						if(oldReservationMonth==12) comboBox2.setValue("Aralık");
						label3.setText("Reservasyon başlangıç yılı ör:2025");
						label4.setText("Kalınacak gün sayısı ör:13");
						label4a.setText("Günlük Ücret");
						label4b.setText("Ödenme Durumu");
						listView.getItems().clear();
						listView.getItems().addAll("Ödenmedi","Ödendi");
						if(oldReservation.getPaidOrUnpaid().equals("Unpaid"))
							listView.getSelectionModel().select(0);
							if(oldReservation.getPaidOrUnpaid().equals("Paid"))
								listView.getSelectionModel().select(1);
						label5.setText("Müşteri Adı Soyadı");
						label6.setText("Müşteri Telefon No");
						label7.setText("Müşteri Adres");
						checkReservationButton.setText("Rezervasyonu Güncelle");
						goBackToProgramWindowButton.setText("Geri Dön");
						primaryStage.setTitle("Reservasyon Güncelleme Sayfası");
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
			
			
			
			label00=new Label("Reservation No: "+oldReservation.getReservationNo());
			if(language!=null && language.equals("Türkçe"))
				label00.setText("Reservasyon No: "+oldReservation.getReservationNo());
			if(language!=null && language.equals("English"))
				label00.setText("Reservation No: "+oldReservation.getReservationNo());
			label00.setPrefSize(150, 20);
			label00.setLayoutX(20);
			label00.setLayoutY(0);
			root.getChildren().add(label00);
			
		
			
			label0=new Label("Room No: "+oldReservation.getRoomNo());
			if(language!=null && language.equals("Türkçe"))
				label0.setText("Oda No: "+oldReservation.getRoomNo());
			if(language!=null && language.equals("English"))
				label0.setText("Room No: "+oldReservation.getRoomNo());
			label0.setPrefSize(150, 20);
			label0.setLayoutX(150);
			label0.setLayoutY(0);
			root.getChildren().add(label0);
			
			label=new Label("Choose reservation start day");
			if(language!=null && language.equals("Türkçe"))
				label.setText("Reservasyon başlangıç günü");
			if(language!=null && language.equals("English"))
				label.setText("Choose reservation start day");
			label.setPrefSize(200, 20);
			label.setLayoutX(0);
			label.setLayoutY(30);
			pane.getChildren().add(label);
			
			ComboBox comboBox=new ComboBox();
			comboBox.setPrefSize(200, 20);
			comboBox.setLayoutX(0);
			comboBox.setLayoutY(50);
			comboBox.getItems().addAll("1","2","3","4","5","6","7","8","9","10","11","12",
					"13","14","15","16","17","18","19","20","21","22","23","24","25","26",
					"27","28","29","30","31");
			pane.getChildren().add(comboBox);
			comboBox.setValue(String.valueOf(oldReservationDay));
			
			label2=new Label("Choose reservation start month");
			if(language!=null && language.equals("Türkçe"))
				label2.setText("Reservasyon başlangıç ayı");
			if(language!=null && language.equals("English"))
				label2.setText("Choose reservation start month");
			label2.setPrefSize(200, 20);
			label2.setLayoutX(0);
			label2.setLayoutY(90);
			pane.getChildren().add(label2);
			
			comboBox2=new ComboBox();
			comboBox2.setPrefSize(200, 20);
			comboBox2.setLayoutX(0);
			comboBox2.setLayoutY(110);
			comboBox2.getItems().clear();
			if(language!=null && language.equals("Türkçe"))
			{
				comboBox2.getItems().clear();
				comboBox2.getItems().addAll("Ocak","Şubat","Mart",
						"Nisan","Mayıs","Haziran","Temmuz","Ağustos","Eylül",
						"Ekim","Kasım","Aralık");
				
				if(oldReservationMonth==1) comboBox2.setValue("Ocak");
				if(oldReservationMonth==2) comboBox2.setValue("Şubat");
				if(oldReservationMonth==3) comboBox2.setValue("Mart");
				if(oldReservationMonth==4) comboBox2.setValue("Nisan");
				if(oldReservationMonth==5) comboBox2.setValue("Mayıs");
				if(oldReservationMonth==6) comboBox2.setValue("Haziran");
				if(oldReservationMonth==7) comboBox2.setValue("Temmuz");
				if(oldReservationMonth==8) comboBox2.setValue("Ağustos");
				if(oldReservationMonth==9) comboBox2.setValue("Eylül");
				if(oldReservationMonth==10) comboBox2.setValue("Ekim");
				if(oldReservationMonth==11) comboBox2.setValue("Kasım");
				if(oldReservationMonth==12) comboBox2.setValue("Aralık");
			}
			if(language!=null && language.equals("English"))
			{
				comboBox2.getItems().clear();
				comboBox2.getItems().addAll("January","February","March",
						"April","May","June","July","August","September",
						"October","November","December");
				
				if(oldReservationMonth==1) comboBox2.setValue("January");
				if(oldReservationMonth==2) comboBox2.setValue("February");
				if(oldReservationMonth==3) comboBox2.setValue("March");
				if(oldReservationMonth==4) comboBox2.setValue("April");
				if(oldReservationMonth==5) comboBox2.setValue("May");
				if(oldReservationMonth==6) comboBox2.setValue("June");
				if(oldReservationMonth==7) comboBox2.setValue("July");
				if(oldReservationMonth==8) comboBox2.setValue("August");
				if(oldReservationMonth==9) comboBox2.setValue("September");
				if(oldReservationMonth==10) comboBox2.setValue("October");
				if(oldReservationMonth==11) comboBox2.setValue("November");
				if(oldReservationMonth==12) comboBox2.setValue("December");
			}
			pane.getChildren().add(comboBox2);
			
			label3=new Label("Type reservation start year e.g:2025");
			if(language!=null && language.equals("Türkçe"))
				label3.setText("Reservasyon başlangıç yılı ör:2025");
			if(language!=null && language.equals("English"))
				label3.setText("Type reservation start year e.g:2025");
			label3.setPrefSize(240, 20);
			label3.setLayoutX(0);
			label3.setLayoutY(150);
			pane.getChildren().add(label3);
			
			textField.setPrefSize(200,20);
			textField.setLayoutX(0);
			textField.setLayoutY(170);
			pane.getChildren().add(textField);
			textField.setText(String.valueOf(oldReservationYear));
			
			label4=new Label("Type how many days to stay");
			if(language!=null && language.equals("Türkçe"))
				label4.setText("Kalınacak gün sayısı ör:13");
			if(language!=null && language.equals("English"))
				label4.setText("Type how many days to stay e.g:13");
			label4.setPrefSize(250, 20);
			label4.setLayoutX(0);
			label4.setLayoutY(210);
			pane.getChildren().add(label4);
			
			textField2.setPrefSize(200,20);
			textField2.setLayoutX(0);
			textField2.setLayoutY(230);
			pane.getChildren().add(textField2);
			textField2.setText(String.valueOf(oldReservation.getDaysToStay()));
			
			label4a=new Label("Price Per Day");
			if(language!=null && language.equals("Türkçe"))
				label4a.setText("Günlük Ücret");
			if(language!=null && language.equals("English"))
				label4a.setText("Price Per Day");
			label4a.setPrefSize(200, 20);
			label4a.setLayoutX(0);
			label4a.setLayoutY(270);
			pane.getChildren().add(label4a);
			
			textField2a.setPrefSize(200,20);
			textField2a.setLayoutX(0);
			textField2a.setLayoutY(290);
			pane.getChildren().add(textField2a);
			textField2a.setText(String.valueOf(oldReservation.getPricePerDay()));
			
			label4b=new Label("Paid Or Unpaid");
			if(language!=null && language.equals("Türkçe"))
				label4b.setText("Ödenme Durumu");
			if(language!=null && language.equals("English"))
				label4b.setText("Paid Or Unpaid");
			label4b.setPrefSize(200, 20);
			label4b.setLayoutX(0);
			label4b.setLayoutY(330);
			pane.getChildren().add(label4b);
			
			listView.setPrefSize(200,60);
			listView.setLayoutX(0);
			listView.setLayoutY(350);
			pane.getChildren().add(listView);
			listView.getItems().clear();
			if(language!=null && language.equals("Türkçe"))
			{
				listView.getItems().clear();
				listView.getItems().addAll("Ödenmedi","Ödendi");
			}
			if(language!=null && language.equals("English"))
			{
				listView.getItems().clear();
				listView.getItems().addAll("Unpaid","Paid");
			}
			if(oldReservation.getPaidOrUnpaid().equals("Unpaid"))
			listView.getSelectionModel().select(0);
			if(oldReservation.getPaidOrUnpaid().equals("Paid"))
				listView.getSelectionModel().select(1);
			
			label5=new Label("Client Name and Surname");
			if(language!=null && language.equals("Türkçe"))
				label5.setText("Müşteri Adı Soyadı");
			if(language!=null && language.equals("English"))
				label5.setText("Client Name and Surname");
			label5.setPrefSize(200, 20);
			label5.setLayoutX(0);
			label5.setLayoutY(420);
			pane.getChildren().add(label5);
			
			textField3.setPrefSize(200,20);
			textField3.setLayoutX(0);
			textField3.setLayoutY(440);
			pane.getChildren().add(textField3);
			textField3.setText(oldReservation.getClientNameAndSurname());
			
			label6=new Label("Client Phone Number");
			if(language!=null && language.equals("Türkçe"))
				label6.setText("Müşteri Telefon No");
			if(language!=null && language.equals("English"))
				label6.setText("Client Phone Number");
			label6.setPrefSize(200, 20);
			label6.setLayoutX(0);
			label6.setLayoutY(480);
			pane.getChildren().add(label6);
			
			textField4.setPrefSize(200,20);
			textField4.setLayoutX(0);
			textField4.setLayoutY(500);
			pane.getChildren().add(textField4);
			textField4.setText(oldReservation.getClientCellPhone());
			
			label7=new Label("Client Address");
			if(language!=null && language.equals("Türkçe"))
				label7.setText("Müşteri Adres");
			if(language!=null && language.equals("English"))
				label7.setText("Client Address");
			label7.setPrefSize(200, 20);
			label7.setLayoutX(0);
			label7.setLayoutY(540);
			pane.getChildren().add(label7);
			
			textArea.setPrefSize(200,80);
			textArea.setLayoutX(0);
			textArea.setLayoutY(560);
			textArea.setWrapText(false);
			pane.getChildren().add(textArea);
			textArea.setText(oldReservation.getClientAddress());
			
			EventHandler<ActionEvent> checkReservationEventHandler=new EventHandler<ActionEvent>() 
			{

				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					
					
					
					List<Reservation> reservations=null;
					
					if(comboBox.getValue()!=null&&comboBox2.getValue()!=null&&textField.getText()!=null
							&& textField.getText().matches("^[2-9][0-9]{3}$")&&textField2.getText()!=null
							&&textField2.getText().matches("^[1-9][0-9]{0,}$")&&textField2a.getText()!=null
									&&textField2a.getText().matches("^[1-9][0-9]{0,}$")
									&&listView.getSelectionModel().getSelectedItem()!=null)
					{
						if(comboBox2.getValue().toString().equals("January")) month=1;
						if(comboBox2.getValue().toString().equals("February")) month=2;
						if(comboBox2.getValue().toString().equals("March")) month=3;
						if(comboBox2.getValue().toString().equals("April")) month=4;
						if(comboBox2.getValue().toString().equals("May")) month=5;
						if(comboBox2.getValue().toString().equals("June")) month=6;
						if(comboBox2.getValue().toString().equals("July")) month=7;
						if(comboBox2.getValue().toString().equals("August")) month=8;
						if(comboBox2.getValue().toString().equals("September")) month=9;
						if(comboBox2.getValue().toString().equals("October")) month=10;
						if(comboBox2.getValue().toString().equals("November")) month=11;
						if(comboBox2.getValue().toString().equals("December")) month=12;
						if(comboBox2.getValue().toString().equals("Ocak")) month=1;
						if(comboBox2.getValue().toString().equals("Şubat")) month=2;
						if(comboBox2.getValue().toString().equals("Mart")) month=3;
						if(comboBox2.getValue().toString().equals("Nisan")) month=4;
						if(comboBox2.getValue().toString().equals("Mayıs")) month=5;
						if(comboBox2.getValue().toString().equals("Haziran")) month=6;
						if(comboBox2.getValue().toString().equals("Temmuz")) month=7;
						if(comboBox2.getValue().toString().equals("Ağustos")) month=8;
						if(comboBox2.getValue().toString().equals("Eylül")) month=9;
						if(comboBox2.getValue().toString().equals("Ekim")) month=10;
						if(comboBox2.getValue().toString().equals("Kasım")) month=11;
						if(comboBox2.getValue().toString().equals("Aralık")) month=12;
						year=Long.valueOf(textField.getText());
						day=Long.valueOf(comboBox.getValue().toString());
						daysToStay=Long.valueOf(textField2.getText());
						pricePerDay=Long.valueOf(textField2a.getText());
						totalPrice=pricePerDay*daysToStay;
						if(listView.getSelectionModel().getSelectedItem().toString().equals("Paid")
								||listView.getSelectionModel().getSelectedItem().toString().equals("Ödendi"))
						paidOrUnpaid="Paid";
						if(listView.getSelectionModel().getSelectedItem().toString().equals("Unpaid")
								||listView.getSelectionModel().getSelectedItem().toString().equals("Ödenmedi"))
						paidOrUnpaid="Unpaid";
						clientNameAndSurname=textField3.getText();
						clientPhoneNumber=textField4.getText();
						clientAddress=textArea.getText();
						availableRooms.clear();
						if(((month==1||month==3||month==5||month==7||month==8||month==10||month==12)&&day<=31)||
								((month==4||month==6||month==9||month==11)&&day<=30)
								||((month==2)&&day<=28)||
								((month==2&&day<=29)&&year%4==0))
						{
							LocalDate localDateToStart=LocalDate.of((int)year,(int) month,(int) day);
							dateToStart=Date.from(localDateToStart.atStartOfDay(ZoneId.systemDefault()).toInstant());
							dateToEnd=new Date(dateToStart.getTime()+daysToStay*86400000);
							String DATE_FORMAT="dd-MM-yyyy";
							SimpleDateFormat sdf=new SimpleDateFormat(DATE_FORMAT);
							String EndDate=sdf.format(dateToEnd);
							String StartDate=sdf.format(dateToStart);
							Reservation reservationToUpdate=null;
							try {
								reservationToUpdate=dao.getReservationsByReservationNo(oldReservation.getReservationNo());
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							
								
									try {
										reservations=dao.getReservationsByRoomNoNotInOne
												(reservationToUpdate.getRoomNo(),reservationToUpdate.getReservationNo());
									} catch (SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									if(reservations!=null&&reservations.size()>0)
									{
										
										for(Reservation reservation: reservations)
										{
											if(reservation!=null)
											{
												String[] arr=reservation.getReservationStartDate().split("-");
												int[] arr2=new int[3];
												Date Edate=null;
												Date Sdate=null;
												for(int i=0;i<arr.length;i++)
												{
													arr2[i]=Integer.valueOf(arr[i]);
													
												}
												LocalDate Slocaldate=LocalDate.of(arr2[2], arr2[1], arr2[0]);
												Sdate=Date.from(Slocaldate.atStartOfDay(ZoneId.systemDefault()).toInstant());
												
												String[] arr3=reservation.getReservationEndDate().split("-");
												int[] arr4=new int[3];
												for(int i=0;i<arr3.length;i++)
												{
													arr4[i]=Integer.valueOf(arr3[i]);
													
												}
												
												LocalDate Elocaldate=LocalDate.of(arr4[2], arr4[1], arr4[0]);
												Edate=Date.from(Elocaldate.atStartOfDay(ZoneId.systemDefault()).toInstant());
												
												
												
												if(Edate.after(Sdate)&&dateToEnd.after(dateToStart)&&
														((dateToStart.after(Edate)||(dateToEnd.before(Sdate)))))
												{
													try {
														availableRooms.add(dao.getRoomByRoomNo(reservation.getRoomNo()));
														
													} catch (SQLException e) {
														// TODO Auto-generated catch block
														e.printStackTrace();
													}
												}
												
											}
											
										}
										
									}
									else
									{
										try {
											availableRooms.addAll(dao.getAllRooms());
										} catch (SQLException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									}
								
								int c=0;
								for(Room room:availableRooms)
								{
									if(room.getRoomNo()==reservationToUpdate.getRoomNo())
									{
										try {
											
											dao.updateReservation(oldReservation.getReservationNo(), oldReservation.getRoomNo(), 
													StartDate, EndDate, daysToStay,pricePerDay,totalPrice,paidOrUnpaid, clientNameAndSurname, clientPhoneNumber, clientAddress);
											c++;
										} catch (SQLException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										
									}
								}
								if(c==0)
								{
									if(language.equals("English"))
									{
										Alert alert3=new Alert(AlertType.INFORMATION);
										alert3.setTitle("Caution");
										alert3.setHeaderText("Error");
										alert3.setContentText("The date or stay duration is not available for updating");
										ButtonType bt3=alert3.showAndWait().orElse(null);
										if(bt3.equals(ButtonType.OK))
										{
											
										}
									}
									if(language.equals("Türkçe"))
									{
										Alert alert3=new Alert(AlertType.INFORMATION);
										alert3.setTitle("Uyarı");
										alert3.setHeaderText("Hata");
										alert3.setContentText("Tarih veya konaklama süresi müsait değil");
										ButtonType bt3=alert3.showAndWait().orElse(null);
										if(bt3.equals(ButtonType.OK))
										{
											
										}
									}
									
									
								}
								else 
								{
									c=0;
								
								textField.setText("");
								textField2.setText("");
								textField2a.setText("");
								listView.getItems().clear();
								textField3.setText("");
								textField4.setText("");
								textArea.setText("");
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
//									comboBox.getItems().clear();
//									textField.setText("");
//									textField2.setText("");
//									textField3.setText("");
//									textField4.setText("");
//									passwordField.setText("");
									primaryStage.hide();
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								}
							
							
						}
					}
					
				}
				
			};
			
			checkReservationButton=new Button("Update Reservation");
			if(language.equals("Türkçe"))
				checkReservationButton.setText("Rezervasyonu Güncelle");
			checkReservationButton.setPrefSize(200, 20);
			checkReservationButton.setLayoutX(0);
			checkReservationButton.setLayoutY(650);
			pane.getChildren().add(checkReservationButton);
			checkReservationButton.setOnAction(checkReservationEventHandler);
			
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
			if(language.equals("Türkçe"))
				goBackToProgramWindowButton.setText("Geri Dön");
			goBackToProgramWindowButton.setPrefSize(200, 20);
			goBackToProgramWindowButton.setLayoutX(0);
			goBackToProgramWindowButton.setLayoutY(680);
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
