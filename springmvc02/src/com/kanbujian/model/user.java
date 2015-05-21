package com.kanbujian.model;

import javax.annotation.Resource;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="user")
public class user {
      String username;
      String password;
      String email;
    
  	public user() {
		
  	}  
  	@Id   
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public user(String username, String password, String email) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
	}
    public boolean equals(Object obj){
    	
    	if(!(obj instanceof user))
    		return false;
    	
    	user userTwo=(user)obj;
    	boolean isEquals=this.username.equals(userTwo.getUsername());
    	//System.out.println("equals running "+isEquals);
    	return isEquals;
    		
    }
}
