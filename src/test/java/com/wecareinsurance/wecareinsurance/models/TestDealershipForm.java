package com.wecareinsurance.wecareinsurance.models;

import com.wecareinsurance.wecareinsurance.TestHelper;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class TestDealershipForm {
    @Test
    public void testNewDealershipFormInstantiation() throws Exception {
        HashMap<String, Object> testData = TestHelper.getDealershipFormTestData(false, "test");
        DealershipForm testForm = new DealershipForm(testData);
        assertNotNull(testForm.getForm_id());
    }

    @Test
    public void testExistingDealershipFormInstantiation() throws Exception {
        HashMap<String, Object> testData = TestHelper.getDealershipFormTestData(true, "test");
        DealershipForm testForm = new DealershipForm(testData);
        assertTrue(true);
    }

    @Test
    public void testDealershipFormInstantiationWithNullData() {
        HashMap<String, Object> testData = TestHelper.getDealershipFormTestData(true, null);
        // Expected behavior = Exception thrown due to bad data (null)
        assertThrows(Exception.class, () -> new DealershipForm(testData));
    }

    @Test
    public void testDealershipFormInstantiationWithBadData() {
        HashMap<String, Object> testData = TestHelper.getDealershipFormTestData(true, 23);
        // Expected behavior = Exception thrown due to bad data (int)
        assertThrows(Exception.class, () -> new DealershipForm(testData));
    }
}
