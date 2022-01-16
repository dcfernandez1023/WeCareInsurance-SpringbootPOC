package com.wecareinsurance.wecareinsurance.controllers;

import com.wecareinsurance.wecareinsurance.dao.TestFormDao;
import com.wecareinsurance.wecareinsurance.models.TestForm;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.HashMap;

@RestController
@RequestMapping(path="/api/testForm")
public class TestFormController {
    private TestFormDao tfd;

    public TestFormController() throws Exception {
        this.tfd = new TestFormDao();
    }

    @GetMapping(path="/test")
    public String test() throws Exception {
        return "Hello from the TestFormController class!";
    }

    @PostMapping(path="/create", consumes=MediaType.APPLICATION_JSON_VALUE)
    public String createTestForm(@RequestBody TestForm tf) throws Exception {
        return this.tfd.createNewTestForm(tf.getName(), tf.getAge(), tf.getEmail(), tf.getPhone(), tf.getCompany(), tf.isEmployed());
    }

    @GetMapping(path="/get/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
    public HashMap<String, Object> getTestForm(@PathVariable String id) throws Exception {
        return this.tfd.getTestForm(id);
    }
}
