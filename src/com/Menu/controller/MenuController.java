package com.Menu.controller;

import com.Menu.dao.MenuDAO;
import com.Menu.vo.MenuVO;

public class MenuController {
  private MenuDAO dao = new MenuDAO();
  
  public boolean join(MenuVO data) {
	  MenuVO account =dao.get(data.getSnack_menu());
	  
	  if( account == null ) {
		  boolean result = dao.add(data);		  
		   if(result) {
			 return true;
	   } 
	 }
     return false;
  
  }

public boolean update(MenuVO data) {
	return  dao.modify(data);

}

public boolean remove(MenuVO data) {
	boolean result = dao.remove(data);
	
	if(result) {
		return true;
	}
	return false;
}
  
  
  
}
