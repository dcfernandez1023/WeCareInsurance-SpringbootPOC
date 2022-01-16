package com.wecareinsurance.wecareinsurance.models;

import java.lang.reflect.Field;
import java.util.*;

public class DealershipForm implements Model {
    private String form_id;
    private String referee_name;
    private String referee_company;
    private String email;
    private String phone;
    private String residence_type;
    private String liability_coverage;
    private String is_two_month;
    private String street;
    private String street_2;
    private String city;
    private String state;
    private String zip;
    private String prev_street;
    private String prev_street_2;
    private String prev_city;
    private String prev_state;
    private String prev_zip;
    private String vin;
    private String annual_mileage;
    private String deductible;
    private String is_road_side_chcked;
    private String is_rental;
    private String lienholder_email;
    private String lienholder_name;
    private String lienholder_address_1;
    private String get_lienholder_address_2;
    private String lienholder_city;
    private String lienholder_state;
    private String lienholder_zip;
    private String additional_insured_name;
    private String additional_insured_address_1;
    private String get_additional_insured_address_2;
    private String additional_insured_city;
    private String additional_insured_state;
    private String additional_insured_zip;
    private String driver_first_name;
    private String driver_last_name;
    private String driver_dob;
    private String driver_gender;
    private String driver_marital_status;
    private String driver_occupation;
    private String driver_education;
    private String driver_years_licensed;
    private String driver_license_number;
    private String driver_state;
    private String is_state_filing;

    public DealershipForm() {}

    // Instantiates a new DealershipForm if @param data contains all the correct fields
    public DealershipForm(HashMap<String, Object> data) throws Exception {
        List<Field> fields = this.getFields();
        boolean isNewForm = data.get("form_id") == null;
        // If new form, assign a unique id
        if(isNewForm) {
            this.form_id = UUID.randomUUID().toString();
        }
        // Loop through this object's fields and ensure the 'data' argument contains all of this object's fields
        for(Field f: fields) {
            f.setAccessible(true);
            String name = f.getName();
            Object value = data.get(name);
            // Skip over "form_id" field if it is a new form
            if(name.equals("form_id") && isNewForm) {
                continue;
            }
            if(value == null) {
                throw new Exception(name + " cannot be null");
            }
            try {
                // Will throw exception if field cannot get set
                f.set(this, value);
            }
            catch(SecurityException | IllegalAccessException | IllegalArgumentException e) {
                throw(e);
            }
            catch(Exception e) {
                throw new Exception(name + " is missing or is not a valid data type");
            }
        }
    }

    @Override
    public HashMap<String, Object> toHashMap() throws IllegalAccessException {
        HashMap<String, Object> map = new HashMap<>();
        List<Field> fields = this.getFields();
        for(Field f: fields) {
            map.put(f.getName(), f.get(this));
        }
        return map;
    }

    @Override
    public List<Field> getFields() {
        Field[] fields = this.getClass().getDeclaredFields();
        return Arrays.asList(fields);
    }

    public String getForm_id() {
        return form_id;
    }

    public void setForm_id(String form_id) {
        this.form_id = form_id;
    }

    public String getReferee_name() {
        return referee_name;
    }

    public void setReferee_name(String referee_name) {
        this.referee_name = referee_name;
    }

    public String getReferee_company() {
        return referee_company;
    }

    public void setReferee_company(String referee_company) {
        this.referee_company = referee_company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getResidence_type() {
        return residence_type;
    }

    public void setResidence_type(String residence_type) {
        this.residence_type = residence_type;
    }

    public String getLiability_coverage() {
        return liability_coverage;
    }

    public void setLiability_coverage(String liability_coverage) {
        this.liability_coverage = liability_coverage;
    }

    public String isIs_two_month() {
        return is_two_month;
    }

    public void setIs_two_month(String is_two_month) {
        this.is_two_month = is_two_month;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreet_2() {
        return street_2;
    }

    public void setStreet_2(String street_2) {
        this.street_2 = street_2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPrev_street() {
        return prev_street;
    }

    public void setPrev_street(String prev_street) {
        this.prev_street = prev_street;
    }

    public String getPrev_street_2() {
        return prev_street_2;
    }

    public void setPrev_street_2(String prev_street_2) {
        this.prev_street_2 = prev_street_2;
    }

    public String getPrev_city() {
        return prev_city;
    }

    public void setPrev_city(String prev_city) {
        this.prev_city = prev_city;
    }

    public String getPrev_state() {
        return prev_state;
    }

    public void setPrev_state(String prev_state) {
        this.prev_state = prev_state;
    }

    public String getPrev_zip() {
        return prev_zip;
    }

    public void setPrev_zip(String prev_zip) {
        this.prev_zip = prev_zip;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getAnnual_mileage() {
        return annual_mileage;
    }

    public void setAnnual_mileage(String annual_mileage) {
        this.annual_mileage = annual_mileage;
    }

    public String getDeductible() {
        return deductible;
    }

    public void setDeductible(String deductible) {
        this.deductible = deductible;
    }

    public String isIs_road_side_chcked() {
        return is_road_side_chcked;
    }

    public void setIs_road_side_chcked(String is_road_side_chcked) {
        this.is_road_side_chcked = is_road_side_chcked;
    }

    public String isIs_rental() {
        return is_rental;
    }

    public void setIs_rental(String is_rental) {
        this.is_rental = is_rental;
    }

    public String getLienholder_email() {
        return lienholder_email;
    }

    public void setLienholder_email(String lienholder_email) {
        this.lienholder_email = lienholder_email;
    }

    public String getLienholder_name() {
        return lienholder_name;
    }

    public void setLienholder_name(String lienholder_name) {
        this.lienholder_name = lienholder_name;
    }

    public String getLienholder_address_1() {
        return lienholder_address_1;
    }

    public void setLienholder_address_1(String lienholder_address_1) {
        this.lienholder_address_1 = lienholder_address_1;
    }

    public String getGet_lienholder_address_2() {
        return get_lienholder_address_2;
    }

    public void setGet_lienholder_address_2(String get_lienholder_address_2) {
        this.get_lienholder_address_2 = get_lienholder_address_2;
    }

    public String getLienholder_city() {
        return lienholder_city;
    }

    public void setLienholder_city(String lienholder_city) {
        this.lienholder_city = lienholder_city;
    }

    public String getLienholder_state() {
        return lienholder_state;
    }

    public void setLienholder_state(String lienholder_state) {
        this.lienholder_state = lienholder_state;
    }

    public String getLienholder_zip() {
        return lienholder_zip;
    }

    public void setLienholder_zip(String lienholder_zip) {
        this.lienholder_zip = lienholder_zip;
    }

    public String getAdditional_insured_name() {
        return additional_insured_name;
    }

    public void setAdditional_insured_name(String additional_insured_name) {
        this.additional_insured_name = additional_insured_name;
    }

    public String getAdditional_insured_address_1() {
        return additional_insured_address_1;
    }

    public void setAdditional_insured_address_1(String additional_insured_address_1) {
        this.additional_insured_address_1 = additional_insured_address_1;
    }

    public String getGet_additional_insured_address_2() {
        return get_additional_insured_address_2;
    }

    public void setGet_additional_insured_address_2(String get_additional_insured_address_2) {
        this.get_additional_insured_address_2 = get_additional_insured_address_2;
    }

    public String getAdditional_insured_city() {
        return additional_insured_city;
    }

    public void setAdditional_insured_city(String additional_insured_city) {
        this.additional_insured_city = additional_insured_city;
    }

    public String getAdditional_insured_state() {
        return additional_insured_state;
    }

    public void setAdditional_insured_state(String additional_insured_state) {
        this.additional_insured_state = additional_insured_state;
    }

    public String getAdditional_insured_zip() {
        return additional_insured_zip;
    }

    public void setAdditional_insured_zip(String additional_insured_zip) {
        this.additional_insured_zip = additional_insured_zip;
    }

    public String getDriver_first_name() {
        return driver_first_name;
    }

    public void setDriver_first_name(String driver_first_name) {
        this.driver_first_name = driver_first_name;
    }

    public String getDriver_last_name() {
        return driver_last_name;
    }

    public void setDriver_last_name(String driver_last_name) {
        this.driver_last_name = driver_last_name;
    }

    public String getDriver_dob() {
        return driver_dob;
    }

    public void setDriver_dob(String driver_dob) {
        this.driver_dob = driver_dob;
    }

    public String getDriver_gender() {
        return driver_gender;
    }

    public void setDriver_gender(String driver_gender) {
        this.driver_gender = driver_gender;
    }

    public String getDriver_marital_status() {
        return driver_marital_status;
    }

    public void setDriver_marital_status(String driver_marital_status) {
        this.driver_marital_status = driver_marital_status;
    }

    public String getDriver_occupation() {
        return driver_occupation;
    }

    public void setDriver_occupation(String driver_occupation) {
        this.driver_occupation = driver_occupation;
    }

    public String getDriver_education() {
        return driver_education;
    }

    public void setDriver_education(String driver_education) {
        this.driver_education = driver_education;
    }

    public String getDriver_years_licensed() {
        return driver_years_licensed;
    }

    public void setDriver_years_licensed(String driver_years_licensed) {
        this.driver_years_licensed = driver_years_licensed;
    }

    public String getDriver_license_number() {
        return driver_license_number;
    }

    public void setDriver_license_number(String driver_license_number) {
        this.driver_license_number = driver_license_number;
    }

    public String getDriver_state() {
        return driver_state;
    }

    public void setDriver_state(String driver_state) {
        this.driver_state = driver_state;
    }

    public String isIs_state_filing() {
        return is_state_filing;
    }

    public void setIs_state_filing(String is_state_filing) {
        this.is_state_filing = is_state_filing;
    }
}
