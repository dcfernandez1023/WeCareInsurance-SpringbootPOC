package com.wecareinsurance.wecareinsurance;

import com.wecareinsurance.wecareinsurance.models.DealershipForm;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;

public class TestHelper {
    public static HashMap<String, Object> getDealershipFormTestData(boolean withId, Object testValue) {
        HashMap<String, Object> testData = new HashMap<>();
        // Instantiate tempForm to get fields and construct test data
        DealershipForm tempForm = new DealershipForm();
        List<Field> fields = tempForm.getFields();
        // Populate HashMap with test data
        for(Field f: fields) {
            if(f.getName().equals("form_id") && !withId) {
                continue;
            }
            testData.put(f.getName(), testValue);
        }
        return testData;
    }
}
