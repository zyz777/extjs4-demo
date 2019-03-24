package com.zyz.extjs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mvc")
public class HelloController {

    @RequestMapping("index")
    public String index() {
        System.out.println("url：mvc/index");
        return "/templates/mvc/index";
    }

}
