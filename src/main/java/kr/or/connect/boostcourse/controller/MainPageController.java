package kr.or.connect.boostcourse.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.connect.boostcourse.dto.Product;
import kr.or.connect.boostcourse.service.ProductService;

@Controller
public class MainPageController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping(path="/mainpage")
	public String mainpage() {
		return "mainpage";
	}
	
	@GetMapping(path="/bookinglogin")
	public String bookingLogin() {
		return "bookinglogin";
	}
	
	@PostMapping(path="/loginProcess")
	public String loginProcess(@RequestParam String resrv_email,
						HttpSession session) {
		session.setAttribute("resrv_email", resrv_email);
		return "redirect:myreservation";
	}
}
