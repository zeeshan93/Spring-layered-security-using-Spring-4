package com.compassites.testproject.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DataController {
	@RequestMapping(value = {"/operation/message"}, method = RequestMethod.GET)
	@ResponseBody
	@Secured("ROLE_USER")
	public String messageMethod(@RequestHeader(value = "auth_key") String authKey){
		return "Message acquired";
	}
	
	@RequestMapping(value = {"/messages"}, method = RequestMethod.GET)
	@ResponseBody
	@Secured("ROLE_ANY")
	public String messageMethodSecured(){
		return "Message acquired from layer 2 security";
	}
}
