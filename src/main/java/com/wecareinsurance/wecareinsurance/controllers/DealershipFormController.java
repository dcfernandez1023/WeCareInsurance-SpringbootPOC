package com.wecareinsurance.wecareinsurance.controllers;

import com.wecareinsurance.wecareinsurance.dao.DealershipFormDao;
import com.wecareinsurance.wecareinsurance.dao.TestFormDao;
import com.wecareinsurance.wecareinsurance.models.DealershipForm;
import com.wecareinsurance.wecareinsurance.models.TestForm;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.HashMap;

@RestController
@RequestMapping(path="/api/dealershipForm")
public class DealershipFormController {
    private DealershipFormDao dfd;

    public DealershipFormController() throws Exception {
        this.dfd = new DealershipFormDao();
    }

    @PostMapping(path="/create", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public HashMap<String, Object> create(@RequestBody HashMap<String, Object> body) throws Exception {
        return this.dfd.createForm(body).toHashMap();
    }

    @GetMapping(path="/get/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
    public HashMap<String, Object> get(@PathVariable String id) throws Exception {
        return this.dfd.getForm(id).toHashMap();
    }

    @PostMapping(path="/update/{id}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public HashMap<String, Object> update(@PathVariable String id, @RequestBody HashMap<String, Object> body) throws Exception {
        return this.dfd.updateForm(id, body).toHashMap();
    }

    @DeleteMapping(path="/delete/{id}")
    public String delete(@PathVariable String id) throws Exception {
        return this.dfd.deleteForm(id);
    }
}
