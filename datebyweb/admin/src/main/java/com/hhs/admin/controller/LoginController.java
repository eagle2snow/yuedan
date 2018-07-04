package com.hhs.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LoginController {
    @RequestMapping("/")
    String login()
    {
        return "admin/login";
    }
}
