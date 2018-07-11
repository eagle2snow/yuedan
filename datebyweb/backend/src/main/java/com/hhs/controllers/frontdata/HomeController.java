package com.hhs.controllers.frontdata;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/frontData/home")
public class HomeController {
    @RequestMapping("/demo")
    public Map<String, Object> demo()
    {
        Map<String, Object> m = new HashMap<>();
        Integer[] ints = new Integer[3];
        ints[0] = 1;
        ints[1] = 1;
        ints[2] = 2;
        m.put("k", ints);
        return m;
    }
}
