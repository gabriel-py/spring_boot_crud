package com.trabalho_lp.trabalho_lp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
		@RequestMapping("/")
		public String index() {
			return "index";
		}
}
