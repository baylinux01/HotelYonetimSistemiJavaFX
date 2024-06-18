package kodcu.hotelManagementSystemJavaFXMaven;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
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
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class AddingReservationWindow extends Application {
	static Dao dao=new Dao();
	static List<Room> availableRooms=new ArrayList<Room>();
	static TextField textField=new TextField();
	static TextField textField2=new TextField();
	static TextField textField3=new TextField();
	static TextField textField4=new TextField();
	static TextField textField2a=new TextField();
	static TextField textField2b=new TextField();
	static ListView<String> listView=new ListView<String>();
	static TextArea textArea=new TextArea();
	static long day=32;
	static long month=13;
	static long year=1000;
	static long daysToStay=1000;
	static Date dateToStart=null;
	static Date dateToEnd=null;
	static long pricePerDay=0;
	static long totalPrice=0;
	static String paidOrUnpaid="";
	static String clientAddress="";
	static String clientNameAndSurname="";
	static String clientPhoneNumber="";
	
	
	public static long getPricePerDay() {
		return pricePerDay;
	}

	public static void setPricePerDay(long pricePerDay) {
		AddingReservationWindow.pricePerDay = pricePerDay;
	}

	public static long getTotalPrice() {
		return totalPrice;
	}

	public static void setTotalPrice(long totalPrice) {
		AddingReservationWindow.totalPrice = totalPrice;
	}

	public static String getPaidOrUnpaid() {
		return paidOrUnpaid;
	}

	public static void setPaidOrUnpaid(String paidOrUnpaid) {
		AddingReservationWindow.paidOrUnpaid = paidOrUnpaid;
	}

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

	public static List<Room> getAvailableRooms() {
		return availableRooms;
	}

	public static void setAvailableRooms(List<Room> availableRooms) {
		AddingReservationWindow.availableRooms = availableRooms;
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
			
			Pane pane=new Pane();
			pane.setPrefSize(340, 720);
			pane.setLayoutX(90);
			pane.setLayoutY(0);
			root.getChildren().add(pane);
			
			Label label=new Label("Choose reservation start day");
			label.setPrefSize(200, 20);
			label.setLayoutX(0);
			label.setLayoutY(10);
			pane.getChildren().add(label);
			
			ComboBox comboBox=new ComboBox();
			comboBox.setPrefSize(200, 20);
			comboBox.setLayoutX(0);
			comboBox.setLayoutY(30);
			comboBox.getItems().addAll("1","2","3","4","5","6","7","8","9","10","11","12",
					"13","14","15","16","17","18","19","20","21","22","23","24","25","26",
					"27","28","29","30","31");
			pane.getChildren().add(comboBox);
			
			Label label2=new Label("Choose reservation start month");
			label2.setPrefSize(200, 20);
			label2.setLayoutX(0);
			label2.setLayoutY(70);
			pane.getChildren().add(label2);
			
			ComboBox comboBox2=new ComboBox();
			comboBox2.setPrefSize(200, 20);
			comboBox2.setLayoutX(0);
			comboBox2.setLayoutY(90);
			comboBox2.getItems().addAll("January","February","March","April","May","June","July","August","September",
					"October","November","December");
			pane.getChildren().add(comboBox2);
			
			Label label3=new Label("Type reservation start year e.g:2025");
			label3.setPrefSize(240, 20);
			label3.setLayoutX(0);
			label3.setLayoutY(130);
			pane.getChildren().add(label3);
			
			textField.setPrefSize(200,20);
			textField.setLayoutX(0);
			textField.setLayoutY(150);
			pane.getChildren().add(textField);
			
			Label label4=new Label("Type how many days to stay");
			label4.setPrefSize(200, 20);
			label4.setLayoutX(0);
			label4.setLayoutY(190);
			pane.getChildren().add(label4);
			
			textField2.setPrefSize(200,20);
			textField2.setLayoutX(0);
			textField2.setLayoutY(210);
			pane.getChildren().add(textField2);
			
			Label label4a=new Label("Price Per Day");
			label4a.setPrefSize(200, 20);
			label4a.setLayoutX(0);
			label4a.setLayoutY(250);
			pane.getChildren().add(label4a);
			
			textField2a.setPrefSize(200,20);
			textField2a.setLayoutX(0);
			textField2a.setLayoutY(270);
			pane.getChildren().add(textField2a);
			
			Label label4b=new Label("Select Paid or Unpaid");
			label4b.setPrefSize(200, 20);
			label4b.setLayoutX(0);
			label4b.setLayoutY(310);
			pane.getChildren().add(label4b);
			
			listView.setPrefSize(200,60);
			listView.setLayoutX(0);
			listView.setLayoutY(330);
			listView.getItems().clear();
			listView.getItems().addAll("Unpaid","Paid");
			listView.getSelectionModel().select(0);
			pane.getChildren().add(listView);
			
			Label label5=new Label("Client Name and Surname");
			label5.setPrefSize(200, 20);
			label5.setLayoutX(0);
			label5.setLayoutY(410);
			pane.getChildren().add(label5);
			
			textField3.setPrefSize(200,20);
			textField3.setLayoutX(0);
			textField3.setLayoutY(430);
			pane.getChildren().add(textField3);
			
			Label label6=new Label("Client Phone Number");
			label6.setPrefSize(200, 20);
			label6.setLayoutX(0);
			label6.setLayoutY(470);
			pane.getChildren().add(label6);
			
			textField4.setPrefSize(200,20);
			textField4.setLayoutX(0);
			textField4.setLayoutY(490);
			pane.getChildren().add(textField4);
			
			Label label7=new Label("Client Address");
			label7.setPrefSize(200, 20);
			label7.setLayoutX(0);
			label7.setLayoutY(530);
			pane.getChildren().add(label7);
			
			textArea.setPrefSize(200,80);
			textArea.setLayoutX(0);
			textArea.setLayoutY(550);
			textArea.setWrapText(true);
			pane.getChildren().add(textArea);
			
			EventHandler<ActionEvent> checkReservationEventHandler=new EventHandler<ActionEvent>() 
			{

				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					
					List<Room> rooms=null;
					
					List<Reservation> reservationsByRoom=null;
					try {
						rooms=dao.getAllRooms();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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
						year=Long.valueOf(textField.getText());
						day=Long.valueOf(comboBox.getValue().toString());
						daysToStay=Long.valueOf(textField2.getText());
						pricePerDay=Long.valueOf(textField2a.getText());
						totalPrice=pricePerDay*daysToStay;
						paidOrUnpaid=listView.getSelectionModel().getSelectedItem().toString();
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
							
							if(rooms!=null)
							{
								for(Room room:rooms)
								{
									try {
										reservationsByRoom=dao.getReservationsByRoom(room.roomNo);
									} catch (SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									if(reservationsByRoom!=null)
									{
										
										for(Reservation reservation: reservationsByRoom)
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
													count++;
												}
												
											}
											
										}
										if(count>=reservationsByRoom.size())
										{
											availableRooms.add(room);
										}
										count=0;
									}
									else
									{
										availableRooms.addAll(rooms);
									}
								}
								textField.setText("");
								textField2.setText("");
								textField2a.setText("");
								listView.getItems().clear();
								textField3.setText("");
								textField4.setText("");
								textArea.setText("");
								Group rootOpenAvailableRoomsWindow=new Group();
								Scene sceneOpenAvailableRoomsWindow=new Scene(rootOpenAvailableRoomsWindow,400,500);
								Stage stageOpenAvailableRoomsWindow=new Stage();
								stageOpenAvailableRoomsWindow.setScene(sceneOpenAvailableRoomsWindow);
								stageOpenAvailableRoomsWindow.getIcons().add(
										new Image(AvailableRoomsWindow.class
										.getResourceAsStream("hotelLogo.png")));
								stageOpenAvailableRoomsWindow.setTitle("Available Rooms");
								//stageOpenAidatPayerAddingWindow.show();
								AvailableRoomsWindow openAvailableRoomsWindow=new AvailableRoomsWindow();
								try {
									
									openAvailableRoomsWindow.start(stageOpenAvailableRoomsWindow);
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
			
			Button checkReservationButton=new Button("Check Room");
			checkReservationButton.setPrefSize(200, 20);
			checkReservationButton.setLayoutX(0);
			checkReservationButton.setLayoutY(640);
			pane.getChildren().add(checkReservationButton);
			checkReservationButton.setOnAction(checkReservationEventHandler);
			
			EventHandler<ActionEvent> goBackToProgramWindowEventHandler=new EventHandler<ActionEvent>() 
			{

				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					Group rootProgramWindow=new Group();
					Scene sceneProgramWindow=new Scene(rootProgramWindow,1200,700);
					Stage stageProgramWindow=new Stage();
					stageProgramWindow.setScene(sceneProgramWindow);
//					stageOpenDBChoosingWindow.getIcons().add(
//							new Image(DBChoosingWindow.class
//							.getResourceAsStream("aidatTakipLogo.jpg")));
					
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
