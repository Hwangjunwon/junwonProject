package com.Menu.view;

import java.awt.Menu;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.Scanner;

import com.Menu.controller.MenuController;
import com.Menu.menu.MenuMenu;
import com.Menu.vo.MenuVO;
import com.conn.db.DBConn;

public class MenuView {
   private DBConn db;
   private MenuVO data = new MenuVO();
   private MenuController mc = new MenuController();
   private MenuMenu menu = new MenuMenu();
   private Scanner sc = new Scanner(System.in); 
   
 public void show() {
	 while(true) {
		 System.out.println(menu.getMain());
		 System.out.println(">>>");
		 String input = sc.nextLine();
		 
		 switch(input) {
		 case "1":
			 //안주카테고리
			 this.MenuCategory();
			 break;
			 
		 case "2":
			//안주추천
			this.MenuRecommend();
			 break;
			 
		 case "3":
			//안주추가,수정,삭제
			 this.afterAmr();
			 break;
			 
		 case "0":
			 System.out.println("프로그램을 종료합니다.");
	    	 System.exit(0);
		 default:
			 System.out.println("번호를 잘못입력하셨습니다.\n다시확인해주세요!!!");
		 }
		 
	 }
 
 }
 
 public void MenuCategory() {
	 try {
			db = new DBConn("localhost","1521","XEPDB1","puser1","puser1");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
	 
	 System.out.println(menu.allSnack());
	 System.out.println(">>>");
	 String input = sc.nextLine();
	 
	switch(input) {
	case "1":
		System.out.println("───────────────한식 카테고리───────────────");
		String query1 = "SELECT SNACK_NUMBER, CATEGORY, SNACK_MENU ,CAL_MENU,RECOMMEND_DRINK FROM SNACK_TABLE WHERE CATEGORY ='한식'";
		try {
			ResultSet rs = db.sendSelectQuery(query1);
			while(rs.next()) {
				System.out.print(rs.getString("SNACK_NUMBER") + "\t");
				System.out.print(rs.getString("CATEGORY") + "\t");
				System.out.print(rs.getString("SNACK_MENU") + "\t");
				System.out.print(rs.getString("CAL_MENU")+ "\t");
				System.out.print(rs.getString("RECOMMEND_DRINK")+ "\t");
				System.out.print("\n");
			}
			System.out.println("───────────────────────────────────────");
			System.out.println("\n");
		} catch (Exception e) {
			
			e.printStackTrace();
		}		
		break;
		
	case "2":
		System.out.println("───────────────양식 카테고리───────────────");
		String query2 = "SELECT SNACK_NUMBER,CATEGORY, SNACK_MENU ,CAL_MENU,RECOMMEND_DRINK FROM SNACK_TABLE WHERE CATEGORY ='양식'";
		try {
			ResultSet rs = db.sendSelectQuery(query2);
			while(rs.next()) {
				System.out.print(rs.getString("SNACK_NUMBER") + "\t");
				System.out.print(rs.getString("CATEGORY") + "\t");
				System.out.print(rs.getString("SNACK_MENU") + "\t");
				System.out.print(rs.getString("CAL_MENU")+ "\t");
				System.out.print(rs.getString("RECOMMEND_DRINK")+ "\t");
				System.out.print("\n");
			}
			System.out.println("───────────────────────────────────────");
			System.out.println("\n");
		} catch (Exception e) {
			
			e.printStackTrace();
		}		
		break;
		
	case "3":
		System.out.println("───────────────중식 카테고리───────────────");
		String query3 = "SELECT SNACK_NUMBER,CATEGORY, SNACK_MENU ,CAL_MENU,RECOMMEND_DRINK FROM SNACK_TABLE WHERE CATEGORY ='중식'";
		try {
			ResultSet rs = db.sendSelectQuery(query3);
			while(rs.next()) {
				System.out.print(rs.getString("SNACK_NUMBER") + "\t");
				System.out.print(rs.getString("CATEGORY") + "\t");
				System.out.print(rs.getString("SNACK_MENU") + "\t");
				System.out.print(rs.getString("CAL_MENU")+ "\t");
				System.out.print(rs.getString("RECOMMEND_DRINK")+ "\t");
				System.out.print("\n");
			}
			System.out.println("───────────────────────────────────────");
			System.out.println("\n");
		} catch (Exception e) {
			
			e.printStackTrace();
		}		
		break;
		
	case "4":
		System.out.println("───────────────분식 카테고리───────────────");
		String query4 = "SELECT SNACK_NUMBER,CATEGORY, SNACK_MENU ,CAL_MENU,RECOMMEND_DRINK FROM SNACK_TABLE WHERE CATEGORY ='분식'";
		try {
			ResultSet rs = db.sendSelectQuery(query4);
			while(rs.next()) {
				System.out.print(rs.getString("SNACK_NUMBER") + "\t");
				System.out.print(rs.getString("CATEGORY") + "\t");
				System.out.print(rs.getString("SNACK_MENU") + "\t");
				System.out.print(rs.getString("CAL_MENU")+ "\t");
				System.out.print(rs.getString("RECOMMEND_DRINK")+ "\t");
				System.out.print("\n");
			}
			System.out.println("───────────────────────────────────────");
			System.out.println("\n");
		} catch (Exception e) {
			
			e.printStackTrace();
		}		
		break;
		
	case "9":		
		return;
	}
	 
	 
	 
 }
 public void MenuRecommend() {
	 try {
			db = new DBConn("localhost","1521","XEPDB1","puser1","puser1");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	 
	
	 String query= "SELECT * FROM (SELECT * FROM SNACK_TABLE ORDER BY dbms_random.value)WHERE ROWNUM <=1";
	 	
	 try {
			ResultSet rs = db.sendSelectQuery(query);				
			System.out.println("─────────오늘의 랜덤안주───────────");
			System.out.println("카테고리"+"\t"+"메뉴" + "\t" + "칼로리"+"\t" + "술"+"\t");
			
			while(rs.next()) {
			  System.out.print(rs.getString("CATEGORY")+ "\t");
			  System.out.print(rs.getString("SNACK_MENU")+ "\t");
			  System.out.print(rs.getString("CAL_MENU")+ "\t");
		      System.out.print(rs.getString("RECOMMEND_DRINK")+ "\t");
		      System.out.print("\n");
			}
				
			 System.out.println("───────────────────────────────");
			 System.out.println("오늘은 이거!!!");
			 System.out.println("\n");
			 System.out.println("\n");
		} catch (Exception e) {			
			e.printStackTrace();
		}
 }
 
 
 
 //메뉴 추가수정삭제 페이지.
 public void afterAmr( ) {
		try {
			db = new DBConn("localhost","1521","XEPDB1","puser1","puser1");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
	 
	 while(true) {
		 System.out.println(menu.MenuAmr());
		 System.out.print(">>>");
		 String input = sc.nextLine();
		 
		 String query= "SELECT SNACK_NUMBER ,CATEGORY, SNACK_MENU,CAL_MENU,RECOMMEND_DRINK FROM SNACK_TABLE";
		 switch(input) {
		 case "1":
			 //안주메뉴 추가
			 try {
				ResultSet rs = db.sendSelectQuery(query);				
				System.out.println("──────────현재 등록안주─────────────");
				while(rs.next()) {
				  System.out.print(rs.getString("SNACK_NUMBER")+ "\t");	
				  System.out.print(rs.getString("CATEGORY")+ "\t");
				  System.out.print(rs.getString("SNACK_MENU")+ "\t");
				  System.out.print(rs.getString("CAL_MENU")+ "\t");
			      System.out.print(rs.getString("RECOMMEND_DRINK")+ "\t");
			      System.out.print("\n");
				}
					
				
			} catch (Exception e) {			
				e.printStackTrace();
			}
			 
			 
	   System.out.println("예) 한식 / 삼겹살 / 300kcal / 소주");
	   System.out.println("중복은 허용하지 않습니다.");
	   
	    System.out.println("추가 할 번호 : ");
		data.setSnack_number(sc.nextLine());
		
		System.out.println("추가 할 카테고리 : ");
		data.setCategory(sc.nextLine());
		
		System.out.println("추가 할 메뉴 : ");
		data.setSnack_menu(sc.nextLine());
			
		System.out.println("추가 할 칼로리 : ");
		data.setCal_menu(sc.nextLine());
				
		System.out.println("추가 할 추천 술 : ");
		data.setRecommend_drink(sc.nextLine());	 
		
		boolean result = mc.join(data);
		
		if(result) {
			System.out.println("추가가 완료되었습니다!!!");
		}else {
			System.out.println("추가에 실패하였습니다(중복)");
		}
			 			 
		 break;
		 case "2":
			 //안주메뉴 수정
			 
			 try {
				ResultSet rs = db.sendSelectQuery(query);				
				System.out.println("─────────────수정가능 안주──────────────");
				while(rs.next()) {
			      System.out.print(rs.getString("SNACK_NUMBER")+ "\t");	
				  System.out.print(rs.getString("CATEGORY")+ "\t");
				  System.out.print(rs.getString("SNACK_MENU")+ "\t");
				  System.out.print(rs.getString("CAL_MENU")+ "\t");
			      System.out.print(rs.getString("RECOMMEND_DRINK")+ "\t");
			      System.out.print("\n");
				}
					
				
			} catch (Exception e) {			
				e.printStackTrace();
			}
			 		
			 
			    System.out.println("변경 할 메뉴번호! : ");
			    data.setSnack_number(sc.nextLine());
			 
				 
				 System.out.println("변경 할 카테고리: ");
				 data.setCategory(sc.nextLine());
				 
				 System.out.println("변경 할 안주명: ");
				 data.setSnack_menu(sc.nextLine());
				 
				 System.out.println("변경 할 칼로리: ");
				 data.setCal_menu(sc.nextLine());
				 
				 System.out.println("변경 할 술: ");
				 data.setRecommend_drink(sc.nextLine());

				  
			 if(mc.update(data)){
				  System.out.println("메뉴수정이 완료되었습니다!!!");
			 }else {
				 System.out.println("메뉴명을 다시 확인해주세요.");
			 }

			 
			 break;
			 
		 case "3":
			 //안주메뉴 삭제
				System.out.println("삭제 할 메뉴: ");
				data.setSnack_menu(sc.nextLine());	 
				
				boolean result2 = mc.remove(data);
			 
			 
			 if(result2) {
				 System.out.println("메뉴삭제에 성공하였습니다!!!");
			 }else {				 
				 System.out.println("메뉴삭제에 성공하였습니다!!!");
			 }
			 break;
		 case "9":
			 //뒤로가기
			 return ;
		 }
				 
				 
	 }
	 
 }
 
 
 
 
 
 
  
  
	
	
	
	
	
	
	
}
