package com.wecareinsurance.wecareinsurance.dao;

import com.wecareinsurance.wecareinsurance.dal.DatabaseAccess;
import com.wecareinsurance.wecareinsurance.dal.MySQLDataAccess;
import com.wecareinsurance.wecareinsurance.models.TestForm;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class TestFormDao {
    // Note: this is just for testing, but these should really be in a config file or environment variables
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "";
    private static final String DB_URL = "jdbc:mysql://localhost/dealership";
    private static final String TABLE = "TEST_FORMS";
    private static final String TRUE = "TRUE";
    private static final String FALSE = "FALSE";

    private DatabaseAccess db;

    public TestFormDao() throws SQLException, ClassNotFoundException {
        this.db = new MySQLDataAccess(DB_USERNAME, DB_PASSWORD, DB_URL);
    }

    public HashMap<String, Object> getTestForm(String id) throws Exception {
        List<HashMap<String, Object>> testForms = this.db.get(String.format("SELECT * FROM " + TABLE + " WHERE ID = '%s';", id));
        /*
         * Size should equal exactly one (and if the SQL table is created with PRIMARY KEY constraint on id, then this
           should always be 1)
       */
        if(testForms.size() != 1) {
            return new HashMap<String, Object>();
        }
        return testForms.get(0);
    }

    public String createNewTestForm(String name, int age, String email, String phone, String company, boolean isEmployed) throws Exception {
        TestForm tf = new TestForm(name, age, email, phone, company, isEmployed);
        String values = String.format("('%1$s', '%2$s', %3$d, '%4$s', '%5$s', '%6$s', %7$s);", tf.getId(), name, age, email, phone, company, (isEmployed ? TRUE : FALSE));
        String query = "INSERT INTO " + TABLE + " VALUES " + values;
        this.db.insertOrUpdate(query);
        return tf.getId();
    }
}
