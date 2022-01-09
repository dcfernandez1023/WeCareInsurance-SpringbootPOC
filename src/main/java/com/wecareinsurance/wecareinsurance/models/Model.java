package com.wecareinsurance.wecareinsurance.models;

import java.util.HashMap;

public interface Model {
    // Method for model objects to convert itself to a HashMap. Used to facilitate sending data back in JSON format
    public HashMap<String, Object> toHashMap();
}
