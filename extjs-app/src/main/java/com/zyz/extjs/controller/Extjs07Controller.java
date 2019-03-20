package com.zyz.extjs.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zyz.extjs.entity.Products;
import com.zyz.extjs.entity.Test;
import org.springframework.web.bind.annotation.*;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.DoubleStream;

/**
 * 权威指南第7章
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/extjs_07")
public class Extjs07Controller {

    ObjectMapper mapper = new ObjectMapper();

    //*********************************
    //  03-proxy -> proxy.html
    //*********************************

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



    //************************************
    //  06-store  ->  store.html
    //************************************
    private static List<Products> list = new ArrayList<>();
    static {
        Random random = new Random();

        Products products = null;
        for (int i = 1; i <= 1345; i++) {
            products = new Products();
            list.add(products);

            products.setId(i);
            products.setProductName("产品名称"+i);

            int num = random.nextInt(10);//0-9的随机数
            products.setSupplierId(num);

            num = random.nextInt(10);//0-9的随机数
            products.setCategoryId(num);

            products.setQuantityPerUnit(UUID.randomUUID().toString());
            products.setUnitPrice((float)(Math.random()*100));

            num = random.nextInt(200);
            products.setUnitsInStock(num);

            num = random.nextInt(200);
            products.setUnitsOnOrder(num);

            num = random.nextInt(6);
            products.setReorderLevel(num);

            num = random.nextInt(11);
            products.setDiscontinued(num>5);
        }
    }

    class Response {
        private boolean success = true;
        private int total;
        private Object data;

        public Response(int total, Object data) {
            this.total = total;
            this.data = data;
        }

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }
    }

    //page=1&start=0&limit=20
    @RequestMapping("/products")
    public Response list(int page, int start, int limit) {
        System.out.println(MessageFormat.format("page={0}, start={1}, limit={2}", page, start, limit));

        int startIndex = (page-1)*limit;
        int endIndex = page * limit;
        int size = list.size();
        List<Products> rsList = new ArrayList<>(limit);
        for (int i = startIndex; i < endIndex && i<=size; i++) {
            rsList.add(list.get(i));
        }
        return new Response(size, rsList);
    }

}
