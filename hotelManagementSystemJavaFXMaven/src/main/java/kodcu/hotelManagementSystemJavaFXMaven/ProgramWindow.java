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
	protected static TableView<Reservation> tableView=new TableView<Reservation>();
	protected static ComboBox cb=new ComboBox<Long>();
	protected static List<Reservation> reservations=null;
	protected static long roomNo;
	@Override
	public void start(Stage primaryStage) throws InterruptedException {
		try {
			
			
			Group root = new Group();
			Scene scene = new Scene(root,1200,700);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
			Dao dao=new Dao();
			dao.createDatabase(Dao.getPrefSchema());
			dao.clearDefaultDBInformationTable();
			dao.createDefaultDBInformationTable();
			dao.insertIntoDefaultDBInformationTable
			("Sqlite", "", "", "myschema", "", "");
			dao.insertIntoDefaultDBInformationTable
			("MySql", "localhost","3306", "myschema","root", "");
			dao.insertIntoDefaultDBInformationTable
			("MariaDB", "localhost","3306", "myschema","root", "");
			dao.insertIntoDefaultDBInformationTable
			("PostgreSql", "localhost","5432", "myschema","postgres", "");
			
			dao.CreateRoomTable();
			dao.createReservationTable();
			
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
			
			Label labelA=new Label("Total Paid");
			labelA.setPrefSize(100, 20);
			labelA.setLayoutX(0);
			labelA.setLayoutY(20);
			pane3.getChildren().add(labelA);
			
			TextField textFieldA=new TextField();
			textFieldA.setPrefSize(100,20);
			textFieldA.setLayoutX(0);
			textFieldA.setLayoutY(40);
			textFieldA.setEditable(false);
			textFieldA.setText("");
			pane3.getChildren().add(textFieldA);
			
			Label labelB=new Label("Total Unpaid");
			labelB.setPrefSize(100, 20);
			labelB.setLayoutX(120);
			labelB.setLayoutY(20);
			pane3.getChildren().add(labelB);
			
			TextField textFieldB=new TextField();
			textFieldB.setPrefSize(100,20);
			textFieldB.setLayoutX(120);
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
					Scene sceneOpenAddingRoomWindow=new Scene(rootOpenAddingRoomWindow,400,400);
					Stage stageOpenAddingRoomWindow=new Stage();
					stageOpenAddingRoomWindow.setScene(sceneOpenAddingRoomWindow);
					stageOpenAddingRoomWindow.getIcons().add(
							new Image(AddingRoomWindow.class
							.getResourceAsStream("hotelLogo.png")));
					stageOpenAddingRoomWindow.setTitle("Room Adding Page");
					//stageOpenAidatPayerAddingWindow.show();
					AddingRoomWindow openAddingRoomWindow=new AddingRoomWindow();
					try {
						openAddingRoomWindow.start(stageOpenAddingRoomWindow);
						primaryStage.hide();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
			};
			
			Button openAddingRoomWindowButton=new Button("Add Room");
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
					Scene sceneOpenAddingReservationWindow=new Scene(rootOpenAddingReservationWindow,400,720);
					Stage stageOpenAddingReservationWindow=new Stage();
					stageOpenAddingReservationWindow.setScene(sceneOpenAddingReservationWindow);
					stageOpenAddingReservationWindow.getIcons().add(
							new Image(AddingReservationWindow.class
							.getResourceAsStream("hotelLogo.png")));
					stageOpenAddingReservationWindow.setTitle("Rezervation Query Page");
					//stageOpenAidatPayerAddingWindow.show();
					AddingReservationWindow openAddingReservationWindow=new AddingReservationWindow();
					try {
						openAddingReservationWindow.start(stageOpenAddingReservationWindow);
						primaryStage.hide();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
			};
			
			Button openAddingReservationWindowButton=new Button("Add Reservation");
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
					Scene sceneOpenRoomDeletingWindow=new Scene(rootOpenRoomDeletingWindow,400,400);
					Stage stageOpenRoomDeletingWindow=new Stage();
					stageOpenRoomDeletingWindow.setScene(sceneOpenRoomDeletingWindow);
					stageOpenRoomDeletingWindow.getIcons().add(
							new Image(RoomDeletingWindow.class
							.getResourceAsStream("hotelLogo.png")));
					stageOpenRoomDeletingWindow.setTitle("Room Deletion Page");
					//stageOpenAidatPayerAddingWindow.show();
					RoomDeletingWindow openRoomDeletingWindow=new RoomDeletingWindow();
					try {
						openRoomDeletingWindow.start(stageOpenRoomDeletingWindow);
						primaryStage.hide();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
			};
			
			Button openRoomDeletingWindowButton=new Button("Delete Room");
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
					}
					return;
					
					
					
				}
				
			};
			
			Button clearDatabaseButton=new Button("Clear Database");
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
						totalPaid=dao.getTotalOfPaidReservations();
						totalUnpaid=dao.getTotalOfUnpaidReservations();
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					tableView.getItems().addAll(reservations);
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
			
			tableView=new TableView<Reservation>();
			tableView.setPrefSize(1140, 520);
			tableView.setLayoutX(20);
			tableView.setLayoutY(60);
			root.getChildren().add(tableView);
			
			TableColumn<Reservation, Long> col1=new TableColumn<Reservation, Long>("Reservation No");
			TableColumn<Reservation, String> col2=new TableColumn<Reservation, String>("Reservation Start Date");
			TableColumn<Reservation, String> col3=new TableColumn<Reservation, String>("Reservation End Date");
			TableColumn<Reservation, Long> col4=new TableColumn<Reservation, Long>("Room No");
			TableColumn<Reservation, Long> col5=new TableColumn<Reservation, Long>("Days To Stay");
			TableColumn<Reservation, Long> col6=new TableColumn<Reservation, Long>("Price Per Day");
			TableColumn<Reservation, Long> col7=new TableColumn<Reservation, Long>("Total Price");
			TableColumn<Reservation, String> col8=new TableColumn<Reservation, String>("Paid or Unpaid");
			TableColumn<Reservation, Long> col9=new TableColumn<Reservation, Long>("Client Name and Surname");
			TableColumn<Reservation, Long> col10=new TableColumn<Reservation, Long>("Client Phone Number");
			TableColumn<Reservation, Long> col11=new TableColumn<Reservation, Long>("Client Address");
			
			col1.setCellValueFactory(new PropertyValueFactory<Reservation, Long>("reservationNo"));
			col2.setCellValueFactory(new PropertyValueFactory<Reservation, String>("reservationStartDate"));
			col3.setCellValueFactory(new PropertyValueFactory<Reservation, String>("reservationEndDate"));
			col4.setCellValueFactory(new PropertyValueFactory<Reservation, Long>("roomNo"));
			col5.setCellValueFactory(new PropertyValueFactory<Reservation, Long>("daysToStay"));
			col6.setCellValueFactory(new PropertyValueFactory<Reservation, Long>("pricePerDay"));
			col7.setCellValueFactory(new PropertyValueFactory<Reservation, Long>("totalPrice"));
			col8.setCellValueFactory(new PropertyValueFactory<Reservation, String>("paidOrUnpaid"));
			col9.setCellValueFactory(new PropertyValueFactory<Reservation, Long>("clientNameAndSurname"));
			col10.setCellValueFactory(new PropertyValueFactory<Reservation, Long>("clientCellPhone"));
			col11.setCellValueFactory(new PropertyValueFactory<Reservation, Long>("clientAddress"));
			
			
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
			col11.setMinWidth(110);
			
			
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
			EventHandler<ActionEvent> deleteReservationEventHandler=new EventHandler<ActionEvent>() 
			{

				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
						Reservation reservation=tableView.getSelectionModel().getSelectedItem();
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
						tableView.getItems().addAll(reservations);
					
					
				}
				
			};
			
			Button deleteReservationButton=new Button("Delete Selected Reservation");
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
						Scene sceneOpenUpdateReservationWindow=new Scene(rootOpenUpdateReservationWindow,400,720);
						Stage stageOpenUpdateReservationWindow=new Stage();
						stageOpenUpdateReservationWindow.setScene(sceneOpenUpdateReservationWindow);
						stageOpenUpdateReservationWindow.getIcons().add(
								new Image(ReservationUpdatingWindow.class
								.getResourceAsStream("hotelLogo.png")));
						stageOpenUpdateReservationWindow.setTitle("Reservation Updating Page");
						//stageOpenAidatPayerAddingWindow.show();
						ReservationUpdatingWindow openUpdateReservationWindow=new ReservationUpdatingWindow();
						try {
							openUpdateReservationWindow.start(stageOpenUpdateReservationWindow);
							primaryStage.hide();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					
				}
				
			};
			
			Button updateReservationButton=new Button("Update Selected Reservation");
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
