package kodcu.hotelManagementSystemJavaFXMaven;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javafx.application.Application;
import javafx.event.ActionEvent;

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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;




public class ProgramWindow extends Application {
	protected static TableView<ReservationToShow> tableView=new TableView<ReservationToShow>();
	protected static ComboBox cb=new ComboBox<Long>();
	protected static List<Reservation> reservations=null;
	protected static List<ReservationToShow> reservationsToShow=null;
	protected static long roomNo;
	protected static String language;
	protected static ComboBox<String> cblanguage;
	protected static Label labelA,labelB;
	protected static TextField textFieldA,textFieldB;
	protected static Button openAddingRoomWindowButton,openAddingReservationWindowButton,
	openRoomDeletingWindowButton,clearDatabaseButton,deleteReservationButton,updateReservationButton;
	
	@Override
	public void start(Stage primaryStage) throws InterruptedException {
		try {
			
			
			Group root = new Group();
			Scene scene = new Scene(root,1300,700);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
			Dao dao=new Dao();
			dao.createDatabase(Dao.getPrefSchema());
			dao.clearDefaultDBInformationTable();
			dao.createDefaultDBInformationTable();
			dao.insertIntoDefaultDBInformationTable
			("Sqlite", "", "", "hotelmanagement", "", "");
			dao.insertIntoDefaultDBInformationTable
			("MySql", "localhost","3306", "hotelmanagement","root", "");
			dao.insertIntoDefaultDBInformationTable
			("MariaDB", "localhost","3306", "hotelmanagement","root", "");
			dao.insertIntoDefaultDBInformationTable
			("PostgreSql", "localhost","5432", "hotelmanagement","postgres", "");
			
			dao.CreateRoomTable();
			dao.createReservationTable();
			
			 
			
			EventHandler<ActionEvent> changeLanguageEventHandler=new EventHandler<ActionEvent>() 
			{

				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					language=cblanguage.getValue();
					if(language.equals("English"))
					{
						
						openAddingRoomWindowButton.setText("Add Room");
						openAddingReservationWindowButton.setText("Add Reservation");
						openRoomDeletingWindowButton.setText("Delete Room");
						clearDatabaseButton.setText("Clear Database");
						deleteReservationButton.setText("Delete Selected Reservation");
						updateReservationButton.setText("Update Selected Reservation");
						labelA.setText("Total Paid");
						labelB.setText("Total Unpaid");
						tableView.getItems().clear();
						tableView.getColumns().clear();
						textFieldA.setText("");
						textFieldB.setText("");
						TableColumn<ReservationToShow, Long> col1=new TableColumn<ReservationToShow, Long>("Reservation No");
						TableColumn<ReservationToShow, String> col2=new TableColumn<ReservationToShow, String>("Reservation Start Date");
						TableColumn<ReservationToShow, String> col3=new TableColumn<ReservationToShow, String>("Reservation End Date");
						TableColumn<ReservationToShow, Long> col4=new TableColumn<ReservationToShow, Long>("Room No");
						TableColumn<ReservationToShow, Long> col5=new TableColumn<ReservationToShow, Long>("Days To Stay");
						TableColumn<ReservationToShow, Long> col6=new TableColumn<ReservationToShow, Long>("Price Per Day");
						TableColumn<ReservationToShow, Long> col7=new TableColumn<ReservationToShow, Long>("Total Price");
						TableColumn<ReservationToShow, String> col8=new TableColumn<ReservationToShow, String>("Paid or Unpaid");
						TableColumn<ReservationToShow, Long> col9=new TableColumn<ReservationToShow, Long>("Client Name and Surname");
						TableColumn<ReservationToShow, Long> col10=new TableColumn<ReservationToShow, Long>("Client Phone Number");
						TableColumn<ReservationToShow, Long> col11=new TableColumn<ReservationToShow, Long>("Client Address");
						
						col1.setCellValueFactory(new PropertyValueFactory<ReservationToShow, Long>("reservationNo"));
						col2.setCellValueFactory(new PropertyValueFactory<ReservationToShow, String>("reservationStartDate"));
						col3.setCellValueFactory(new PropertyValueFactory<ReservationToShow, String>("reservationEndDate"));
						col4.setCellValueFactory(new PropertyValueFactory<ReservationToShow, Long>("roomNo"));
						col5.setCellValueFactory(new PropertyValueFactory<ReservationToShow, Long>("daysToStay"));
						col6.setCellValueFactory(new PropertyValueFactory<ReservationToShow, Long>("pricePerDay"));
						col7.setCellValueFactory(new PropertyValueFactory<ReservationToShow, Long>("totalPrice"));
						col8.setCellValueFactory(new PropertyValueFactory<ReservationToShow, String>("paidOrUnpaid"));
						col9.setCellValueFactory(new PropertyValueFactory<ReservationToShow, Long>("clientNameAndSurname"));
						col10.setCellValueFactory(new PropertyValueFactory<ReservationToShow, Long>("clientCellPhone"));
						col11.setCellValueFactory(new PropertyValueFactory<ReservationToShow, Long>("clientAddress"));
						
						
						col1.setMinWidth(100);
						col2.setMinWidth(120);
						col3.setMinWidth(120);
						col4.setMinWidth(40);
						col5.setMinWidth(60);
						col6.setMinWidth(60);
						col7.setMinWidth(60);
						col8.setMinWidth(110);
						col9.setMinWidth(140);
						col10.setMinWidth(120);
						col11.setMinWidth(240);
						//col11.setMaxWidth(200);
						
						
						col1.setStyle("-fx-font:normal bold 10px 'serif' ");
						col2.setStyle("-fx-font:normal bold 10px 'serif' ");
						col3.setStyle("-fx-font:normal bold 10px 'serif' ");
						col4.setStyle("-fx-font:normal bold 10px 'serif' ");
						col5.setStyle("-fx-font:normal bold 10px 'serif' ");
						col6.setStyle("-fx-font:normal bold 10px 'serif' ");
						col7.setStyle("-fx-font:normal bold 10px 'serif' ");
						col8.setStyle("-fx-font:normal bold 10px 'serif' ");
						col9.setStyle("-fx-font:normal bold 10px 'serif' ");
						col10.setStyle("-fx-font:normal bold 10px 'serif' ");
						col11.setStyle("-fx-font:normal bold 10px 'serif' ");
						
						tableView.getColumns().add(col1);
						tableView.getColumns().add(col2);
						tableView.getColumns().add(col3);
						tableView.getColumns().add(col4);
						tableView.getColumns().add(col5);
						tableView.getColumns().add(col6);
						tableView.getColumns().add(col7);
						tableView.getColumns().add(col8);
						tableView.getColumns().add(col9);
						tableView.getColumns().add(col10);
						tableView.getColumns().add(col11);
						reservations.clear();
						reservationsToShow.clear();

						cb.getSelectionModel().select(null);
						tableView.getItems().clear();					
						
						
						
					}
					else if(language.equals("Türkçe"))
					{
						
						openAddingRoomWindowButton.setText("Oda Ekle");
						openAddingReservationWindowButton.setText("Reservasyon Ekle");
						openRoomDeletingWindowButton.setText("Oda Sil");
						clearDatabaseButton.setText("Veritabanını Temizle");
						deleteReservationButton.setText("Seçili Rezervasyonu Sil");
						updateReservationButton.setText("Seçili Reservasyonu Güncelle");
						labelA.setText("Ödenmiş Toplam");
						labelB.setText("Ödenmemiş Toplam");
						tableView.getItems().clear();
						tableView.getColumns().clear();
						textFieldA.setText("");
						textFieldB.setText("");
						TableColumn<ReservationToShow, Long> col1=new TableColumn<ReservationToShow, Long>("Rezervasyon No");
						TableColumn<ReservationToShow, String> col2=new TableColumn<ReservationToShow, String>("Rezervasyon Başlangıç");
						TableColumn<ReservationToShow, String> col3=new TableColumn<ReservationToShow, String>("Rezervasyon Bitiş");
						TableColumn<ReservationToShow, Long> col4=new TableColumn<ReservationToShow, Long>("Oda No");
						TableColumn<ReservationToShow, Long> col5=new TableColumn<ReservationToShow, Long>("Kalınacak Gün");
						TableColumn<ReservationToShow, Long> col6=new TableColumn<ReservationToShow, Long>("Günlük Ücret");
						TableColumn<ReservationToShow, Long> col7=new TableColumn<ReservationToShow, Long>("Toplam Ücret");
						TableColumn<ReservationToShow, String> col8=new TableColumn<ReservationToShow, String>("Ödenme Durumu");
						TableColumn<ReservationToShow, Long> col9=new TableColumn<ReservationToShow, Long>("Müşteri Adı Soyadı");
						TableColumn<ReservationToShow, Long> col10=new TableColumn<ReservationToShow, Long>("Müşteri Telefon No");
						TableColumn<ReservationToShow, Long> col11=new TableColumn<ReservationToShow, Long>("Müşteri Adres");
						
						col1.setCellValueFactory(new PropertyValueFactory<ReservationToShow, Long>("reservationNo"));
						col2.setCellValueFactory(new PropertyValueFactory<ReservationToShow, String>("reservationStartDate"));
						col3.setCellValueFactory(new PropertyValueFactory<ReservationToShow, String>("reservationEndDate"));
						col4.setCellValueFactory(new PropertyValueFactory<ReservationToShow, Long>("roomNo"));
						col5.setCellValueFactory(new PropertyValueFactory<ReservationToShow, Long>("daysToStay"));
						col6.setCellValueFactory(new PropertyValueFactory<ReservationToShow, Long>("pricePerDay"));
						col7.setCellValueFactory(new PropertyValueFactory<ReservationToShow, Long>("totalPrice"));
						col8.setCellValueFactory(new PropertyValueFactory<ReservationToShow, String>("paidOrUnpaid"));
						col9.setCellValueFactory(new PropertyValueFactory<ReservationToShow, Long>("clientNameAndSurname"));
						col10.setCellValueFactory(new PropertyValueFactory<ReservationToShow, Long>("clientCellPhone"));
						col11.setCellValueFactory(new PropertyValueFactory<ReservationToShow, Long>("clientAddress"));
						
						
						col1.setMinWidth(100);
						col2.setMinWidth(120);
						col3.setMinWidth(120);
						col4.setMinWidth(40);
						col5.setMinWidth(60);
						col6.setMinWidth(60);
						col7.setMinWidth(60);
						col8.setMinWidth(110);
						col9.setMinWidth(140);
						col10.setMinWidth(120);
						col11.setMinWidth(240);
						//col11.setMaxWidth(200);
						
						
						col1.setStyle("-fx-font:normal bold 10px 'serif' ");
						col2.setStyle("-fx-font:normal bold 10px 'serif' ");
						col3.setStyle("-fx-font:normal bold 10px 'serif' ");
						col4.setStyle("-fx-font:normal bold 10px 'serif' ");
						col5.setStyle("-fx-font:normal bold 10px 'serif' ");
						col6.setStyle("-fx-font:normal bold 10px 'serif' ");
						col7.setStyle("-fx-font:normal bold 10px 'serif' ");
						col8.setStyle("-fx-font:normal bold 10px 'serif' ");
						col9.setStyle("-fx-font:normal bold 10px 'serif' ");
						col10.setStyle("-fx-font:normal bold 10px 'serif' ");
						col11.setStyle("-fx-font:normal bold 10px 'serif' ");
						
						tableView.getColumns().add(col1);
						tableView.getColumns().add(col2);
						tableView.getColumns().add(col3);
						tableView.getColumns().add(col4);
						tableView.getColumns().add(col5);
						tableView.getColumns().add(col6);
						tableView.getColumns().add(col7);
						tableView.getColumns().add(col8);
						tableView.getColumns().add(col9);
						tableView.getColumns().add(col10);
						tableView.getColumns().add(col11);
						reservations.clear();
						reservationsToShow.clear();
						cb.getSelectionModel().select(null);
						tableView.getItems().clear();
						
					}
					
					
					
					
				}
				
			};
			cblanguage=new ComboBox<String>();
			cblanguage.setPrefSize(200, 20);
			cblanguage.setLayoutX(1060);
			cblanguage.setLayoutY(20);
			cblanguage.getItems().addAll("English","Türkçe");
			if(language.equals("English"))
			cblanguage.getSelectionModel().select(0);
			if(language.equals("Türkçe"))
				cblanguage.getSelectionModel().select(1);
			cblanguage.setOnAction(changeLanguageEventHandler);
			root.getChildren().add(cblanguage);
			
			Pane pane=new Pane();
			pane.setPrefSize(700, 700);
			pane.setLayoutX(410);
			pane.setLayoutY(600);
			root.getChildren().add(pane);
			
			Pane pane2=new Pane();
			pane2.setPrefSize(700, 700);
			pane2.setLayoutX(630);
			pane2.setLayoutY(600);
			root.getChildren().add(pane2);
			
			Pane pane3=new Pane();
			pane3.setPrefSize(700, 700);
			pane3.setLayoutX(850);
			pane3.setLayoutY(600);
			root.getChildren().add(pane3);
			
			labelA=new Label("Total Paid");
			if(language.equals("English"))
				labelA.setText("Total Paid");
			if(language.equals("Türkçe"))
				labelA.setText("Ödenmiş Toplam");
			labelA.setPrefSize(140, 20);
			labelA.setLayoutX(0);
			labelA.setLayoutY(20);
			pane3.getChildren().add(labelA);
			
			textFieldA=new TextField();
			textFieldA.setPrefSize(140,20);
			textFieldA.setLayoutX(0);
			textFieldA.setLayoutY(40);
			textFieldA.setEditable(false);
			textFieldA.setText("");
			pane3.getChildren().add(textFieldA);
			
			labelB=new Label("Total Unpaid");
			if(language.equals("English"))
				labelB.setText("Total Unpaid");
			if(language.equals("Türkçe"))
				labelB.setText("Ödenmemiş Toplam");
			labelB.setPrefSize(140, 20);
			labelB.setLayoutX(170);
			labelB.setLayoutY(20);
			pane3.getChildren().add(labelB);
			
			textFieldB=new TextField();
			textFieldB.setPrefSize(140,20);
			textFieldB.setLayoutX(170);
			textFieldB.setLayoutY(40);
			textFieldB.setEditable(false);
			textFieldB.setText("");
			pane3.getChildren().add(textFieldB);
			
			EventHandler<ActionEvent> openAddingRoomWindowEventHandler=new EventHandler<ActionEvent>() 
			{

				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub

					Group rootOpenAddingRoomWindow=new Group();
					Scene sceneOpenAddingRoomWindow=new Scene(rootOpenAddingRoomWindow);
					Stage stageOpenAddingRoomWindow=new Stage();
					stageOpenAddingRoomWindow.setScene(sceneOpenAddingRoomWindow);
					stageOpenAddingRoomWindow.getIcons().add(
							new Image(AddingRoomWindow.class
							.getResourceAsStream("hotelLogo.png")));
					if(language.equals("English"))
					stageOpenAddingRoomWindow.setTitle("Room Adding Page");
					if(language.equals("Türkçe"))
						stageOpenAddingRoomWindow.setTitle("Oda Ekleme Sayfası");
					//stageOpenAidatPayerAddingWindow.show();
					AddingRoomWindow openAddingRoomWindow=new AddingRoomWindow();
					try {
						openAddingRoomWindow.language=language;
						openAddingRoomWindow.start(stageOpenAddingRoomWindow);
						primaryStage.hide();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
			};
			
			openAddingRoomWindowButton=new Button("Add Room");
			if(language!=null && language.equals("Türkçe"))
				openAddingRoomWindowButton.setText("Oda Ekle");
			if(language!=null && language.equals("English"))
				openAddingRoomWindowButton.setText("Add Room");
			openAddingRoomWindowButton.setPrefSize(200, 20);
			openAddingRoomWindowButton.setLayoutX(0);
			openAddingRoomWindowButton.setLayoutY(0);
			pane.getChildren().add(openAddingRoomWindowButton);
			openAddingRoomWindowButton.setOnAction(openAddingRoomWindowEventHandler);
			
			EventHandler<ActionEvent> openAddingReservationWindowEventHandler=new EventHandler<ActionEvent>() 
			{

				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub

					Group rootOpenAddingReservationWindow=new Group();
					Scene sceneOpenAddingReservationWindow=new Scene(rootOpenAddingReservationWindow);
					Stage stageOpenAddingReservationWindow=new Stage();
					stageOpenAddingReservationWindow.setScene(sceneOpenAddingReservationWindow);
					stageOpenAddingReservationWindow.getIcons().add(
							new Image(AddingReservationWindow.class
							.getResourceAsStream("hotelLogo.png")));
					stageOpenAddingReservationWindow.setTitle("Rezervation Query Page");
					if(language.equals("English"))
					stageOpenAddingReservationWindow.setTitle("Rezervation Query Page");
					if(language.equals("Türkçe"))
					stageOpenAddingReservationWindow.setTitle("Rezervasyon Sorgulama Sayfası");
					//stageOpenAidatPayerAddingWindow.show();
					AddingReservationWindow openAddingReservationWindow=new AddingReservationWindow();
					try {
						openAddingReservationWindow.language=language;
						openAddingReservationWindow.start(stageOpenAddingReservationWindow);
						primaryStage.hide();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
			};
			
			openAddingReservationWindowButton=new Button("Add Reservation");
			if(language!=null && language.equals("Türkçe"))
				openAddingReservationWindowButton.setText("Reservasyon Ekle");
			if(language!=null && language.equals("English"))
				openAddingReservationWindowButton.setText("Add Reservation");
			openAddingReservationWindowButton.setPrefSize(200, 20);
			openAddingReservationWindowButton.setLayoutX(0);
			openAddingReservationWindowButton.setLayoutY(40);
			pane.getChildren().add(openAddingReservationWindowButton);
			openAddingReservationWindowButton.setOnAction(openAddingReservationWindowEventHandler);
			
			EventHandler<ActionEvent> openRoomDeletingWindowEventHandler=new EventHandler<ActionEvent>() 
			{

				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub

					Group rootOpenRoomDeletingWindow=new Group();
					Scene sceneOpenRoomDeletingWindow=new Scene(rootOpenRoomDeletingWindow);
					Stage stageOpenRoomDeletingWindow=new Stage();
					stageOpenRoomDeletingWindow.setScene(sceneOpenRoomDeletingWindow);
					stageOpenRoomDeletingWindow.getIcons().add(
							new Image(RoomDeletingWindow.class
							.getResourceAsStream("hotelLogo.png")));
					stageOpenRoomDeletingWindow.setTitle("Room Deletion Page");
					if(language.equals("English"))
						stageOpenRoomDeletingWindow.setTitle("Room Deletion Page");
						if(language.equals("Türkçe"))
						stageOpenRoomDeletingWindow.setTitle("Oda Silme Sayfası");
					//stageOpenAidatPayerAddingWindow.show();
					RoomDeletingWindow openRoomDeletingWindow=new RoomDeletingWindow();
					try {
						openRoomDeletingWindow.language=language;
						openRoomDeletingWindow.start(stageOpenRoomDeletingWindow);
						primaryStage.hide();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
			};
			
			openRoomDeletingWindowButton=new Button("Delete Room");
			if(language!=null && language.equals("Türkçe"))
				openRoomDeletingWindowButton.setText("Oda Sil");
			if(language!=null && language.equals("English"))
				openRoomDeletingWindowButton.setText("Delete Room");
			openRoomDeletingWindowButton.setPrefSize(200, 20);
			openRoomDeletingWindowButton.setLayoutX(0);
			openRoomDeletingWindowButton.setLayoutY(0);
			pane2.getChildren().add(openRoomDeletingWindowButton);
			openRoomDeletingWindowButton.setOnAction(openRoomDeletingWindowEventHandler);
			
			EventHandler<ActionEvent> clearDatabaseEventHandler=new EventHandler<ActionEvent>() 
			{

				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					if(language.equals("English"))
					{
						Alert alert=new Alert(AlertType.CONFIRMATION);
						alert.setTitle("Caution");
						alert.setHeaderText("Caution");
						alert.setContentText("If you do that, database will completely be deleted");
						ButtonType bt=alert.showAndWait().orElse(null);
						if(bt.equals(ButtonType.OK))
						{
							try {
								dao.deleteAllFromReservationTable();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							try {
								dao.deleteAllFromRoomTable();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							tableView.getItems().clear();
							cb.getItems().clear();
							AvailableRoomsWindow.listView.getItems().clear();
							textFieldA.setText("");
							textFieldB.setText("");
//							totalPaid=0;
//							totalUnpaid=0;
						}
						return;
					}
					if(language.equals("Türkçe"))
					{
						Alert alert=new Alert(AlertType.CONFIRMATION);
						alert.setTitle("Dikkat");
						alert.setHeaderText("Uyarı");
						alert.setContentText("Bunu yaparsanız veritabanı tamamen silinecektir");
						ButtonType bt=alert.showAndWait().orElse(null);
						if(bt.equals(ButtonType.OK))
						{
							try {
								dao.deleteAllFromReservationTable();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							try {
								dao.deleteAllFromRoomTable();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							tableView.getItems().clear();
							cb.getItems().clear();
							AvailableRoomsWindow.listView.getItems().clear();
							textFieldA.setText("");
							textFieldB.setText("");
//							totalPaid=0;
//							totalUnpaid=0;
						}
						return;
					}
					
					
					
					
				}
				
			};
			
			clearDatabaseButton=new Button("Clear Database");
			if(language!=null && language.equals("Türkçe"))
				clearDatabaseButton.setText("Veritabanını Sil");
			if(language!=null && language.equals("English"))
				clearDatabaseButton.setText("Clear Database");
			clearDatabaseButton.setPrefSize(200, 20);
			clearDatabaseButton.setLayoutX(0);
			clearDatabaseButton.setLayoutY(40);
			pane2.getChildren().add(clearDatabaseButton);
			clearDatabaseButton.setOnAction(clearDatabaseEventHandler);
			
			EventHandler<ActionEvent> fillTableViewEventHandler=new EventHandler<ActionEvent>() 
			{

				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					tableView.getItems().clear();
					textFieldA.setText("");
					textFieldB.setText("");
					if(cb.getValue()!=null)
					 roomNo=Long.valueOf(cb.getValue().toString());
					 long totalPaid=0;
					 long totalUnpaid=0;
					try {
						reservations=dao.getReservationsByRoom(roomNo);
						reservationsToShow=new ArrayList<ReservationToShow>();
						for(Reservation reserv: reservations)
						{
							ReservationToShow rTr=new ReservationToShow();
							rTr.setTotalPrice(reserv.getTotalPrice());
							rTr.setRoomNo(reserv.getRoomNo());
							rTr.setReservationStartDate(reserv.getReservationStartDate());
							rTr.setReservationNo(reserv.getReservationNo());
							rTr.setReservationEndDate(reserv.getReservationEndDate());
							rTr.setPricePerDay(reserv.getPricePerDay());
							if(language!=null && language.equals("Türkçe"))
							{
								if(reserv.getPaidOrUnpaid().equals("Paid"))
									rTr.setPaidOrUnpaid("Ödendi");
								if(reserv.getPaidOrUnpaid().equals("Unpaid"))
									rTr.setPaidOrUnpaid("Ödenmedi");
							}
							if(language!=null && language.equals("English"))
								rTr.setPaidOrUnpaid(reserv.getPaidOrUnpaid());
							rTr.setDaysToStay(reserv.getDaysToStay());
							rTr.setClientNameAndSurname(reserv.getClientNameAndSurname());
							rTr.setClientCellPhone(reserv.getClientCellPhone());
							rTr.setClientAddress(reserv.getClientAddress());
							reservationsToShow.add(rTr);
							
						}
						totalPaid=dao.getTotalOfPaidReservations();
						totalUnpaid=dao.getTotalOfUnpaidReservations();
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					tableView.getItems().addAll(reservationsToShow);
					textFieldA.setText(String.valueOf(totalPaid));
					textFieldB.setText(String.valueOf(totalUnpaid));
					
					
				}
				
			};
			
			List<Room> rooms=dao.getAllRooms();
			Set<Long> roomNos=new TreeSet<Long>();
			for(Room room: rooms)
			{
				roomNos.add(room.getRoomNo());
			}
			cb.setPrefSize(190, 20);
			cb.setLayoutX(20);
			cb.setLayoutY(20);
			cb.getItems().clear();
			cb.getItems().addAll(roomNos);
			root.getChildren().add(cb);
			cb.setOnAction(fillTableViewEventHandler);
			
			tableView=new TableView<ReservationToShow>();
			tableView.setPrefSize(1240, 520);
			tableView.setLayoutX(20);
			tableView.setLayoutY(60);
			root.getChildren().add(tableView);
			if(language!=null && language.equals("English"))
			{
			TableColumn<ReservationToShow, Long> col1=new TableColumn<ReservationToShow, Long>("Reservation No");
			TableColumn<ReservationToShow, String> col2=new TableColumn<ReservationToShow, String>("Reservation Start Date");
			TableColumn<ReservationToShow, String> col3=new TableColumn<ReservationToShow, String>("Reservation End Date");
			TableColumn<ReservationToShow, Long> col4=new TableColumn<ReservationToShow, Long>("Room No");
			TableColumn<ReservationToShow, Long> col5=new TableColumn<ReservationToShow, Long>("Days To Stay");
			TableColumn<ReservationToShow, Long> col6=new TableColumn<ReservationToShow, Long>("Price Per Day");
			TableColumn<ReservationToShow, Long> col7=new TableColumn<ReservationToShow, Long>("Total Price");
			TableColumn<ReservationToShow, String> col8=new TableColumn<ReservationToShow, String>("Paid or Unpaid");
			TableColumn<ReservationToShow, Long> col9=new TableColumn<ReservationToShow, Long>("Client Name and Surname");
			TableColumn<ReservationToShow, Long> col10=new TableColumn<ReservationToShow, Long>("Client Phone Number");
			TableColumn<ReservationToShow, Long> col11=new TableColumn<ReservationToShow, Long>("Client Address");
			
			col1.setCellValueFactory(new PropertyValueFactory<ReservationToShow, Long>("reservationNo"));
			col2.setCellValueFactory(new PropertyValueFactory<ReservationToShow, String>("reservationStartDate"));
			col3.setCellValueFactory(new PropertyValueFactory<ReservationToShow, String>("reservationEndDate"));
			col4.setCellValueFactory(new PropertyValueFactory<ReservationToShow, Long>("roomNo"));
			col5.setCellValueFactory(new PropertyValueFactory<ReservationToShow, Long>("daysToStay"));
			col6.setCellValueFactory(new PropertyValueFactory<ReservationToShow, Long>("pricePerDay"));
			col7.setCellValueFactory(new PropertyValueFactory<ReservationToShow, Long>("totalPrice"));
			col8.setCellValueFactory(new PropertyValueFactory<ReservationToShow, String>("paidOrUnpaid"));
			col9.setCellValueFactory(new PropertyValueFactory<ReservationToShow, Long>("clientNameAndSurname"));
			col10.setCellValueFactory(new PropertyValueFactory<ReservationToShow, Long>("clientCellPhone"));
			col11.setCellValueFactory(new PropertyValueFactory<ReservationToShow, Long>("clientAddress"));
			
			
			col1.setMinWidth(100);
			col2.setMinWidth(120);
			col3.setMinWidth(120);
			col4.setMinWidth(40);
			col5.setMinWidth(60);
			col6.setMinWidth(60);
			col7.setMinWidth(60);
			col8.setMinWidth(110);
			col9.setMinWidth(140);
			col10.setMinWidth(120);
			col11.setMinWidth(240);
			//col11.setMaxWidth(200);
			
			
			
			col1.setStyle("-fx-font:normal bold 10px 'serif' ");
			col2.setStyle("-fx-font:normal bold 10px 'serif' ");
			col3.setStyle("-fx-font:normal bold 10px 'serif' ");
			col4.setStyle("-fx-font:normal bold 10px 'serif' ");
			col5.setStyle("-fx-font:normal bold 10px 'serif' ");
			col6.setStyle("-fx-font:normal bold 10px 'serif' ");
			col7.setStyle("-fx-font:normal bold 10px 'serif' ");
			col8.setStyle("-fx-font:normal bold 10px 'serif' ");
			col9.setStyle("-fx-font:normal bold 10px 'serif' ");
			col10.setStyle("-fx-font:normal bold 10px 'serif' ");
			col11.setStyle("-fx-font:normal bold 10px 'serif' ");
			
			tableView.getColumns().add(col1);
			tableView.getColumns().add(col2);
			tableView.getColumns().add(col3);
			tableView.getColumns().add(col4);
			tableView.getColumns().add(col5);
			tableView.getColumns().add(col6);
			tableView.getColumns().add(col7);
			tableView.getColumns().add(col8);
			tableView.getColumns().add(col9);
			tableView.getColumns().add(col10);
			tableView.getColumns().add(col11);
			//tableview.autosize();
			}
			if(language!=null && language.equals("Türkçe"))
			{
			TableColumn<ReservationToShow, Long> col1=new TableColumn<ReservationToShow, Long>("Rezervasyon No");
			TableColumn<ReservationToShow, String> col2=new TableColumn<ReservationToShow, String>("Rezervasyon Başlangıç");
			TableColumn<ReservationToShow, String> col3=new TableColumn<ReservationToShow, String>("Rezervasyon Bitiş");
			TableColumn<ReservationToShow, Long> col4=new TableColumn<ReservationToShow, Long>("Oda No");
			TableColumn<ReservationToShow, Long> col5=new TableColumn<ReservationToShow, Long>("Kalınacak Gün");
			TableColumn<ReservationToShow, Long> col6=new TableColumn<ReservationToShow, Long>("Günlük Ücret");
			TableColumn<ReservationToShow, Long> col7=new TableColumn<ReservationToShow, Long>("Toplam Ücret");
			TableColumn<ReservationToShow, String> col8=new TableColumn<ReservationToShow, String>("Ödenme Durumu");
			TableColumn<ReservationToShow, Long> col9=new TableColumn<ReservationToShow, Long>("Müşteri Adı Soyadı");
			TableColumn<ReservationToShow, Long> col10=new TableColumn<ReservationToShow, Long>("Müşteri Telefon No");
			TableColumn<ReservationToShow, Long> col11=new TableColumn<ReservationToShow, Long>("Müşteri Adres");
			
			col1.setCellValueFactory(new PropertyValueFactory<ReservationToShow, Long>("reservationNo"));
			col2.setCellValueFactory(new PropertyValueFactory<ReservationToShow, String>("reservationStartDate"));
			col3.setCellValueFactory(new PropertyValueFactory<ReservationToShow, String>("reservationEndDate"));
			col4.setCellValueFactory(new PropertyValueFactory<ReservationToShow, Long>("roomNo"));
			col5.setCellValueFactory(new PropertyValueFactory<ReservationToShow, Long>("daysToStay"));
			col6.setCellValueFactory(new PropertyValueFactory<ReservationToShow, Long>("pricePerDay"));
			col7.setCellValueFactory(new PropertyValueFactory<ReservationToShow, Long>("totalPrice"));
			col8.setCellValueFactory(new PropertyValueFactory<ReservationToShow, String>("paidOrUnpaid"));
			col9.setCellValueFactory(new PropertyValueFactory<ReservationToShow, Long>("clientNameAndSurname"));
			col10.setCellValueFactory(new PropertyValueFactory<ReservationToShow, Long>("clientCellPhone"));
			col11.setCellValueFactory(new PropertyValueFactory<ReservationToShow, Long>("clientAddress"));
			
			
			col1.setMinWidth(100);
			col2.setMinWidth(120);
			col3.setMinWidth(120);
			col4.setMinWidth(40);
			col5.setMinWidth(60);
			col6.setMinWidth(60);
			col7.setMinWidth(60);
			col8.setMinWidth(110);
			col9.setMinWidth(140);
			col10.setMinWidth(120);
			col11.setMinWidth(240);
			//col11.setMaxWidth(200);
			
			
			col1.setStyle("-fx-font:normal bold 10px 'serif' ");
			col2.setStyle("-fx-font:normal bold 10px 'serif' ");
			col3.setStyle("-fx-font:normal bold 10px 'serif' ");
			col4.setStyle("-fx-font:normal bold 10px 'serif' ");
			col5.setStyle("-fx-font:normal bold 10px 'serif' ");
			col6.setStyle("-fx-font:normal bold 10px 'serif' ");
			col7.setStyle("-fx-font:normal bold 10px 'serif' ");
			col8.setStyle("-fx-font:normal bold 10px 'serif' ");
			col9.setStyle("-fx-font:normal bold 10px 'serif' ");
			col10.setStyle("-fx-font:normal bold 10px 'serif' ");
			col11.setStyle("-fx-font:normal bold 10px 'serif' ");
			
			tableView.getColumns().add(col1);
			tableView.getColumns().add(col2);
			tableView.getColumns().add(col3);
			tableView.getColumns().add(col4);
			tableView.getColumns().add(col5);
			tableView.getColumns().add(col6);
			tableView.getColumns().add(col7);
			tableView.getColumns().add(col8);
			tableView.getColumns().add(col9);
			tableView.getColumns().add(col10);
			tableView.getColumns().add(col11);
			//tableview.autosize();
			}
			EventHandler<ActionEvent> deleteReservationEventHandler=new EventHandler<ActionEvent>() 
			{

				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
						ReservationToShow reservationts=tableView.getSelectionModel().getSelectedItem();
						Reservation reservation=new Reservation(reservationts);
						try {
							dao.deleteFromReservationTable(reservation.getReservationNo());
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						tableView.getItems().clear();

						try {
							reservations=dao.getReservationsByRoom(roomNo);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						reservationsToShow=new ArrayList<ReservationToShow>();
						for(Reservation reserv: reservations)
						{
							ReservationToShow rTr=new ReservationToShow();
							rTr.setTotalPrice(reserv.getTotalPrice());
							rTr.setRoomNo(reserv.getRoomNo());
							rTr.setReservationStartDate(reserv.getReservationStartDate());
							rTr.setReservationNo(reserv.getReservationNo());
							rTr.setReservationEndDate(reserv.getReservationEndDate());
							rTr.setPricePerDay(reserv.getPricePerDay());
							if(language!=null && language.equals("Türkçe"))
							{
								if(reserv.getPaidOrUnpaid().equals("Paid"))
									rTr.setPaidOrUnpaid("Ödendi");
								if(reserv.getPaidOrUnpaid().equals("Unpaid"))
									rTr.setPaidOrUnpaid("Ödenmedi");
							}
							if(language!=null && language.equals("English"))
								rTr.setPaidOrUnpaid(reserv.getPaidOrUnpaid());
							rTr.setDaysToStay(reserv.getDaysToStay());
							rTr.setClientNameAndSurname(reserv.getClientNameAndSurname());
							rTr.setClientCellPhone(reserv.getClientCellPhone());
							rTr.setClientAddress(reserv.getClientAddress());
							reservationsToShow.add(rTr);
							
						}
						tableView.getItems().addAll(reservationsToShow);
					
					
				}
				
			};
			
			deleteReservationButton=new Button("Delete Selected Reservation");
			if(language!=null && language.equals("Türkçe"))
				deleteReservationButton.setText("Seçili Reservasyonu Sil");
			if(language!=null && language.equals("English"))
				deleteReservationButton.setText("Delete Selected Reservation");
			deleteReservationButton.setPrefSize(230, 20);
			deleteReservationButton.setLayoutX(160);
			deleteReservationButton.setLayoutY(600);
			root.getChildren().add(deleteReservationButton);
			deleteReservationButton.setOnAction(deleteReservationEventHandler);
			
			EventHandler<ActionEvent> updateReservationEventHandler=new EventHandler<ActionEvent>() 
			{

				@Override
				public void handle(ActionEvent event) {
					if(tableView.getSelectionModel().getSelectedItem()!=null)
					{
						Group rootOpenUpdateReservationWindow=new Group();
						Scene sceneOpenUpdateReservationWindow=new Scene(rootOpenUpdateReservationWindow);
						Stage stageOpenUpdateReservationWindow=new Stage();
						stageOpenUpdateReservationWindow.setScene(sceneOpenUpdateReservationWindow);
						stageOpenUpdateReservationWindow.getIcons().add(
								new Image(ReservationUpdatingWindow.class
								.getResourceAsStream("hotelLogo.png")));
						stageOpenUpdateReservationWindow.setTitle("Reservation Updating Page");
						if(language.equals("English"))
							stageOpenUpdateReservationWindow.setTitle("Reservation Updating Page");
							if(language.equals("Türkçe"))
							stageOpenUpdateReservationWindow.setTitle("Rezervasyon Güncelleme Sayfası");
						//stageOpenAidatPayerAddingWindow.show();
						ReservationUpdatingWindow openUpdateReservationWindow=new ReservationUpdatingWindow();
						try {
							
							openUpdateReservationWindow.language=language;
							openUpdateReservationWindow.start(stageOpenUpdateReservationWindow);
							primaryStage.hide();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					
				}
				
			};
			
			updateReservationButton=new Button("Update Selected Reservation");
			if(language!=null && language.equals("Türkçe"))
				updateReservationButton.setText("Seçili Reservasyonu Güncelle");
			if(language!=null && language.equals("English"))
				updateReservationButton.setText("Update Selected Reservation");
			updateReservationButton.setPrefSize(230, 20);
			updateReservationButton.setLayoutX(160);
			updateReservationButton.setLayoutY(640);
			root.getChildren().add(updateReservationButton);
			updateReservationButton.setOnAction(updateReservationEventHandler);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		launch(args);
		
	}

	
}
