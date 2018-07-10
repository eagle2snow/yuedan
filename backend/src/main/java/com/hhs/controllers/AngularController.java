package com.hhs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AngularController {

    @RequestMapping("/ang/*")
    public String redirect()
    {
        return "forward:/";
    }
}
