package com.zyz.extjs4mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mvc")
public class HelloController {

    @RequestMapping("/index")
    public String index() {
        return "mvc/index";
    }

}
