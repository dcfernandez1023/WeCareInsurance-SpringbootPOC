package com.wecareinsurance.wecareinsurance.models;

import com.wecareinsurance.wecareinsurance.dao.TestFormDao;
import net.bytebuddy.implementation.bytecode.Throw;

import java.sql.SQLException;
import java.util.HashMap;

public class TestFormTest {
    public static void main(String[] args) throws Exception {
        String line = "\n-------\n";
        String success = "Result: SUCCESS ✅";

        String id = "";
        String name = "Dominic";
        int age = 21;
        String email = "dom22c@gmail.com";
        String phone = "6505347403";
        String company = "We Care Insurance";
        boolean isEmployed = true;

        System.out.println("# Initializing TestForm Data Access Object");
        TestFormDao tfd = new TestFormDao();
        System.out.println(success);

        System.out.println(line);

        try {
            System.out.println("# Creating new TestForm");
            id = tfd.createNewTestForm(name, age, email, phone, company, isEmployed);
            System.out.println("New Id: " + id);
            System.out.println(success);
        }
        catch(Throwable e) {
            System.out.print("Result: ");
            e.printStackTrace();
        }

        System.out.println(line);

        try {
            System.out.println("# Getting newly created TestForm");
            HashMap<String, Object> map = tfd.getTestForm(id);
            System.out.println("\t Fields: ");
            for(String key: map.keySet()) {
                System.out.println("\t\t* " + key + ": " + map.get(key).toString());
            }
            System.out.println(success);
        }
        catch(Throwable e) {
            System.out.print("Result: ");
            e.printStackTrace();
        }
    }
}
