package com.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//import com.model.UserObjectForm;
//import com.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.UserObjectForm;
import com.services.UserService;


@Controller
public class EditUserController {
    @Autowired
	private UserService userService;
        
    	@RequestMapping(value = "editUserAjax", method = RequestMethod.POST)
	public @ResponseBody String addCustomerAction(
            @RequestParam(required = true) int userId,
            @RequestParam(required = true) String firstName,
            @RequestParam(required = true) String lastName,
            @RequestParam(required = true) int age,
            @RequestParam(required = true) String email,
            @RequestParam(required = true) String userName,
            @RequestParam(required = true) String password,
            @ModelAttribute("userObject") UserObjectForm userObject) {
	    System.out.println("Check edit customer ajax controller action");
            
            userObject.setId(userId);
            userObject.setFirstName(firstName);
            userObject.setLastName(lastName);
            userObject.setAge(age);
            userObject.setEmail(email);
            userObject.setUserName(userName);
            userObject.setPassword(password);
            System.out.println(firstName+" ,"+lastName+" ,"+age+", "+email+", "+userName+", "+password);
            try {
                userService.updateUser(userObject);
                return "success";
            } catch (Exception e) {
                e.printStackTrace();
                return "failed";
            }
            
	}
}

