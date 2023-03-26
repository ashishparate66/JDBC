package com.masai.dao;

import com.masai.dto.UserDTO;
import com.masai.exceptions.SomethingWentWrongException;

public interface UserDao {
	
   public void signUp(UserDTO udto);
   public void login(String username, String password)throws SomethingWentWrongException;
   public void signOut();

}
