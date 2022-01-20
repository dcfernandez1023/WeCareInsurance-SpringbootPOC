package com.wecareinsurance.wecareinsurance.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wecareinsurance.wecareinsurance.TestHelper;
import com.wecareinsurance.wecareinsurance.models.DealershipForm;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.util.HashMap;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestDealershipFormController extends RestControllerContext {
    static String form_id = null;

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    @Order(1)
    public void testCreateFormEndpoint() throws Exception {
        String endpoint = "/api/dealershipForm/create";
        HashMap<String, Object> testData = TestHelper.getDealershipFormTestData(false, "test from REST");
        // Make the REST API call
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(endpoint)
                .content(super.mapToJson(testData))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        DealershipForm df = new ObjectMapper().readValue(content, DealershipForm.class);
        form_id = df.getForm_id();
        assertNotNull(df);
    }

    @Test
    @Order(3)
    public void testUpdateFormEndpoint() throws Exception {
        String endpoint = "/api/dealershipForm/update/" + form_id;
        HashMap<String, Object> testData = TestHelper.getDealershipFormTestData(false, "Update via REST");
        // Make the REST API call
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(endpoint)
                .content(super.mapToJson(testData))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        DealershipForm df = new ObjectMapper().readValue(content, DealershipForm.class);
        assertEquals(form_id, df.getForm_id());
        for(Field f: df.getFields()) {
            if(!f.getName().equals("form_id")) {
                assertEquals(f.get(df), "Update via REST");
            }
        }
        form_id = df.getForm_id();
        assertNotNull(df);
    }

    @Test
    @Order(4)
    public void testDeleteFormEndpoint() throws Exception {
        String endpoint = "/api/dealershipForm/delete/" + form_id;
        // Make the REST API call
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(endpoint)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(form_id, content);
    }

//    @Test
//    @Order(2)
//    public void testGetFormEndpoint() throws Exception {
//        String endpoint = "/api/dealershipForm/get/" + form_id;
//        System.out.println(endpoint);
//        // Make the REST API call
//        System.out.println("here");
//        System.out.println(mvc);
//        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(endpoint)
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
//        System.out.println("here2");
//        int status = mvcResult.getResponse().getStatus();
//        System.out.println("here3");
//        assertEquals(200, status);
//        String content = mvcResult.getResponse().getContentAsString();
//        System.out.println(content);
//        DealershipForm df = new ObjectMapper().readValue(content, DealershipForm.class);
//        assertNotNull(df);
//    }
}
