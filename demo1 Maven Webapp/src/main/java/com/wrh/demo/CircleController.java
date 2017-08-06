package com.wrh.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/circle")
public class CircleController {
@RequestMapping("/index")
public String index()
{
	return "jsps/index";
}
}
