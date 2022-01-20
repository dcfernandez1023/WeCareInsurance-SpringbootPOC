# We Care Insurance - Insurance Programs
Application server for We Care Insurance's insurance programs.

## Project Structure
The back-end code for this project is divided into 4 packages:
- `controllers` (handles server requests)
- `dao` (<i>Data Access Object</i>; contains logic to execute server requests and interfaces with the `dal`)
- `models` (defines the structure for the data that this application uses)
- `dal` (<i>Data Access Layer</i>; allows the back-end to interface with a database)

<b>Driver</b> - The driver of this application is the `WeCareInsuranceApplication` class

<b>Unit Tests</b> - Unit tests are in `/src/test`

<b>Front-end</b>: Static HTML/JS/CSS files are served from `/src/main/resources`

## Model
### `TestForm`
<i>* This object is just for testing purposes</i>

    Fields:
        private String id;
        private String name;
        private int age;
        private String email;
        private String phone;
        private String company;
        private boolean isEmployed;
### `DealershipForm`
    Fields:
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

## REST API
### Test Form
### GET: `/api/testForm/get/{id}`
Queries and returns a JSON representation of the `TestForm` model object using the `id` url parameter.

--

### POST: `/api/testForm/create`
Creates a new TestForm object and inserts it into the database. Returns the id 
of the new TestForm upon success.

---

### DealershipForm
### GET: `/api/dealershipForm/get/{id}`
Queries and returns a JSON representation of the `DealershipForm` model object 
using the `id` url parameter.

--

### POST: `/api/dealershipForm/create`
Creates a new `DealershipForm` object and inserts it into the database. Returns a  
JSON representation of the new `DealershipForm` upon success.

<i> * All fields of the DealershipForm model object are required in
the request body, except <b>form_id</b></i>

--


### POST: `/api/dealershipForm/update/{id}`
Updates an existing `DealershipForm` object in the database using the `id` url parameter. Returns a  
JSON representation of the updated `DealershipForm` upon success.

<i> * All fields of the DealershipForm model object are required in
the request body</i>

---