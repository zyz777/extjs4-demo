package com.zyz.extjs.entity;

public class User {

    private Integer id;
    private String name;
    private String descn;

    public User(Integer id, String name, String descn) {
        this.id = id;
        this.name = name;
        this.descn = descn;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescn() {
        return descn;
    }

    public void setDescn(String descn) {
        this.descn = descn;
    }
}
