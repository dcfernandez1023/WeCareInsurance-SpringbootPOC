package com.wecareinsurance.wecareinsurance.models;

import com.wecareinsurance.wecareinsurance.dal.DatabaseAccess;
import com.wecareinsurance.wecareinsurance.dal.MySQLDataAccess;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.UUID;

public class TestForm implements Model {
    private String id;
    private String name;
    private int age;
    private String email;
    private String phone;
    private String company;
    private boolean isEmployed;

    // Empty constructor so the jackson package can map JSON request body from controller to this model object
    public TestForm() {}

    /*
     * Constructor generates a new id for the form. This is used for when a new form is being created
    */
    public TestForm(String name, int age, String email, String phone, String company, boolean isEmployed) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.company = company;
        this.isEmployed = isEmployed;
    }

    public TestForm(String id, String name, int age, String email, String phone, String company, boolean isEmployed) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.company = company;
        this.isEmployed = isEmployed;
    }

    @Override
    public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", this.id);
        map.put("name", this.name);
        map.put("age", this.age);
        map.put("email", this.email);
        map.put("phone", this.phone);
        map.put("company", this.company);
        map.put("isEmployed", this.isEmployed);
        return map;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public boolean isEmployed() {
        return isEmployed;
    }

    public void setEmployed(boolean employed) {
        isEmployed = employed;
    }
}
