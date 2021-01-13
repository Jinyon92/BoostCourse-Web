package kr.or.connect.boostcourse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyreservationController {
	
	@GetMapping(path="/myreservation")
	public String myreservation() {
		return "myreservation";
	}
}
