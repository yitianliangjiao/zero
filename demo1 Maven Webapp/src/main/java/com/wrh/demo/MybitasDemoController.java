package com.wrh.demo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wrh.dao.t_userDao;
import com.wrh.model.t_user;
import com.wrh.service.t_userService;
import com.wrh.serviceImpl.t_userServiceImpl;

@Controller
@RequestMapping("/demo")  
public class MybitasDemoController {
@Autowired
private t_userServiceImpl userService;
@RequestMapping("/mybitas")  
public String toIndex(ModelMap map){  
    int userId = 1;  
    t_user user = userService.getModel(userId); 
    map.addAttribute("name", user.getName());  
    return "jsps/list"; 
}
@ResponseBody
@RequestMapping("/test.json")
public String Test(String id,HttpServletRequest request){
	id = request.getParameter("id");
	System.out.println(id);
	return id;
}
}