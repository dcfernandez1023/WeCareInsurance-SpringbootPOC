package com.wecareinsurance.wecareinsurance.models;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

public class TestDealershipForm {
    @Test
    public void testHelloWorld() {
        String str = "hello world";
        assertEquals("hello world", str);
    }

    @Test
    public void testNewDealershipFormInstantiation() throws Exception {
        HashMap<String, Object> testData = new HashMap<>();
        // Instantiate tempForm to get fields and construct test data
        DealershipForm tempForm = new DealershipForm();
        List<Field> fields = tempForm.getFields();
        // Populate HashMap with test data
        for(Field f: fields) {
            if(f.getName().equals("form_id")) {
                continue;
            }
            testData.put(f.getName(), "test");
        }
        DealershipForm testForm = new DealershipForm(testData);
        assertNotNull(testForm.getForm_id());
    }

    @Test
    public void testExistingDealershipFormInstantiation() throws Exception {
        HashMap<String, Object> testData = new HashMap<>();
        // Instantiate tempForm to get fields and construct test data
        DealershipForm tempForm = new DealershipForm();
        List<Field> fields = tempForm.getFields();
        // Populate HashMap with test data
        for(Field f: fields) {
            testData.put(f.getName(), "test");
        }
        DealershipForm testForm = new DealershipForm(testData);
        assertTrue(true);
    }

    @Test
    public void testDealershipFormInstantiationWithNullData() {
        HashMap<String, Object> testData = new HashMap<>();
        // Instantiate tempForm to get fields and construct test data
        DealershipForm tempForm = new DealershipForm();
        List<Field> fields = tempForm.getFields();
        // Populate HashMap with test data
        for(Field f: fields) {
            testData.put(f.getName(), null);
        }
        // Expected behavior = Exception thrown due to bad data (null)
        assertThrows(Exception.class, () -> new DealershipForm(testData));
    }

    @Test
    public void testDealershipFormInstantiationWithBadData() {
        HashMap<String, Object> testData = new HashMap<>();
        // Instantiate tempForm to get fields and construct test data
        DealershipForm tempForm = new DealershipForm();
        List<Field> fields = tempForm.getFields();
        // Populate HashMap with test data
        for(Field f: fields) {
            testData.put(f.getName(), 23);
        }
        // Expected behavior = Exception thrown due to bad data (int)
        assertThrows(Exception.class, () -> new DealershipForm(testData));
    }
}
