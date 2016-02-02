package com.validator;

import java.util.List;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.bean.Batch;
import com.bean.User;
import com.service.BatchService;
import com.service.UserService;

public class CreateUserValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return arg0.equals(User.class);
	}

	@Override
	public void validate(Object object, Errors errors) {
		// TODO Auto-generated method stub
		if(object==null){
			errors.rejectValue("username", "username.required", "Please Select a Username");
		}
		User user=(User) object;
		 if(user.getUsername()==null||user.getUsername().length()<4){
	        	errors.rejectValue("username", "username.length","Length should be more than 4 characters ");
	        }
	        if(user.getPassword()==null||user.getPassword().length()<4){
	        	errors.rejectValue("password", "password.length","Length should be more than 4 characters ");
	        }
	        if(user.getName()==null||user.getName().length()<4){
	        	errors.rejectValue("name", "name.length","Length should be more than 4 characters ");
	        }
	        if(user.getEmail()==null||user.getEmail().length()<4){
	        	errors.rejectValue("email", "email.length","Length should be more than 4 characters ");
	        }
	        
	     List<User> users=new UserService().getUserlist();
	       for (User u : users) {
			if(u.getUsername().equals(user.getUsername())){
				errors.rejectValue("username", "username.required1","User with this username is already exists .");
				break;
			}
	       }
	     
		
	}

}
