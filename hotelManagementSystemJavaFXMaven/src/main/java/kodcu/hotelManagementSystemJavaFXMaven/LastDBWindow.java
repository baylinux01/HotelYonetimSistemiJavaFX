package kodcu.hotelManagementSystemJavaFXMaven;

import java.sql.SQLException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class LastDBWindow extends Application {
	static ComboBox<String> comboBox=new ComboBox<String>();
	static DefaultDBInformation ddbi;
	static PrefDBInformation pdbi;
	static TextField textField=new TextField();
	static TextField textField2=new TextField();
	static TextField textField3=new TextField();
	static TextField textField4=new TextField();
	static TextField textField5=new TextField();
	static PasswordField passwordField=new PasswordField();
	protected static String language;
	protected static ComboBox<String> cblanguage;
	protected static Label label0,label,label2,label3,label4,label5;
	protected static Button button,button2;
	@Override
	public void start(Stage primaryStage) throws InterruptedException {
		try {
			
			
			Group root = new Group();
			Scene scene = new Scene(root,1200,700);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			Dao dao=new Dao();
			pdbi=dao.getPrefDBInformation();
			//language=Main.language;
			EventHandler<ActionEvent> changeLanguageEventHandler=new EventHandler<ActionEvent>() 
			{

				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					language=cblanguage.getValue();
					if(language.equals("English"))
					{
						label0.setText("Last Database Configurations");
						label3.setText("Schema");
						label3.setPrefSize(300, 20);
						label3.setLayoutX(20);
						label3.setLayoutY(159);
						label3.setStyle("-fx-font-size:20px;");
						label4.setText("Username");
						label4.setPrefSize(300, 20);
						label4.setLayoutX(0);
						label4.setLayoutY(199);
						label4.setStyle("-fx-font-size:20px;");
						label5.setText("Password");
						label5.setPrefSize(300, 20);
						label5.setLayoutX(0);
						label5.setLayoutY(239);
						label5.setStyle("-fx-font-size:20px;");
						button.setText("Continue");
						button2.setText("Go Back");
						
					}
					else if(language.equals("Türkçe"))
					{
						label0.setText("Son veritabanı ayarları");
						label3.setText("Şema");
						label3.setPrefSize(300, 20);
						label3.setLayoutX(40);
						label3.setLayoutY(159);
						label3.setStyle("-fx-font-size:20px;");
						label4.setText("Kullanıcı Adı");
						label4.setPrefSize(300, 20);
						label4.setLayoutX(0);
						label4.setLayoutY(204);
						label4.setStyle("-fx-font-size:16px;");
						label5.setText("Şifre");
						label5.setPrefSize(300, 20);
						label5.setLayoutX(45);
						label5.setLayoutY(239);
						label5.setStyle("-fx-font-size:20px;");
						button.setText("Devam edin");
						button2.setText("Geri Dön");
						
					}
					
					
					
					
				}
				
			};
			cblanguage=new ComboBox<String>();
			cblanguage.setPrefSize(200, 20);
			cblanguage.setLayoutX(700);
			cblanguage.setLayoutY(30);
			cblanguage.getItems().addAll("English","Türkçe");
			if(language.equals("English"))
			cblanguage.getSelectionModel().select(0);
			if(language.equals("Türkçe"))
				cblanguage.getSelectionModel().select(1);
			cblanguage.setOnAction(changeLanguageEventHandler);
			root.getChildren().add(cblanguage);
			
			Pane pane=new Pane();
			pane.setPrefSize(700, 700);
			pane.setLayoutX(400);
			pane.setLayoutY(200);
			root.getChildren().add(pane);
			
			label0=new Label("Last Database Configurations");
			if(language.equals("English"))
				label0.setText("Last Database Configurations");
			if(language.equals("Türkçe"))
				label0.setText("Son veritabanı ayarları");
			label0.setPrefSize(300, 20);
			label0.setLayoutX(100);
			label0.setLayoutY(0);
			label0.setStyle("-fx-font-size:20px;");
			label0.setAlignment(Pos.CENTER_LEFT);
			pane.getChildren().add(label0);
			
			
			EventHandler<ActionEvent> comboBoxChangeEventHandler=new EventHandler<ActionEvent>() 
			{

				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					try {
						 ddbi=dao.getDefaultDBInformation(comboBox.getValue().toString());
						 textField.setText(ddbi.getHost());
						 textField2.setText(ddbi.getPort());
						 textField3.setText(ddbi.getSchema());
						 textField4.setText(ddbi.getUsername());
						 passwordField.setText(ddbi.getPassword());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					
				}
				
			};
			
			
			comboBox.setPrefSize(280, 20);
			//comboBox.setEditable(false);
			//comboBox.setDisable(true);
			comboBox.setLayoutX(100);
			comboBox.setLayoutY(40);
			comboBox.getItems().clear();
			comboBox.getItems().addAll("Sqlite","MySql","MariaDB","PostgreSql");
			comboBox.setValue(String.valueOf(pdbi.getPrefDatabase()));
			pane.getChildren().add(comboBox);
			comboBox.setOnAction(comboBoxChangeEventHandler);
			
			label=new Label("Host");
			label.setPrefSize(300, 20);
			label.setLayoutX(50);
			label.setLayoutY(79);
			label.setStyle("-fx-font-size:20px;");
			pane.getChildren().add(label);
			
			
			textField.setPrefSize(280, 20);
			textField.setText(pdbi.getPrefHost());
			textField.setEditable(false);
			textField.setLayoutX(100);
			textField.setLayoutY(80);
			pane.getChildren().add(textField);
			
			label2=new Label("Port");
			label2.setPrefSize(300, 20);
			label2.setLayoutX(50);
			label2.setLayoutY(119);
			label2.setStyle("-fx-font-size:20px;");
			pane.getChildren().add(label2);
			
			textField2.setPrefSize(280, 20);
			textField2.setText(pdbi.getPrefPort());
			textField2.setEditable(false);
			textField2.setLayoutX(100);
			textField2.setLayoutY(120);
			pane.getChildren().add(textField2);
			
			label3=new Label("Schema");
			if(language.equals("English"))
			{
				label3.setText("Schema");
				label3.setPrefSize(300, 20);
				label3.setLayoutX(20);
				label3.setLayoutY(159);
				label3.setStyle("-fx-font-size:20px;");
			}
			if(language.equals("Türkçe"))
			{
				label3.setText("Şema");
				label3.setPrefSize(300, 20);
				label3.setLayoutX(40);
				label3.setLayoutY(159);
				label3.setStyle("-fx-font-size:20px;");
			}
			
			pane.getChildren().add(label3);
			
			textField3.setPrefSize(280, 20);
			textField3.setText(pdbi.getPrefSchema());
			textField3.setEditable(false);
			textField3.setLayoutX(100);
			textField3.setLayoutY(160);
			pane.getChildren().add(textField3);
			
			label4=new Label("Username");
			if(language.equals("English"))
			{
			label4.setText("Username");
			label4.setPrefSize(300, 20);
			label4.setLayoutX(0);
			label4.setLayoutY(199);
			label4.setStyle("-fx-font-size:20px;");
			}
			if(language.equals("Türkçe"))
			{
			label4.setText("Kullanıcı Adı");
			label4.setPrefSize(300, 20);
			label4.setLayoutX(0);
			label4.setLayoutY(204);
			label4.setStyle("-fx-font-size:16px;");
			}
			
			pane.getChildren().add(label4);
			
			textField4.setPrefSize(280, 20);
			textField4.setText(pdbi.getPrefUsername());
			textField4.setEditable(false);
			textField4.setLayoutX(100);
			textField4.setLayoutY(200);
			pane.getChildren().add(textField4);
			
			label5=new Label("Password");
			if(language.equals("English"))
			{
				label5.setText("Password");
				label5.setPrefSize(300, 20);
				label5.setLayoutX(0);
				label5.setLayoutY(239);
				label5.setStyle("-fx-font-size:20px;");
			}
			if(language.equals("Türkçe"))
			{
				label5.setText("Şifre");
				label5.setPrefSize(300, 20);
				label5.setLayoutX(45);
				label5.setLayoutY(239);
				label5.setStyle("-fx-font-size:20px;");
			}
			
			pane.getChildren().add(label5);
			
			passwordField.setPrefSize(280, 20);
			passwordField.setText("");
//			passwordField.setText(pdbi.getPrefPassword());
//			passwordField.setEditable(false);
			passwordField.setLayoutX(100);
			passwordField.setLayoutY(240);
			pane.getChildren().add(passwordField);
			
			EventHandler<ActionEvent> startProgramEventHandler=new EventHandler<ActionEvent>() 
			{

				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					if(comboBox.getValue().toString().equals("Sqlite"))
					{
						Dao.setSqliteDBClassName("org.sqlite.JDBC");
						Dao.setSqliteDBEmptyUrl("jdbc:sqlite");
						Dao.setSqliteDBUrl("jdbc:sqlite:"+textField3.getText()+".sqlite");
						Dao.setClassName(Dao.getSqliteDBClassName());
						Dao.setUrl(Dao.getSqliteDBUrl());
						Dao.setEmptyUrl(Dao.getSqliteDBEmptyUrl());
						Dao.setHost(textField.getText());
						Dao.setPort(textField2.getText());
						Dao.setPrefSchema(textField3.getText());
						Dao.setUname(textField4.getText());
						Dao.setPass(passwordField.getText());
					}
					else if(comboBox.getValue().toString().equals("MySql"))
					{
						Dao.setMySqlClassName("com.mysql.cj.jdbc.Driver");
						Dao.setMySqlEmptyUrl("jdbc:mysql://"+textField.getText()+
								":"+textField2.getText()+"/");
						Dao.setMySqlUrl("jdbc:mysql://"+textField.getText()+
								":"+textField2.getText()+"/"+textField3.getText());
						Dao.setClassName(Dao.getMySqlClassName());
						Dao.setUrl(Dao.getMySqlUrl());
						Dao.setEmptyUrl(Dao.getMySqlEmptyUrl());
						Dao.setHost(textField.getText());
						Dao.setPort(textField2.getText());
						Dao.setPrefSchema(textField3.getText());
						Dao.setUname(textField4.getText());
						Dao.setPass(passwordField.getText());
					}
					else if(comboBox.getValue().toString().equals("MariaDB"))
					{
						Dao.setMariaDBClassName("org.mariadb.jdbc.Driver");
						Dao.setMariaDBEmptyUrl("jdbc:mariadb://"+textField.getText()+
								":"+textField2.getText()+"/");
						Dao.setMariaDBUrl("jdbc:mariadb://"+textField.getText()+
								":"+textField2.getText()+"/"+textField3.getText());
						Dao.setClassName(Dao.getMariaDBClassName());
						Dao.setUrl(Dao.getMariaDBUrl());
						Dao.setEmptyUrl(Dao.getMariaDBEmptyUrl());
						Dao.setHost(textField.getText());
						Dao.setPort(textField2.getText());
						Dao.setPrefSchema(textField3.getText());
						Dao.setUname(textField4.getText());
						Dao.setPass(passwordField.getText());
					}
					else if(comboBox.getValue().toString().equals("PostgreSql"))
					{
						Dao.setPostgreClassName("org.postgresql.Driver");
						Dao.setPostgreEmptyUrl("jdbc:postgresql://"+textField.getText()+
								":"+textField2.getText()+"/");
						Dao.setPostgreUrl("jdbc:postgresql://"+textField.getText()+
								":"+textField2.getText()+
								"/postgres?currentSchema="+textField3.getText());
						Dao.setClassName(Dao.getPostgreClassName());
						Dao.setUrl(Dao.getPostgreUrl());
						Dao.setEmptyUrl(Dao.getPostgreEmptyUrl());
						Dao.setHost(textField.getText());
						Dao.setPort(textField2.getText());
						Dao.setPrefSchema(textField3.getText());
						Dao.setUname(textField4.getText());
						Dao.setPass(passwordField.getText());
					}
					try {
						if(dao.getEmptyCon()!=null)
						{
							String Host="localhost";
							String Port="";
							String PrefSchema="myschema";
							Dao.setSqliteDBClassName("org.sqlite.JDBC");
							Dao.setSqliteDBEmptyUrl("jdbc:sqlite");
							Dao.setSqliteDBUrl("jdbc:sqlite:"+PrefSchema+".sqlite");
							Dao.setClassName(Dao.getSqliteDBClassName());
							Dao.setUrl(Dao.getSqliteDBUrl());
							Dao.setEmptyUrl(Dao.getSqliteDBEmptyUrl());
							Dao.setHost("localhost");
							Dao.setPort("");
							Dao.setPrefSchema("myschema");
							Dao.setUname("root");
							Dao.setPass("myPass");
							Dao.setMySqlEmptyUrl("jdbc:mysql://"+Host+":"+Port+"/");
							Dao.setMySqlUrl("jdbc:mysql://"+Host+":"+Port+"/"+PrefSchema);
							Dao.setMariaDBEmptyUrl("jdbc:mariadb://"+Host+":"+Port+"/");
							Dao.setMariaDBUrl("jdbc:mariadb://"+Host+":"+Port+"/"+PrefSchema);
							Dao.setPostgreEmptyUrl("jdbc:postgresql://"+Host+":"+Port+"/");
							Dao.setPostgreUrl("jdbc:postgresql://"+Host+":"+Port+"/postgres?currentSchema="+PrefSchema);
							try {
								dao.createPrefDBInformationTable();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							try {
								dao.insertIntoPrefDBInformationTable
								("Sqlite", "", "", "myschema", "", "");
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							if(comboBox.getValue()!=null)
							{
							try {
								dao.updatePrefDBInformationTable
								(comboBox.getValue().toString(), textField.getText(),
										textField2.getText(), textField3.getText(), 
										textField4.getText(), "");
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							if(comboBox.getValue().toString().equals("Sqlite"))
							{
								Dao.setSqliteDBClassName("org.sqlite.JDBC");
								Dao.setSqliteDBEmptyUrl("jdbc:sqlite");
								Dao.setSqliteDBUrl("jdbc:sqlite:"+textField3.getText()+".sqlite");
								Dao.setClassName(Dao.getSqliteDBClassName());
								Dao.setUrl(Dao.getSqliteDBUrl());
								Dao.setEmptyUrl(Dao.getSqliteDBEmptyUrl());
								Dao.setHost(textField.getText());
								Dao.setPort(textField2.getText());
								Dao.setPrefSchema(textField3.getText());
								Dao.setUname(textField4.getText());
								Dao.setPass(passwordField.getText());
							}
							else if(comboBox.getValue().toString().equals("MySql"))
							{
								Dao.setMySqlClassName("com.mysql.cj.jdbc.Driver");
								Dao.setMySqlEmptyUrl("jdbc:mysql://"+textField.getText()+
										":"+textField2.getText()+"/");
								Dao.setMySqlUrl("jdbc:mysql://"+textField.getText()+
										":"+textField2.getText()+"/"+textField3.getText());
								Dao.setClassName(Dao.getMySqlClassName());
								Dao.setUrl(Dao.getMySqlUrl());
								Dao.setEmptyUrl(Dao.getMySqlEmptyUrl());
								Dao.setHost(textField.getText());
								Dao.setPort(textField2.getText());
								Dao.setPrefSchema(textField3.getText());
								Dao.setUname(textField4.getText());
								Dao.setPass(passwordField.getText());
							}
							else if(comboBox.getValue().toString().equals("MariaDB"))
							{
								Dao.setMariaDBClassName("org.mariadb.jdbc.Driver");
								Dao.setMariaDBEmptyUrl("jdbc:mariadb://"+textField.getText()+
										":"+textField2.getText()+"/");
								Dao.setMariaDBUrl("jdbc:mariadb://"+textField.getText()+
										":"+textField2.getText()+"/"+textField3.getText());
								Dao.setClassName(Dao.getMariaDBClassName());
								Dao.setUrl(Dao.getMariaDBUrl());
								Dao.setEmptyUrl(Dao.getMariaDBEmptyUrl());
								Dao.setHost(textField.getText());
								Dao.setPort(textField2.getText());
								Dao.setPrefSchema(textField3.getText());
								Dao.setUname(textField4.getText());
								Dao.setPass(passwordField.getText());
							}
							else if(comboBox.getValue().toString().equals("PostgreSql"))
							{
								Dao.setPostgreClassName("org.postgresql.Driver");
								Dao.setPostgreEmptyUrl("jdbc:postgresql://"+textField.getText()+
										":"+textField2.getText()+"/");
								Dao.setPostgreUrl("jdbc:postgresql://"+textField.getText()+
										":"+textField2.getText()+
										"/postgres?currentSchema="+textField3.getText());
								Dao.setClassName(Dao.getPostgreClassName());
								Dao.setUrl(Dao.getPostgreUrl());
								Dao.setEmptyUrl(Dao.getPostgreEmptyUrl());
								Dao.setHost(textField.getText());
								Dao.setPort(textField2.getText());
								Dao.setPrefSchema(textField3.getText());
								Dao.setUname(textField4.getText());
								Dao.setPass(passwordField.getText());
							}
						Group rootProgramWindow=new Group();
						Scene sceneProgramWindow=new Scene(rootProgramWindow,1300,700);
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
						else
						{
							String Host2="localhost";
							String Port2="";
							String PrefSchema2="myschema";
							Dao.setSqliteDBClassName("org.sqlite.JDBC");
							Dao.setSqliteDBEmptyUrl("jdbc:sqlite");
							Dao.setSqliteDBUrl("jdbc:sqlite:"+PrefSchema2+".sqlite");
							Dao.setClassName(Dao.getSqliteDBClassName());
							Dao.setUrl(Dao.getSqliteDBUrl());
							Dao.setEmptyUrl(Dao.getSqliteDBEmptyUrl());
							Dao.setHost("localhost");
							Dao.setPort("");
							Dao.setPrefSchema("myschema");
							Dao.setUname("root");
							Dao.setPass("myPass");
							Dao.setMySqlEmptyUrl("jdbc:mysql://"+Host2+":"+Port2+"/");
							Dao.setMySqlUrl("jdbc:mysql://"+Host2+":"+Port2+"/"+PrefSchema2);
							Dao.setMariaDBEmptyUrl("jdbc:mariadb://"+Host2+":"+Port2+"/");
							Dao.setMariaDBUrl("jdbc:mariadb://"+Host2+":"+Port2+"/"+PrefSchema2);
							Dao.setPostgreEmptyUrl("jdbc:postgresql://"+Host2+":"+Port2+"/");
							Dao.setPostgreUrl("jdbc:postgresql://"+Host2+":"+Port2+"/postgres?currentSchema="+PrefSchema2);
						}}
					}catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						String Host="localhost";
						String Port="";
						String PrefSchema="myschema";
						Dao.setSqliteDBClassName("org.sqlite.JDBC");
						Dao.setSqliteDBEmptyUrl("jdbc:sqlite");
						Dao.setSqliteDBUrl("jdbc:sqlite:"+PrefSchema+".sqlite");
						Dao.setClassName(Dao.getSqliteDBClassName());
						Dao.setUrl(Dao.getSqliteDBUrl());
						Dao.setEmptyUrl(Dao.getSqliteDBEmptyUrl());
						Dao.setHost("localhost");
						Dao.setPort("");
						Dao.setPrefSchema("myschema");
						Dao.setUname("root");
						Dao.setPass("myPass");
						Dao.setMySqlEmptyUrl("jdbc:mysql://"+Host+":"+Port+"/");
						Dao.setMySqlUrl("jdbc:mysql://"+Host+":"+Port+"/"+PrefSchema);
						Dao.setMariaDBEmptyUrl("jdbc:mariadb://"+Host+":"+Port+"/");
						Dao.setMariaDBUrl("jdbc:mariadb://"+Host+":"+Port+"/"+PrefSchema);
						Dao.setPostgreEmptyUrl("jdbc:postgresql://"+Host+":"+Port+"/");
						Dao.setPostgreUrl("jdbc:postgresql://"+Host+":"+Port+"/postgres?currentSchema="+PrefSchema);
					}
					
					
				}
				
			};
			
			button=new Button("Continue");
			if(language.equals("English"))
				button.setText("Continue");
			if(language.equals("Türkçe"))
				button.setText("Devam Edin");
			button.setPrefSize(280, 20);
			button.setLayoutX(100);
			button.setLayoutY(280);
			pane.getChildren().add(button);
			button.setOnAction(startProgramEventHandler);
			root.setOnKeyReleased(event->{
				if(event.getCode().equals(KeyCode.ENTER))
				{
					button.fire();
				}
			});
			
			EventHandler<ActionEvent> goBackEventHandler=new EventHandler<ActionEvent>() 
			{

				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
				
					Group root=new Group();
					Scene scene=new Scene(root,1200,700);
					Stage stage=new Stage();
					stage.setScene(scene);
//					stageOpenDBChoosingWindow.getIcons().add(
//							new Image(DBChoosingWindow.class
//							.getResourceAsStream("aidatTakipLogo.jpg")));
					
					//stageOpenAidatPayerAddingWindow.show();
					Main main=new Main();
					try {
						main.language=language;
						main.start(stage);
						
						primaryStage.hide();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}
				
			};
			
			button2=new Button("Go Back");
			if(language.equals("English"))
				button2.setText("Go Back");
			if(language.equals("Türkçe"))
				button2.setText("Geri Dön");
			button2.setPrefSize(280, 20);
			button2.setLayoutX(100);
			button2.setLayoutY(320);
			pane.getChildren().add(button2);
			button2.setOnAction(goBackEventHandler);
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		launch(args);
		
	}

	
}
