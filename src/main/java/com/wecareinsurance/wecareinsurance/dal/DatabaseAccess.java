package com.wecareinsurance.wecareinsurance.dal;

import java.util.HashMap;
import java.util.List;

public interface DatabaseAccess {
    // Gets the connection object to the database server
    public Object getConnection();
    // Queries records from database given a query and returns the records as a List of HashMaps
    public List<HashMap<String, Object>> get(String query) throws Exception;
    // Manipulates (insert, update, delete) data from database given a query
    public void manipulateData(String query) throws Exception;
}
