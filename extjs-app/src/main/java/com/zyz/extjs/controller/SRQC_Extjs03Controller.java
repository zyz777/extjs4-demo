package com.zyz.extjs.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zyz.extjs.entity.Response;
import com.zyz.extjs.entity.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/**
 * 深入浅出Extjs 第三章
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/srqc/extjs03")
public class SRQC_Extjs03Controller {

    private static List<User> list = new ArrayList<>();
    static {
        User u = null;
        for (int i = 1; i <= 1345; i++) {
            u = new User();
            list.add(u);

            u.setId(i);
            u.setName("name"+i);
            u.setDescn("descn"+i);
        }
    }

    /**
     * 3.9.2
     * @return
     */
    @RequestMapping("/test3_9_2")
    public Response test3_9_2(int page, int start, int limit) {
        System.out.println(MessageFormat.format("page={0}, start={1}, limit={2}", page, start, limit));
        int startIndex = (page-1)*limit;
        int endIndex = page * limit;
        int size = list.size();
        List<User> rsList = new ArrayList<>(limit);
        for (int i = startIndex; i < endIndex && i<size; i++) {
            rsList.add(list.get(i));
        }

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new Response(size, rsList);
    }

    @RequestMapping("/test3_12_3")
    public Response test3_12_3(@RequestParam("data") String data) {
        System.out.println(data);
        return new Response();
    }

}
