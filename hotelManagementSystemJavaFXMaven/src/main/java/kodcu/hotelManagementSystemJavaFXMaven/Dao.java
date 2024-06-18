package kodcu.hotelManagementSystemJavaFXMaven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;







public class Dao {
	private static String Host="localhost";
	private static String MySqlPort="3306";
	private static String MariaDBPort="3306";
	private static String PostgreSqlPort="5432";
	private static String Port="";
	private static String PrefSchema="myschema";
	
	private static String MySqlClassName="com.mysql.cj.jdbc.Driver";
	private static String MySqlEmptyUrl="jdbc:mysql://"+Host+":"+Port+"/";
	private static String MySqlUrl="jdbc:mysql://"+Host+":"+Port+"/"+PrefSchema;
	private static String MySqlUname="root";
	private static String MySqlPass= "myPass";
	
	private static String MariaDBClassName="org.mariadb.jdbc.Driver";
	private static String MariaDBEmptyUrl="jdbc:mariadb://"+Host+":"+Port+"/";
	private static String MariaDBUrl="jdbc:mariadb://"+Host+":"+Port+"/"+PrefSchema;
	private static String MariaDBUname="root";
	private static String MariaDBPass= "myPass";
	
	private static String SqliteDBClassName="org.sqlite.JDBC";
	private static String SqliteDBEmptyUrl="jdbc:sqlite";
	private static String SqliteDBUrl="jdbc:sqlite:"+PrefSchema+".sqlite";
	
	private static String PostgreClassName="org.postgresql.Driver";
	private static String PostgreEmptyUrl="jdbc:postgresql://"+Host+":"+Port+"/";
	private static String PostgreUrl=
	"jdbc:postgresql://"+Host+":"+Port+"/postgres?currentSchema="+PrefSchema;
	private static String PostgreUname="postgres";
	private static String PostgrePass="myPass";
	
	private static String className=SqliteDBClassName;
	private static String emptyUrl=SqliteDBEmptyUrl;
	private static String url=SqliteDBUrl;
	private static String uname=MySqlUname;
	private static String pass=MySqlPass;
	//DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	
	private static Connection con=null;
	public static String getHost() {
		return Host;
	}

	public static void setHost(String host) {
		Host = host;
	}

	public static String getMySqlPort() {
		return MySqlPort;
	}

	public static void setMySqlPort(String mySqlPort) {
		MySqlPort = mySqlPort;
	}

	public static String getMariaDBPort() {
		return MariaDBPort;
	}

	public static void setMariaDBPort(String mariaDBPort) {
		MariaDBPort = mariaDBPort;
	}

	public static String getPostgreSqlPort() {
		return PostgreSqlPort;
	}

	public static void setPostgreSqlPort(String postgreSqlPort) {
		PostgreSqlPort = postgreSqlPort;
	}

	public static String getPort() {
		return Port;
	}

	public static void setPort(String port) {
		Port = port;
	}

	public static String getPrefSchema() {
		return PrefSchema;
	}

	public static void setPrefSchema(String prefSchema) {
		PrefSchema = prefSchema;
	}

	public static String getMySqlClassName() {
		return MySqlClassName;
	}

	public static void setMySqlClassName(String mySqlClassName) {
		MySqlClassName = mySqlClassName;
	}

	public static String getMySqlEmptyUrl() {
		return MySqlEmptyUrl;
	}

	public static void setMySqlEmptyUrl(String mySqlEmptyUrl) {
		MySqlEmptyUrl = mySqlEmptyUrl;
	}

	public static String getMySqlUrl() {
		return MySqlUrl;
	}

	public static void setMySqlUrl(String mySqlUrl) {
		MySqlUrl = mySqlUrl;
	}

	public static String getMySqlUname() {
		return MySqlUname;
	}

	public static void setMySqlUname(String mySqlUname) {
		MySqlUname = mySqlUname;
	}

	public static String getMySqlPass() {
		return MySqlPass;
	}

	public static void setMySqlPass(String mySqlPass) {
		MySqlPass = mySqlPass;
	}

	public static String getMariaDBClassName() {
		return MariaDBClassName;
	}

	public static void setMariaDBClassName(String mariaDBClassName) {
		MariaDBClassName = mariaDBClassName;
	}

	public static String getMariaDBEmptyUrl() {
		return MariaDBEmptyUrl;
	}

	public static void setMariaDBEmptyUrl(String mariaDBEmptyUrl) {
		MariaDBEmptyUrl = mariaDBEmptyUrl;
	}

	public static String getMariaDBUrl() {
		return MariaDBUrl;
	}

	public static void setMariaDBUrl(String mariaDBUrl) {
		MariaDBUrl = mariaDBUrl;
	}

	public static String getMariaDBUname() {
		return MariaDBUname;
	}

	public static void setMariaDBUname(String mariaDBUname) {
		MariaDBUname = mariaDBUname;
	}

	public static String getMariaDBPass() {
		return MariaDBPass;
	}

	public static void setMariaDBPass(String mariaDBPass) {
		MariaDBPass = mariaDBPass;
	}

	public static String getSqliteDBClassName() {
		return SqliteDBClassName;
	}

	public static void setSqliteDBClassName(String sqliteDBClassName) {
		SqliteDBClassName = sqliteDBClassName;
	}

	public static String getSqliteDBEmptyUrl() {
		return SqliteDBEmptyUrl;
	}

	public static void setSqliteDBEmptyUrl(String sqliteDBEmptyUrl) {
		SqliteDBEmptyUrl = sqliteDBEmptyUrl;
	}

	public static String getSqliteDBUrl() {
		return SqliteDBUrl;
	}

	public static void setSqliteDBUrl(String sqliteDBUrl) {
		SqliteDBUrl = sqliteDBUrl;
	}

	public static String getPostgreClassName() {
		return PostgreClassName;
	}

	public static void setPostgreClassName(String postgreClassName) {
		PostgreClassName = postgreClassName;
	}

	public static String getPostgreEmptyUrl() {
		return PostgreEmptyUrl;
	}

	public static void setPostgreEmptyUrl(String postgreEmptyUrl) {
		PostgreEmptyUrl = postgreEmptyUrl;
	}

	public static String getPostgreUrl() {
		return PostgreUrl;
	}

	public static void setPostgreUrl(String postgreUrl) {
		PostgreUrl = postgreUrl;
	}

	public static String getPostgreUname() {
		return PostgreUname;
	}

	public static void setPostgreUname(String postgreUname) {
		PostgreUname = postgreUname;
	}

	public static String getPostgrePass() {
		return PostgrePass;
	}

	public static void setPostgrePass(String postgrePass) {
		PostgrePass = postgrePass;
	}

	public static String getClassName() {
		return className;
	}

	public static void setClassName(String className) {
		Dao.className = className;
	}

	public static String getEmptyUrl() {
		return emptyUrl;
	}

	public static void setEmptyUrl(String emptyUrl) {
		Dao.emptyUrl = emptyUrl;
	}

	public static String getUrl() {
		return url;
	}

	public static void setUrl(String url) {
		Dao.url = url;
	}

	public static String getUname() {
		return uname;
	}

	public static void setUname(String uname) {
		Dao.uname = uname;
	}

	public static String getPass() {
		return pass;
	}

	public static void setPass(String pass) {
		Dao.pass = pass;
	}

	public static Connection getCon1() {
		return con1;
	}

	public static void setCon1(Connection con1) {
		Dao.con1 = con1;
	}

	public static void setCon(Connection con) {
		Dao.con = con;
	}
	private static Connection con1=null;
	public static Connection getEmptyCon() throws ClassNotFoundException, SQLException {
		Class.forName(className);
		Connection con;
		if(className.equals(SqliteDBClassName))
		 con= DriverManager.getConnection(url);
		else
			con=DriverManager.getConnection(emptyUrl,uname,pass);
//		Connection con = DriverManager.getConnection(url,uname,pass);
		return con;
	}
	public static Connection getCon() throws ClassNotFoundException, SQLException {
		Class.forName(className);
		Connection con;
		if(className.equals(SqliteDBClassName))
		 con= DriverManager.getConnection(url);
		else
			con=DriverManager.getConnection(url,uname,pass);
//		Connection con = DriverManager.getConnection(url,uname,pass);
		return con;
	}
	
	public void createDatabase(String databasename) throws SQLException, ClassNotFoundException 
	{
		String query1="create database if not exists ?";
				//String query1=" CREATE DATABASE [?]";
		
		try {
			con=getEmptyCon();
//			Connection con1 = DriverManager.getConnection(emptyUrl,uname,pass);
			
			PreparedStatement st1= con.prepareStatement(query1);
			st1.setString(1, databasename);
			st1.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally {
			if(con!=null)
			{
				con.close();
			}
			
				
			
		}
		
	}
	
	public void createDefaultDBInformationTable() throws SQLException
	{

		
		
		String query1="Create table DefaultDBInformationTable" +
                "(" +
				"defaultDB nvarchar(45) primary key,"+
                "defaultHost nvarchar(45),"+
                 "defaultPort nvarchar(45),"+
                 "defaultSchema nvarchar(45),"+
                  "defaultUsername nvarchar(45),"+
                  "defaultPassword nvarchar(45));";
		if(className.equals(MySqlClassName))
		{
			query1="Create table DefaultDBInformationTable" +
	                "(" +
					"defaultDB nvarchar(45) primary key,"+
	                "defaultHost nvarchar(45),"+
	                 "defaultPort nvarchar(45),"+
	                 "defaultSchema nvarchar(45),"+
	                  "defaultUsername nvarchar(45),"+
	                  "defaultPassword nvarchar(45));";
		}
		else if(className.equals(MariaDBClassName))
		{
			query1="Create table DefaultDBInformationTable" +
	                "(" +
					"defaultDB nvarchar(45) primary key,"+
	                "defaultHost nvarchar(45),"+
	                 "defaultPort nvarchar(45),"+
	                 "defaultSchema nvarchar(45),"+
	                  "defaultUsername nvarchar(45),"+
	                  "defaultPassword nvarchar(45));";
		}
		else if(className.equals(SqliteDBClassName))
		{
			query1="Create table DefaultDBInformationTable" +
	                "(" +
					"defaultDB nvarchar(45) primary key,"+
	                "defaultHost nvarchar(45),"+
	                 "defaultPort nvarchar(45),"+
	                 "defaultSchema nvarchar(45),"+
	                  "defaultUsername nvarchar(45),"+
	                  "defaultPassword nvarchar(45));";
		}
		else if(className.equals(PostgreClassName))
		{
			query1="Create table DefaultDBInformationTable" +
	                "(" +
					"defaultDB text primary key,"+
	                "defaultHost text,"+
	                 "defaultPort text,"+
	                 "defaultSchema text,"+
	                  "defaultUsername text,"+
	                  "defaultPassword text);";
		}
		
		
		
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st1= con.prepareStatement(query1);
			
			st1.executeUpdate();
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		finally {
			if(con!=null)
			{
				con.close();
			}
			
				
			
		}
		
	}
	public void createPrefDBInformationTable() throws SQLException
	{

		
		
		String query1="Create table PrefDBInformationTable" +
                "(" +
				"Id long primary key,"+
				"PrefDB nvarchar(45),"+
                "PrefHost nvarchar(45),"+
                 "PrefPort nvarchar(45),"+
                 "PrefSchema nvarchar(45),"
                 + "PrefUsername nvarchar(45),"
                 + "PrefPassword nvarchar(45));";
		
		
		
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st1= con.prepareStatement(query1);
			
			st1.executeUpdate();
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		finally {
			if(con!=null)
			{
				con.close();
			}
			
				
			
		}
		
	}
	public int insertIntoDefaultDBInformationTable(String database, String host, String port, 
			String schema,String username,String password ) throws SQLException
	{
		
		
		String query1="Insert into DefaultDBInformationTable"+
				 " (defaultDB, defaultHost,defaultPort,defaultSchema,defaultUsername,defaultPassword)"+
				 " values (?,?,?,?,?,?)";
		int result=-1;
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st1= con.prepareStatement(query1);
			st1.setString(1, database);
			st1.setString(2, host);
			st1.setString(3, port);
			st1.setString(4, schema);
			st1.setString(5, username);
			st1.setString(6, password);
			result=st1.executeUpdate();
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		finally {
			if(con!=null)
			{
				con.close();
			}
		}
		
		return result;
		
	}
	public int insertIntoPrefDBInformationTable(String prefDatabase, 
			String prefHost, String prefPort, 
			String prefSchema,String prefUsername,String prefPassword ) throws SQLException
	{
		
		
		String query1="Insert into PrefDBInformationTable (Id,PrefDB,PrefHost,PrefPort,"
				+ "PrefSchema,PrefUsername,PrefPassword)"
				+ "values (?,?,?,?,?,?,?)";
		int result=-1;
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st1= con.prepareStatement(query1);
			st1.setLong(1, 1);
			st1.setString(2, prefDatabase);
			st1.setString(3, prefHost);
			st1.setString(4, prefPort);
			st1.setString(5, prefSchema);
			st1.setString(6, prefUsername);
			st1.setString(7, prefPassword);
			result=st1.executeUpdate();
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		finally {
			if(con!=null)
			{
				con.close();
			}
		}
		
		return result;
		
	}
	public int clearPrefDBInformationTable() throws SQLException 
	{
		String query1="Delete From PrefDBInformationTable";
		int result=-1;
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st1= con.prepareStatement(query1);
			result= st1.executeUpdate();
			
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(con!=null)
			{
				con.close();
			}
			
				
			
		}
		
		return result;
		
	}
	public int clearDefaultDBInformationTable() throws SQLException 
	{
		String query1="Delete From DefaultDBInformationTable";
		int result=-1;
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st1= con.prepareStatement(query1);
			result= st1.executeUpdate();
			
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(con!=null)
			{
				con.close();
			}
			
				
			
		}
		
		return result;
		
	}
	public int updatePrefDBInformationTable(String prefDatabase, 
			String prefHost, String prefPort, 
			String prefSchema,String prefUsername,String prefPassword ) throws SQLException
	{
		
		String query1="Update PrefDBInformationTable "
				+ "Set PrefHost=?, PrefPort=?, PrefSchema=?,"
				+ "PrefUsername=?,PrefPassword=?, PrefDB=? where Id=?";
		
		
		int result=-1;
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st1= con.prepareStatement(query1);
			st1.setString(1, prefHost);
			st1.setString(2, prefPort);
			st1.setString(3, prefSchema);
			st1.setString(4, prefUsername);
			st1.setString(5, prefPassword);
			st1.setString(6, prefDatabase);
			st1.setLong(7, 1);
			result=st1.executeUpdate();
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		finally {
			if(con!=null)
			{
				con.close();
			}
		}
		
		return result;
		
	}
	public DefaultDBInformation getDefaultDBInformation(String databaseName) throws SQLException
	{
		String query="Select * From DefaultDBInformationTable where defaultDB=?";
		DefaultDBInformation p=new DefaultDBInformation();
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st= con.prepareStatement(query);
			st.setString(1, databaseName);
			
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				p.setDatabase(rs.getString("defaultDB"));
				p.setHost(rs.getString("defaultHost"));
				p.setPort(rs.getString("defaultPort"));
				p.setSchema(rs.getString("defaultSchema"));
				p.setUsername(rs.getString("defaultUsername"));
				p.setPassword(rs.getString("defaultPassword"));
			
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(con!=null)
			{
				con.close();
			}
			
				
			
		}
		return p;
	}
	public PrefDBInformation getPrefDBInformation(String databaseName) throws SQLException
	{
		String query="Select * From PrefDBInformationTable where DB=?";
		PrefDBInformation p=new PrefDBInformation();
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st= con.prepareStatement(query);
			st.setString(1, databaseName);
			
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				p.setPrefDatabase(rs.getString("PrefDB"));
				p.setPrefHost(rs.getString("PrefHost"));
				p.setPrefPort(rs.getString("PrefPort"));
				p.setPrefSchema(rs.getString("PrefSchema"));
				p.setPrefUsername(rs.getString("PrefUsername"));
				p.setPrefPassword(rs.getString("PrefPassword"));
			
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(con!=null)
			{
				con.close();
			}
			
				
			
		}
		return p;
	}
	public PrefDBInformation getPrefDBInformation() throws SQLException
	{
		String query="Select * From PrefDBInformationTable";
		PrefDBInformation p=new PrefDBInformation();
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st= con.prepareStatement(query);
			
			
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				p.setPrefDatabase(rs.getString("PrefDB"));
				p.setPrefHost(rs.getString("PrefHost"));
				p.setPrefPort(rs.getString("PrefPort"));
				p.setPrefSchema(rs.getString("PrefSchema"));
				p.setPrefUsername(rs.getString("PrefUsername"));
				p.setPrefPassword(rs.getString("PrefPassword"));
			
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(con!=null)
			{
				con.close();
			}
			
				
			
		}
		return p;
	}
	public void CreateRoomTable() throws SQLException
	{

		
		
		String query1="Create table RoomTable" +
                "(" +
				"RoomNo int primary key);";
		
		if(className.equals(MySqlClassName))
		{
			query1="Create table RoomTable" +
	                "(" +
					"RoomNo int primary key);";
		}
		else if(className.equals(MariaDBClassName))
		{
			query1="Create table RoomTable" +
	                "(" +
					"RoomNo int primary key);";
		}
		else if(className.equals(SqliteDBClassName))
		{
			query1="Create table RoomTable" +
	                "(" +
					"RoomNo int primary key);";
		}
		else if(className.equals(PostgreClassName))
		{
			query1="Create table RoomTable" +
	                "(" +
					"RoomNo int primary key);";
		}
		
		
		
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st1= con.prepareStatement(query1);
			
			st1.executeUpdate();
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		finally {
			if(con!=null)
			{
				con.close();
			}
			
				
			
		}
		
	}
	public void createReservationTable() throws SQLException
	{

		String query1="";
		if(className.equals(MySqlClassName))
		{
			query1="Create table ReservationTable" +
					"(" +
					"ReservationNo Int primary key auto_increment, "
					+ "ReservationStartDate nvarchar(45), "
					+ "ReservationEndDate nvarchar(45), "
					+"DaysToStay int not null, "
					+ "RoomNo int not null,"
					+ "PricePerDay int not null,"
					+ "TotalPrice int not null,"
					+ "PaidOrUnpaid nvarchar(45) not null, "
					+ "ClientNameAndSurname nvarchar(45), "
					+ "ClientPhoneNumber nvarchar(45), "
					+"ClientAddress nvarchar(45));";
		}
		else if(className.equals(MariaDBClassName))
		{
			query1="Create table ReservationTable" +
					"(" +
					"ReservationNo Int primary key auto_increment, "
					+ "ReservationStartDate nvarchar(45), "
					+ "ReservationEndDate nvarchar(45), "
					+"DaysToStay int not null, "
					+ "RoomNo int not null,"
					+ "PricePerDay int not null,"
					+ "TotalPrice int not null,"
					+ "PaidOrUnpaid nvarchar(45) not null, "
					+ "ClientNameAndSurname nvarchar(45), "
					+ "ClientPhoneNumber nvarchar(45), "
					+"ClientAddress nvarchar(45));";
		}
		else if(className.equals(SqliteDBClassName))
		{
			query1="Create table ReservationTable" +
					"(" +
					"ReservationNo integer primary key autoincrement, "
					+ "ReservationStartDate nvarchar(45), "
					+ "ReservationEndDate nvarchar(45), "
					+"DaysToStay integer not null, "
					+ "RoomNo integer not null,"
					+ "PricePerDay integer not null,"
					+ "TotalPrice integer not null,"
					+ "PaidOrUnpaid nvarchar(45) not null, "
					+ "ClientNameAndSurname nvarchar(45), "
					+ "ClientPhoneNumber nvarchar(45), "
					+"ClientAddress nvarchar(45));";
		}
		else if(className.equals(PostgreClassName))
		{
			query1="Create table ReservationTable" +
					"(" +
					"ReservationNo integer primary key generated by default as identity, "
					+ "ReservationStartDate text, "
					+ "ReservationEndDate text, "
					+"DaysToStay integer not null, "
					+ "RoomNo integer not null,"
					+ "PricePerDay integer not null,"
					+ "TotalPrice integer not null,"
					+ "PaidOrUnpaid text, "
					+ "ClientNameAndSurname text, "
					+ "ClientPhoneNumber text, "
					+"ClientAddress text);";
			
		}
                
		
		
		
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st1= con.prepareStatement(query1);
			
			st1.executeUpdate();
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		finally {
			if(con!=null)
			{
				con.close();
			}
			
				
			
		}
		
	}
	public int insertIntoRoomTable(long roomNo ) throws SQLException
	{
		
		
		String query1="Insert into RoomTable (RoomNo)"
				+ "values (?)";
		int result=-1;
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st1= con.prepareStatement(query1);
			st1.setInt(1, (int)roomNo);

			result=st1.executeUpdate();
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		finally {
			if(con!=null)
			{
				con.close();
			}
		}
		
		return result;
		
	}
	public int deleteFromRoomTable(long roomNo) throws SQLException 
	{
		String query1="Delete From RoomTable where RoomNo=?";
		int result=-1;
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st1= con.prepareStatement(query1);
			st1.setInt(1, (int)roomNo);
			result= st1.executeUpdate();
			
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(con!=null)
			{
				con.close();
			}
			
				
			
		}
		
		return result;
		
	}
	
	
	public List<Room> getAllRooms() throws SQLException
	{
		String query="Select * From RoomTable";
		List<Room> roomsInDb=new ArrayList<Room>();
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st= con.prepareStatement(query);
			
			
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				Room p=new Room();
				p.setRoomNo((long)rs.getInt("RoomNo"));
				
				
				roomsInDb.add(p);
				
				
			
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(con!=null)
			{
				con.close();
			}
			
				
			
		}
		return roomsInDb;
	}
	
	public List<Reservation> getAllReservations() throws SQLException
	{
		String query="Select * From ReservationTable";
		List<Reservation> reservationsInDb=new ArrayList<Reservation>();
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st= con.prepareStatement(query);
			
			
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				Reservation p=new Reservation();
				p.setRoomNo((long)rs.getInt("RoomNo"));
				p.setReservationNo((long)rs.getInt("ReservationNo"));
				p.setReservationStartDate(rs.getString("ReservationStartDate"));
				p.setReservationEndDate(rs.getString("ReservationEndDate"));
				p.setDaysToStay((long)rs.getInt("DaysToStay"));
				p.setPricePerDay((long)rs.getInt("PricePerDay"));
				p.setTotalPrice((long)rs.getInt("TotalPrice"));
				p.setPaidOrUnpaid(rs.getString("PaidOrUnpaid"));
				p.setClientNameAndSurname(rs.getString("ClientNameAndSurname"));
				p.setClientCellPhone(rs.getString("ClientPhoneNumber"));
				p.setClientAddress(rs.getString("ClientAddress"));
				
				reservationsInDb.add(p);
				
				
			
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(con!=null)
			{
				con.close();
			}
			
				
			
		}
		return reservationsInDb;
	}
	public List<Reservation> getReservationsByRoom(long roomNo) throws SQLException
	{
		String query="Select * From ReservationTable where RoomNo=?";
		List<Reservation> reservationsByRoom=new ArrayList<Reservation>();
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st= con.prepareStatement(query);
			st.setInt(1, (int)roomNo);
			
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				Reservation p=new Reservation();
				p.setRoomNo((long)rs.getInt("RoomNo"));
				p.setReservationNo((long)rs.getInt("ReservationNo"));
				p.setReservationStartDate(rs.getString("ReservationStartDate"));
				p.setReservationEndDate(rs.getString("ReservationEndDate"));
				p.setDaysToStay((long)rs.getInt("DaysToStay"));
				p.setPricePerDay((long)rs.getInt("PricePerDay"));
				p.setTotalPrice((long)rs.getInt("TotalPrice"));
				p.setPaidOrUnpaid(rs.getString("PaidOrUnpaid"));
				p.setClientNameAndSurname(rs.getString("ClientNameAndSurname"));
				p.setClientCellPhone(rs.getString("ClientPhoneNumber"));
				p.setClientAddress(rs.getString("ClientAddress"));
				reservationsByRoom.add(p);
				
				
			
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(con!=null)
			{
				con.close();
			}
			
				
			
		}
		return reservationsByRoom;
	}
	public Reservation getReservationsByReservationNo(long reservationNo) throws SQLException
	{
		String query="Select * From ReservationTable where ReservationNo=?";
		
		Reservation p=null;
		List<Reservation> reservationsByRoom=new ArrayList<Reservation>();
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st= con.prepareStatement(query);
			st.setInt(1, (int)reservationNo);
			
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				p=new Reservation();
				p.setRoomNo((long)rs.getInt("RoomNo"));
				p.setReservationNo((long)rs.getInt("ReservationNo"));
				p.setReservationStartDate(rs.getString("ReservationStartDate"));
				p.setReservationEndDate(rs.getString("ReservationEndDate"));
				p.setDaysToStay((long)rs.getInt("DaysToStay"));
				p.setPricePerDay((long)rs.getInt("PricePerDay"));
				p.setTotalPrice((long)rs.getInt("TotalPrice"));
				p.setPaidOrUnpaid(rs.getString("PaidOrUnpaid"));
				p.setClientNameAndSurname(rs.getString("ClientNameAndSurname"));
				p.setClientCellPhone(rs.getString("ClientPhoneNumber"));
				p.setClientAddress(rs.getString("ClientAddress"));
				
				
				
			
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(con!=null)
			{
				con.close();
			}
			
				
			
		}
		return p;
	}
	public Room getRoomByRoomNo(long roomNo) throws SQLException
	{
		String query="Select * From RoomTable where RoomNo=?";
		Room p=new Room();
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st= con.prepareStatement(query);
			st.setInt(1, (int)roomNo);
			
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				
				p.setRoomNo((long)rs.getInt("RoomNo"));
				
				
				
			
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(con!=null)
			{
				con.close();
			}
			
				
			
		}
		return p;
	}
	public int deleteReservationsByRoom(long roomNo) throws SQLException
	{
		String query="Delete From ReservationTable where RoomNo=?";
		List<Reservation> reservationsByRoom=new ArrayList<Reservation>();
		int result=0;
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st= con.prepareStatement(query);
			st.setInt(1, (int)roomNo);
			result=st.executeUpdate();
			
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(con!=null)
			{
				con.close();
			}
			
				
			
		}
		return result;
	}
	public int insertIntoReservationTable(long roomNo, String reservationStartDate, String reservationEndDate, 
			long daysToStay,long pricePerDay, long totalPrice,String paidOrUnpaid,
			String clientNameAndSurname, String clientPhoneNumber, String clientAddress ) throws SQLException
	{
		
		
		String query1="Insert into ReservationTable (RoomNo, ReservationStartDate,ReservationEndDate, "
				+"DaysToStay, PricePerDay, TotalPrice, PaidOrUnpaid, "
				+ "ClientNameAndSurname, ClientPhoneNumber, ClientAddress)"
				+ "values (?,?,?,?,?,?,?,?,?,?)";
		int result=-1;
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st1= con.prepareStatement(query1);
			st1.setInt(1, (int)roomNo);
			st1.setString(2, reservationStartDate);
			st1.setString(3, reservationEndDate);
			st1.setInt(4,(int)daysToStay);
			st1.setInt(5, (int)pricePerDay);
			st1.setInt(6, (int)totalPrice);
			st1.setString(7, paidOrUnpaid);
			st1.setString(8, clientNameAndSurname);
			st1.setString(9, clientPhoneNumber);
			st1.setString(10, clientAddress);
			result=st1.executeUpdate();
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		finally {
			if(con!=null)
			{
				con.close();
			}
		}
		
		return result;
		
	}
	public int insertIntoReservationTableWithReservationNo(long reservationNo,long roomNo, String reservationStartDate, String reservationEndDate, 
			long daysToStay,long pricePerDay, long totalPrice,String paidOrUnpaid,
			String clientNameAndSurname, String clientPhoneNumber, String clientAddress ) throws SQLException
	{
		
		
		String query1="Insert into ReservationTable (ReservationNo,RoomNo, ReservationStartDate,ReservationEndDate, "
				+"DaysToStay,PricePerDay, TotalPrice, PaidOrUnpaid, "
				+ "ClientNameAndSurname, ClientPhoneNumber, ClientAddress)"
				+ "values (?,?,?,?,?,?,?,?,?,?,?)";
		int result=-1;
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st1= con.prepareStatement(query1);
			st1.setInt(1, (int)reservationNo);
			st1.setInt(2, (int)roomNo);
			st1.setString(3, reservationStartDate);
			st1.setString(4, reservationEndDate);
			st1.setInt(5,(int)daysToStay);
			st1.setInt(6, (int)pricePerDay);
			st1.setInt(7, (int)totalPrice);
			st1.setString(8, paidOrUnpaid);
			st1.setString(9, clientNameAndSurname);
			st1.setString(10, clientPhoneNumber);
			st1.setString(11, clientAddress);
			result=st1.executeUpdate();
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		finally {
			if(con!=null)
			{
				con.close();
			}
		}
		
		return result;
		
	}
	public int deleteFromReservationTable(long reservationNo) throws SQLException 
	{
		String query1="Delete From ReservationTable where ReservationNo=?";
		int result=-1;
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st1= con.prepareStatement(query1);
			st1.setInt(1, (int)reservationNo);
			result= st1.executeUpdate();
			
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(con!=null)
			{
				con.close();
			}
			
				
			
		}
		
		return result;
		
	}
	public int deleteFromReservationTableByRoomNo(long roomNo) throws SQLException 
	{
		String query1="Delete From ReservationTable where RoomNo=?";
		int result=-1;
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st1= con.prepareStatement(query1);
			st1.setInt(1, (int)roomNo);
			result= st1.executeUpdate();
			
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(con!=null)
			{
				con.close();
			}
			
				
			
		}
		
		return result;
		
	}
	public int deleteAllFromReservationTable() throws SQLException 
	{
		String query1="Delete From ReservationTable";
		int result=-1;
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st1= con.prepareStatement(query1);
			
			result= st1.executeUpdate();
			
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(con!=null)
			{
				con.close();
			}
			
				
			
		}
		
		return result;
		
	}
	public int deleteAllFromRoomTable() throws SQLException 
	{
		String query1="Delete From RoomTable";
		int result=-1;
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st1= con.prepareStatement(query1);
			
			result= st1.executeUpdate();
			
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(con!=null)
			{
				con.close();
			}
			
				
			
		}
		
		return result;
		
	}
	public int updateReservation(long reservationNo,long roomNo, String startDate, String endDate, long daysToStay,
			long pricePerDay, long totalPrice,String paidOrUnpaid,
			String clientNameAndSurname,String clientPhoneNumber,String clientAddress) throws SQLException
	{

		
		
		String query1="Update ReservationTable "
				+ "Set ReservationStartDate=?, ReservationEndDate=?, DaysToStay=?,"
				+ "PricePerDay=?,TotalPrice=?,PaidOrUnpaid=?, ClientNameAndSurname=?, "
				+ "ClientPhoneNumber=?,ClientAddress=? where ReservationNo=? and RoomNo=?";
		int result=-1;
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st1= con.prepareStatement(query1);
			
			st1.setString(1, startDate);
			st1.setString(2, endDate);
			st1.setInt(3, (int)daysToStay);
			st1.setInt(4, (int)pricePerDay);
			st1.setInt(5, (int)totalPrice);
			st1.setString(6, paidOrUnpaid);
			st1.setString(7, clientNameAndSurname);
			st1.setString(8, clientPhoneNumber);
			st1.setString(9, clientAddress);
			st1.setInt(10, (int)reservationNo);
			st1.setInt(11, (int)roomNo);
			result=st1.executeUpdate();
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		finally {
			if(con!=null)
			{
				con.close();
			}
		}
		return result;
		
	}
	public long getTotalOfPaidReservations() throws SQLException
	{
		String query="Select * From ReservationTable where PaidOrUnPaid=?";
		
		
		long total=0;
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st= con.prepareStatement(query);
			st.setString(1,"Paid");
			
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				
				total+=(long)rs.getInt("TotalPrice");
				
				
				
				
			
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(con!=null)
			{
				con.close();
			}
			
				
			
		}
		return total;
	}
	public long getTotalOfUnpaidReservations() throws SQLException
	{
		String query="Select * From ReservationTable where PaidOrUnPaid=?";
		
		
		long total=0;
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st= con.prepareStatement(query);
			st.setString(1,"Unpaid");
			
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				
				total+=(long)rs.getInt("TotalPrice");
				
				
				
				
			
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(con!=null)
			{
				con.close();
			}
			
				
			
		}
		return total;
	}
	
	
}
