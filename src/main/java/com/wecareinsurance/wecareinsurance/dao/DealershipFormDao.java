package com.wecareinsurance.wecareinsurance.dao;

import com.wecareinsurance.wecareinsurance.dal.MySQLDataAccess;
import com.wecareinsurance.wecareinsurance.models.DealershipForm;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class DealershipFormDao extends BaseDao {
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "";
    private static final String DB_URL = "jdbc:mysql://localhost/dealership";
    private static final String TABLE = "DEALERSHIP_FORM";

    public DealershipFormDao() throws Exception {
        super();
    }

    public DealershipForm getForm(String id) throws Exception {
        List<HashMap<String, Object>> dealershipForms = this.db.get(String.format("SELECT * FROM " + TABLE + " WHERE form_id = '%s';", id));
        if(dealershipForms.size() != 1) {
            return null;
        }
        return new DealershipForm(dealershipForms.get(0));
    }

    // Creates a new form and returns its id upon success
    public DealershipForm createForm(HashMap<String, Object> newFormData) throws Exception {
        DealershipForm newForm = new DealershipForm(newFormData);
        List<Field> fields = newForm.getFields();
        // Build insert query
        StringBuilder sb = new StringBuilder("INSERT INTO " + TABLE + " VALUES (");
        for(int i = 0; i < fields.size(); i++) {
            Field f = fields.get(i);
            sb.append("'");
            sb.append(f.get(newForm));
            if(i < fields.size()-1) {
                sb.append("',");
            }
            else {
                sb.append("')");
            }
        }
        this.db.insertOrUpdate(sb.toString());
        return newForm;
    }

    // Updates a form and returns it upon success. @param updatedFormData must contain all fields of DealershipForm obj
    public DealershipForm updateForm(String id, HashMap<String, Object> updatedFormData) throws Exception {
        DealershipForm form = new DealershipForm(updatedFormData);
        List<Field> fields = form.getFields();
        // Build update query
        StringBuilder sb = new StringBuilder("UPDATE " + TABLE + " SET ");
        for(int i = 0; i < fields.size(); i++) {
            Field f = fields.get(i);
            // Avoid updating form_id
            if(f.getName().equals("form_id")) {
                continue;
            }
            sb.append(f.getName());
            sb.append(" = ");
            sb.append("'");
            sb.append(f.get(form));
            if(i < fields.size()-1) {
                sb.append("', ");
            }
            else {
                sb.append("' WHERE form_id = ");
                sb.append("'");
                sb.append(id);
                sb.append("'");
            }
        }
        this.db.insertOrUpdate(sb.toString());
        form.setForm_id(id); // ensure form_id remains consistent (in case caller erroneously tried to update the form_id)
        return form;
    }

    public String deleteForm(String id) throws Exception {
        String query = String.format("DELETE FROM " + TABLE + " WHERE form_id = '%s'", id);
        return this.db.delete(query, id);
    }

    @Override
    protected void initDb() throws SQLException, ClassNotFoundException {
        this.db = new MySQLDataAccess(DB_USERNAME, DB_PASSWORD, DB_URL);
    }
}
