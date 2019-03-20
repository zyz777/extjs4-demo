package com.zyz.extjs.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zyz.extjs.entity.Test;
import org.springframework.web.bind.annotation.*;

/**
 * 权威指南第7章
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/extjs_07")
public class Extjs07Controller {

    ObjectMapper mapper = new ObjectMapper();

    @RequestMapping(value = "test/{id}", method = RequestMethod.GET)
    public Test test1(@PathVariable("id") int id) {
        return new Test(id, "获取");
    }
    @RequestMapping(value = "test", method = RequestMethod.POST)
    public Test test2(@RequestBody Test test) throws JsonProcessingException {
        System.out.printf(mapper.writeValueAsString(test));
        return new Test(2, "新增");
    }
    @RequestMapping(value = "test/{id}", method = RequestMethod.PUT)
    public Test test3(@PathVariable("id") int id) {
        return new Test(3, "更新");
    }
    @RequestMapping(value = "test/{id}", method = RequestMethod.DELETE)
    public Test test4(@PathVariable("id") int id) {
        return new Test(4, "删除");
    }

}
