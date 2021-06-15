package com.TDDPOMSeleniumFramework.datautil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUtil {
	
	//private static String queryResult;
	private static String varStrSysPropValue = FileDirectoriesUtil.getTNSFilePath();
	
	/*public static String getQueryResult(String query, String column)  throws SQLException{
		 
		//String DB_DRIVER = Configuration.getValue("db_driver");	//"com.mysql.jdbc.Driver";
		String DB_CONNECTION = Configuration.getValue("sit_db_connection");	//"jdbc:mysql://localhost:3306/demo";
		try {
			if(Configuration.getValue("current").contains("QA")){
			DB_CONNECTION = Configuration.getValue("qa_db_connection");}
		} catch (Exception e) {
		}
		
		String DB_USER = Configuration.getValue("db_user");	//"root";
		String DB_PASSWORD = Configuration.getValue("db_password");	//"root";
		
		Connection dbConnection = null;
		Statement statement = null;
 
		String selectTableSQL = query;
 
		try {
			dbConnection = getDBConnection(DB_DRIVER, DB_CONNECTION, DB_USER, DB_PASSWORD);
			statement = dbConnection.createStatement();
 
			System.out.println(selectTableSQL);
 
			// execute select SQL stetement
			ResultSet rs = statement.executeQuery(selectTableSQL);
 
			while (rs.next()) {
 
				String queryResult = rs.getString(column);
				String username = rs.getString("NAME");
 
				System.out.println("userid : " + queryResult);
				//System.out.println("username : " + username);
				return queryResult;
			}
			
 
		} catch (SQLException e) {
 
			System.out.println(e.getMessage());
 
		} finally {
 
			if (statement != null) {
				statement.close();
			}
 
			if (dbConnection != null) {
				dbConnection.close();
			}
 
		}
		return queryResult;
	}*/
	
	/**
	 * 
	 * @param DB_CONNECTION
	 * @param DB_USER
	 * @param DB_PASSWORD
	 * @return
	 */
	private static Connection getDBConnection(String DB_CONNECTION, String DB_USER,
			String DB_PASSWORD) {

		Connection dbConnection = null;

//		try {
//			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
//		} catch (SQLException e) {
//			System.out.println("Where is your Oracle JDBC Driver?");
//			e.printStackTrace();
//		}

		try {

			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
			System.out.println("Connection established");
			
			return dbConnection;

		} catch (Exception e) {
			System.out.println("Where is your Oracle JDBC Driver?");
			e.printStackTrace();
			return null;
		}

	}

	//method for oracle db return int count
	/*public static int countRecordOracleDB(String query) {
		
			String DB_DRIVER = Configuration.getValue("ora_driver");
			String DB_SID = Configuration.getValue("ora_sid");
			String DB_URL = Configuration.getValue("ora_url");
			String DB_USER = Configuration.getValue("ora_user");
			String DB_PWD = Configuration.getValue("ora_pwd");
			int count = 0;
			
			try {

				Class.forName(DB_DRIVER);

			} catch (ClassNotFoundException e) {
				System.out.println("Where is your Oracle JDBC Driver?");
				e.printStackTrace();
			}

			System.out.println("Oracle JDBC Driver Registered!");
			Connection connection = null;

			try {
		
				connection = DriverManager.getConnection(DB_URL+":"+DB_SID,DB_USER,DB_PWD);
				
			} catch (SQLException e) {
				System.out.println("Connection Failed! Check output console");
				e.printStackTrace();
			}

			if (connection != null) {

				try {
					Statement stmt = connection.createStatement();
					ResultSet rset = stmt.executeQuery(query);
					while (rset.next()) {
						count = Integer.parseInt(rset.getString(1));
						Reporter.log("Records found in DB: " + count);
					}
					rset.close();
					stmt.close();
					connection.close();

				} catch (SQLException e) {
					System.out
							.println("Statement creation Failed!");
					e.printStackTrace();
				}
			} else {
				System.out.println("Failed to make connection!");
			}
			return count;
		}*/
	
	
	/**
	 * 
	 * @param paramStr_query
	 * @param paramStr_dbName
	 * @param paramStr_dbusername
	 * @param paramStr_dbpassword
	 * @return
	 */
	public static String executeDBQuery(final String paramStr_query, final String paramStr_dbName, final String paramStr_dbusername,
			final String paramStr_dbpassword) {

		String varStr_result = "", dbURL = "";
		//varStrSysPropValue = varStrSysPropValue.replace("\\", "/");

		// Set the property of the ojdbc and the db host
		System.setProperty("oracle.net.tns_admin", varStrSysPropValue);
		if(paramStr_dbName.equalsIgnoreCase("TEST03") || paramStr_dbName.equalsIgnoreCase("SALMTEST02")){
			dbURL = "jdbc:oracle:thin:@ebs-rhel-db03-s:1522:"+paramStr_dbName;
		}
		if(paramStr_dbName.equalsIgnoreCase("TEST04")){
			dbURL = "jdbc:oracle:thin:@ebs-rhel-db01-s:1522:"+paramStr_dbName;
		}
		
		// Initialise Connection and Statement
		Connection conn = null;
		Statement stmt = null;
		
		conn = getDBConnection(dbURL, paramStr_dbusername, paramStr_dbpassword);
		
		try {
			stmt = conn.createStatement();
			stmt.executeQuery(paramStr_query);
			System.out.println("Query is successfully executed.");
			
		} catch (Exception e) {
			System.out.println("Where is your Oracle JDBC Driver?");
			e.printStackTrace();
			return null;
		} finally {
			if (stmt != null)
				try {
					stmt.close();
				} catch (Exception e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (Exception e) {
				}
			System.out.println("Connection closed.");
		}
		return varStr_result;
	}
	 /**
	  * <h1>FUNCTION NAME: </h1> getDataFromDB<br>
	  * <br>
	  * @param paramStr_query
	  * @param paramStr_dbName
	  * @param paramStr_dbusername
	  * @param paramStr_dbpassword
	  * @return string, result from the executed db
	  * @author Mark.Salas
	  */
	public static String getDataFromDB(final String paramStr_query, final String paramStr_dbName, final String paramStr_dbusername,
			final String paramStr_dbpassword) {

		String varStr_result = "", dbURL = "";
		//varStrSysPropValue = varStrSysPropValue.replace("\\", "/");

		// Set the property of the ojdbc and the db host
		System.setProperty("oracle.net.tns_admin", varStrSysPropValue);
		if(paramStr_dbName.equalsIgnoreCase("TEST03")  || paramStr_dbName.equalsIgnoreCase("SALMTEST02")){
			dbURL = "jdbc:oracle:thin:@ebs-rhel-db03-s:1522:"+paramStr_dbName;
		}
		if(paramStr_dbName.equalsIgnoreCase("TEST04")){
			dbURL = "jdbc:oracle:thin:@ebs-rhel-db01-s:1522:"+paramStr_dbName;
		}
		if(paramStr_dbName.equalsIgnoreCase("SALMTEST03")){
			dbURL = "jdbc:oracle:thin:@ebs-rhel-db04-s:1521:"+paramStr_dbName;
		}
		
		// Initialise Connection and Statement
		Connection conn = null;
		Statement stmt = null;
		
		conn = getDBConnection(dbURL, paramStr_dbusername, paramStr_dbpassword);
		
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(paramStr_query);

			if (rs.next()) {
				System.out.println(rs.getString(1));
				varStr_result = rs.getString(1);
				return varStr_result;
			}
		} catch (Exception e) {
			System.out.println("Where is your Oracle JDBC Driver?");
			e.printStackTrace();
			return null;
		} finally {
			if (stmt != null)
				try {
					stmt.close();
				} catch (Exception e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (Exception e) {
				}
		}
		return varStr_result;
	}
	
}
