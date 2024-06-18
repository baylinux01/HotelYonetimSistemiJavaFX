package kodcu.hotelManagementSystemJavaFXMaven;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) throws InterruptedException {
		try {
			
			
			Group root = new Group();
			Scene scene = new Scene(root,1200,700);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.getIcons().add(
					new Image(Main.class
					.getResourceAsStream("hotelLogo.png")));
			primaryStage.show();
			
			Dao dao=new Dao();
			dao.createDatabase("hotelmanagement");
			dao.createDefaultDBInformationTable();
			dao.clearDefaultDBInformationTable();
			dao.insertIntoDefaultDBInformationTable
			("Sqlite", "", "", "hotelmanagement", "", "");
			dao.insertIntoDefaultDBInformationTable
			("MySql", "localhost","3306", "hotelmanagement","root", "");
			dao.insertIntoDefaultDBInformationTable
			("MariaDB", "localhost","3306", "hotelmanagement","root", "");
			dao.insertIntoDefaultDBInformationTable
			("PostgreSql", "localhost","5432", "hotelmanagement","postgres", "");
			
			Pane pane=new Pane();
			pane.setPrefSize(700, 700);
			pane.setLayoutX(500);
			pane.setLayoutY(200);
			root.getChildren().add(pane);
			
			Label label=new Label("Choose Database");
			label.setPrefSize(300, 20);
			label.setLayoutX(0);
			label.setLayoutY(0);
			label.setStyle("-fx-font-size:20px;");
			label.setAlignment(Pos.CENTER_LEFT);
			pane.getChildren().add(label);
			
			EventHandler<ActionEvent> continueUsingMyLastConfigurationEventHandler=new EventHandler<ActionEvent>() 
			{

				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub

					Group rootOpenLastDBWindow=new Group();
					Scene sceneOpenLastDBWindow=new Scene(rootOpenLastDBWindow,1200,700);
					Stage stageOpenLastDBWindow=new Stage();
					stageOpenLastDBWindow.setScene(sceneOpenLastDBWindow);
					stageOpenLastDBWindow.getIcons().add(
							new Image(LastDBWindow.class
							.getResourceAsStream("hotelLogo.png")));
					stageOpenLastDBWindow.setTitle("DB Selection Page");
					//stageOpenAidatPayerAddingWindow.show();
					LastDBWindow openLastDBWindow=new LastDBWindow();
					try {
						openLastDBWindow.start(stageOpenLastDBWindow);
						primaryStage.hide();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
			};
			
			Button button=new Button("Continue using my last configuration");
			button.setPrefSize(250, 20);
			button.setLayoutX(0);
			button.setLayoutY(40);
			button.setOnAction(continueUsingMyLastConfigurationEventHandler);
			pane.getChildren().add(button);
			
			EventHandler<ActionEvent> continueUsingSqliteEventHandler=new EventHandler<ActionEvent>() 
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
			
			Button button2=new Button("Continue using Sqlite");
			button2.setPrefSize(250, 20);
			button2.setLayoutX(0);
			button2.setLayoutY(80);
			button2.setOnAction(continueUsingSqliteEventHandler);
			pane.getChildren().add(button2);
			
			EventHandler<ActionEvent> continueUsingAnotherDBEventHandler=new EventHandler<ActionEvent>() 
			{

				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					
					Group rootOpenDBConfigurationWindow=new Group();
					Scene sceneOpenDBConfigurationWindow=new Scene(rootOpenDBConfigurationWindow,1200,700);
					Stage stageOpenDBConfigurationWindow=new Stage();
					stageOpenDBConfigurationWindow.setScene(sceneOpenDBConfigurationWindow);
					stageOpenDBConfigurationWindow.getIcons().add(
							new Image(DBConfigurationWindow.class
							.getResourceAsStream("hotelLogo.png")));
					stageOpenDBConfigurationWindow.setTitle("DB Selection Page");
					//stageOpenAidatPayerAddingWindow.show();
					DBConfigurationWindow openDBConfigurationWindow=new DBConfigurationWindow();
					try {
						openDBConfigurationWindow.start(stageOpenDBConfigurationWindow);
						primaryStage.hide();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
			};
			
			Button button3=new Button("Continue using Another DB");
			button3.setPrefSize(250, 20);
			button3.setLayoutX(0);
			button3.setLayoutY(120);
			button3.setOnAction(continueUsingAnotherDBEventHandler);
			pane.getChildren().add(button3);
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		launch(args);
		
	}

	
}
