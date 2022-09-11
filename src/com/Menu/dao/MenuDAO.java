package com.Menu.dao;

import com.Menu.vo.MenuVO;
import com.conn.db.DBConn;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.Format;

public class MenuDAO {
   // 데이터의 실질적인 처리	
	private DBConn db;
	public MenuDAO() {
		try {
			db = new DBConn("localhost","1521","XEPDB1","puser1","puser1");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
  
 public boolean add (MenuVO data) {
     String query = String.format("INSERT INTO SNACK_TABLE VALUES('%d','%s','%s','%s','%s')"
    		       , data.getSnack_number()
    		       , data.getCategory()
    		       , data.getSnack_menu()
    		       , data.getCal_menu()
    		       , data.getRecommend_drink());
    
     try {
		int result = db.sendInsertQuery(query);
		
		if(result == 1) {
			return true;
		}
	} catch (Exception e) {

		e.printStackTrace();
	}
	 return false; 
	 
  }


public boolean modify(MenuVO data) {
	String query = ""
			   + "UPDATE SNACK_TABLE "
			   + "    SET CATEGORY = '" + data.getCategory()+"'"
			   + "       ,SNACK_MENU = '"+ data.getSnack_menu()+"'"
			   + "       ,CAL_MENU = '" + data.getCal_menu()+"'"
			   + "       ,RECOMMEND_DRINK = '"+ data.getRecommend_drink()+"'"
			   + "  WHERE SNACK_NUMBER  = '" + data.getSnack_number()+ "'";

   try {
	int result = db.sendUpdateQuery(query);
	if(result == 1) {
		return true;
	}
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

	return false;
}


public boolean remove(MenuVO data) {
	  String query = String.format("DELETE FROM SNACK_TABLE WHERE SNACK_MENU ='%s'", data.getSnack_menu());
	
	
	try {
		int result = db.sendDeleteQuery(query);
		if(result ==1) {
			return true;
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return false;
}

 public MenuVO get(String snack_menu) {
	 //단일 데이터조회
	 String query = String.format("SELECT * FROM SNACK_TABLE WHERE SNACK_MENU ='%s'", snack_menu);
	 
	 try {
		ResultSet rs = db.sendSelectQuery(query);
		
		if(rs.next()) {
			MenuVO data = new MenuVO();
			data.setSnack_number(rs.getInt("SNACK_NUMBER"));
			data.setCategory(rs.getString("CATEGORY"));
			data.setSnack_menu(rs.getString("SNACK_MENU"));
			data.setCal_menu(rs.getString("CAL_MENU"));
			data.setRecommend_drink(rs.getString("RECOMMEND_DRINK"));			
			return data;
		}
		 
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   return null;
 }


 
 }

