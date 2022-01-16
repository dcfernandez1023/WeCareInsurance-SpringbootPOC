package com.wecareinsurance.wecareinsurance.dao;

import com.wecareinsurance.wecareinsurance.TestHelper;
import com.wecareinsurance.wecareinsurance.dal.DatabaseAccess;
import com.wecareinsurance.wecareinsurance.dal.MySQLDataAccess;
import com.wecareinsurance.wecareinsurance.models.DealershipForm;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.Assert.*;

import java.util.HashMap;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestDealershipFormDao {
    static String form_id = null;

    @Test
    @Order(1)
    public void testCreateForm() throws Exception {
        HashMap<String, Object> testData = TestHelper.getDealershipFormTestData(false, "test");
        DealershipFormDao dfDao = new DealershipFormDao();
        DealershipForm df = dfDao.createForm(testData);
        form_id = df.getForm_id();
        assertNotNull(df);
    }

    @Test
    @Order(2)
    public void testGetForm() throws Exception {
        DealershipFormDao dfDao = new DealershipFormDao();
        DealershipForm df = dfDao.getForm(form_id);
        assertNotNull(df);
    }

    @Test
    @Order(3)
    public void testUpdateForm() throws Exception {
        DealershipFormDao dfDao = new DealershipFormDao();
        HashMap<String, Object> testData = TestHelper.getDealershipFormTestData(true, "updated value");
        testData.put("form_id", form_id);
        DealershipForm df = dfDao.updateForm(form_id, testData);
        assertNotNull(df);
        assertEquals(form_id, df.getForm_id());
    }

    @Test
    @Order(4)
    public void testUpdateFormId() throws Exception {
        DealershipFormDao dfDao = new DealershipFormDao();
        HashMap<String, Object> testData = TestHelper.getDealershipFormTestData(true, "updated value");
        DealershipForm df = dfDao.updateForm(form_id, testData);
        assertEquals(form_id, df.getForm_id());
    }

    @Test
    @Order(5)
    public void testDeleteForm() throws Exception {
        DealershipFormDao dfDao = new DealershipFormDao();
        String deletedId = dfDao.deleteForm(form_id);
        assertEquals(form_id, deletedId);
    }
}
