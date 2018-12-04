package com.application.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.application.constant.CoreConstants;
import com.application.util.ConfigurationUtility;

/**
 * 
 * @author jokumar
 * @since 2018-03-25
 * Login Controller to forward to welcome page 	 
 */
@Controller
public class LoginController {
	@Resource
	ConfigurationUtility utility;
	
	@GetMapping(value="/")
    public String showWelcomePage(ModelMap model){
		model.put(CoreConstants.USER_NAME, utility.getLoggedinUserName());
        return CoreConstants.WELCOME;
    }
	
	@GetMapping(value = "/login")
	public String login(ModelMap model, @RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		if (logout != null) {
			model.put("msg", "You've been logged out successfully.");
		}
		if (error != null) {
			model.put("error", "Invalid username and password!");
		}

		return CoreConstants.LOGIN_FORM;

	}

}
