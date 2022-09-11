package com.Menu.vo;

public class MenuVO {
	private int snack_number; 
	private String category;         //카테고리
	private String snack_menu;        //메뉴
	private String cal_menu;         //칼로리
	private String recommend_drink;  //추천 술
	
	
	
	
	public int getSnack_number() {
		return snack_number;
	}
	public void setSnack_number(int snack_number) {
		this.snack_number = snack_number;
	}
	public void setSnack_number(String snack_number) {
		this.snack_number = Integer.parseInt(snack_number);
	}

	
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
	public String getSnack_menu() {
		return snack_menu;
	}
	public void setSnack_menu(String snack_menu) {
		this.snack_menu = snack_menu;
	}
	
	
	public String getCal_menu() {
		return cal_menu;
	}
	public void setCal_menu(String cal_menu) {
		this.cal_menu = cal_menu;
	}
	
	
	public String getRecommend_drink() {
		return recommend_drink;
	}
	public void setRecommend_drink(String recommend_drink) {
		this.recommend_drink = recommend_drink;
	}
	
	
 
}
