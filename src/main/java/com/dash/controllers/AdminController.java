package com.dash.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AdminController {
	@GetMapping({"/","/login"})
	public String logIn() {
		return "adminLogIn";
	}
	
	@PostMapping("/login")
	public String verifyLogIn(HttpServletRequest req,RedirectAttributes ra,Model model) {
		String uname = (String) req.getParameter("uname");
		String pwd = (String) req.getParameter("pwd");
		if(uname.equals("admin") && pwd.equals("admin123")) {
			ra.addFlashAttribute("msg", uname);
			return "redirect:/dashBoard";
		}
		model.addAttribute("msg", "Incorrect Uname and Password");
		return "adminLogIn";
	}
	
	@GetMapping("/dashBoard")
	public String dashBoardPage() {
		return "dashBoard";
	}
}
