package kodcu.hotelManagementSystemJavaFXMaven;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Main extends Application {
	protected static String language;
	
	

	protected static ComboBox<String> cblanguage;
	protected static Label label;
	protected static Button button,button2,button3;
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
			dao.createDatabase("myschema");
			dao.createDefaultDBInformationTable();
			dao.clearDefaultDBInformationTable();
			dao.insertIntoDefaultDBInformationTable
			("Sqlite", "", "", "myschema", "", "");
			dao.insertIntoDefaultDBInformationTable
			("MySql", "localhost","3306", "myschema","root", "");
			dao.insertIntoDefaultDBInformationTable
			("MariaDB", "localhost","3306", "myschema","root", "");
			dao.insertIntoDefaultDBInformationTable
			("PostgreSql", "localhost","5432", "myschema","postgres", "");
			EventHandler<ActionEvent> changeLanguageEventHandler=new EventHandler<ActionEvent>() 
			{

				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					language=cblanguage.getValue();
					if(language.equals("English"))
					{
						label.setText("Decide Which Database You Want To Use");
						button.setText("Continue using the last configuration");
						button2.setText("Continue using Sqlite As Schema Name = \"myschema\"");
						button3.setText("Continue using Another DB and/or another Schema");
					}
					else if(language.equals("Türkçe"))
					{
						label.setText("Hangi veritabanını kullanmak istediğinize karar verin");
						button.setText("Son ayarlar ile devam edin");
						button2.setText("Şema adı = \"myschema\" olacak şekilde Sqlite kullanarak devam edin");
						button3.setText("Başka bir veritabanı veya şema kullanarak devam edin");
					}
					
					
					
					
				}
				
			};
			cblanguage=new ComboBox<String>();
			cblanguage.setPrefSize(200, 20);
			cblanguage.setLayoutX(700);
			cblanguage.setLayoutY(30);
			cblanguage.getItems().addAll("English","Türkçe");
			if(language==null || language.length()==0) language="English";
			if(language!=null && language.equals("Türkçe"))
			{
			cblanguage.getSelectionModel().select(1);
			}
			else
			{
			cblanguage.getSelectionModel().select(0);
			}
			cblanguage.setOnAction(changeLanguageEventHandler);
			root.getChildren().add(cblanguage);
			
			Pane pane=new Pane();
			pane.setPrefSize(700, 700);
			pane.setLayoutX(400);
			pane.setLayoutY(200);
			root.getChildren().add(pane);
			
			label=new Label("Decide Which Database You Want To Use");
			label.setPrefSize(500, 20);
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
						openLastDBWindow.language=language;
						openLastDBWindow.start(stageOpenLastDBWindow);
						primaryStage.hide();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
			};
			
			button=new Button("Continue using the last configuration");
			button.setPrefSize(500, 20);
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
			
			button2=new Button("Continue using Sqlite As Schema Name = \"myschema\"");
			button2.setPrefSize(500, 20);
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
						openDBConfigurationWindow.language=language;
						openDBConfigurationWindow.start(stageOpenDBConfigurationWindow);
						primaryStage.hide();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
			};
			
			button3=new Button("Continue using Another DB and/or another Schema");
			button3.setPrefSize(500, 20);
			button3.setLayoutX(0);
			button3.setLayoutY(120);
			button3.setOnAction(continueUsingAnotherDBEventHandler);
			pane.getChildren().add(button3);
			
			if(language!=null && language.equals("English"))
			{
				label.setText("Decide Which Database You Want To Use");
				button.setText("Continue using the last configuration");
				button2.setText("Continue using Sqlite As Schema Name = \"myschema\"");
				button3.setText("Continue using Another DB and/or another Schema");
			}
			else if(language!=null && language.equals("Türkçe"))
			{
				label.setText("Hangi veritabanını kullanmak istediğinize karar verin");
				button.setText("Son ayarlar ile devam edin");
				button2.setText("Şema adı = \"myschema\" olacak şekilde Sqlite kullanarak devam edin");
				button3.setText("Başka bir veritabanı veya şema kullanarak devam edin");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		launch(args);
		
	}

	
}
