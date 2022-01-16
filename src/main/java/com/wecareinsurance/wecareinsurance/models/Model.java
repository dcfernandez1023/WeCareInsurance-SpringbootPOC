package com.wecareinsurance.wecareinsurance.models;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;

public interface Model {
    // Method for model objects to convert itself to a HashMap. Used to facilitate sending data back in JSON format
    public HashMap<String, Object> toHashMap() throws IllegalAccessException;
    public List<Field> getFields();
}
