package com.hhs.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class ErrorController {

	@GetMapping("{errorCode}")
	public String toPage(@PathVariable Integer errorCode) {
		return "/error/" + errorCode;
	}

}
