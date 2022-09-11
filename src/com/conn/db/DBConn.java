package com.conn.db;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class DBConn {
	private final static String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	private final static String BASE_URL = "jdbc:oracle:thin:@";
	
	
	private String url_address;
	private Connection conn;
	private Statement stat;
	//로컬
	public DBConn(String address, String port, String serviceName, String username, String password) throws Exception {
		url_address = String.format("%s:%s/%s", address, port, serviceName);
		this.createConnection(username, password);
		
	}

	//월렛
     public DBConn(String tnsAlias, String walletPath, String username, String password)throws Exception {
				
	}
	
	public DBConn(File config) {
     try {
    	 Map<String, String> map = new HashMap<String, String>();
    	 
		 BufferedReader br = new BufferedReader(new FileReader(config));
		StringBuilder sb = new StringBuilder();
		
		while(br.ready()) {
			String[] kv = br.readLine().split("=");
			map.put(kv[0].strip(), kv[1].strip());			
		}
		
		url_address = String.format("%s:%s/%s", map.get("host"), map.get("port"), map.get("service"));
		this.createConnection(map.get("username"), map.get("password"));
		

		
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	public static void main(String[] args) {
	 DBConn db = new DBConn(new File(System.getProperty("user.home") + "/oracle.db.conf"));
	}
	

	private void createConnection(String username, String password) throws Exception {
		//1. Driver 등록
	    Class.forName(DRIVER_NAME);
	    
	    //2. DBMS연결
	    conn = DriverManager.getConnection(BASE_URL + url_address, username, password);
		
			
		//3. statemnet생성
		stat = conn.createStatement();
	}
	
	
	
	public ResultSet sendSelectQuery(String query) throws Exception{
		return this.stat.executeQuery(query);		
	}
	public int sendInsertQuery(String query) throws Exception {
		return this.stat.executeUpdate(query);
	}
	public int sendUpdateQuery(String query)  throws Exception{
		return this.stat.executeUpdate(query);
	}
	public int sendDeleteQuery(String query) throws Exception {
		return this.stat.executeUpdate(query);
	}
	
	public void close()  throws Exception{
		this.stat.close();
		this.conn.close();
	}
	
 
	
	


	
	
	


}
