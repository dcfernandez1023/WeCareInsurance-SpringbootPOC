# We Care Insurance SpringBoot Test
A test SpringBoot application to serve as a proof-of-concept (POC)
for switching to SpringBoot as our back-end.

## Project Structure
The back-end code for this project is divided into 4 packages:
- `controllers` (handles server requests)
- `dao` (<i>Data Access Object</i>; contains logic to handle server requests and interfaces with the `dal`)
- `models` (defines the structure for the data that this application uses)
- `dal` (<i>Data Access Layer</i>; allows the back-end to interface with a database)

The driver of this application is the `WeCareInsuranceApplication` class

Static HTML/JS/CSS files are served from `/src/main/resources`

## Model
### `TestForm`
    Fields:
        private String id;
        private String name;
        private int age;
        private String email;
        private String phone;
        private String company;
        private boolean isEmployed;

## API
### `/api/testForm/get/{id}`
Queries and returns a JSON representation of the `TestForm` model object using the `id` url parameter.

---

### `/api/testForm/create`
Creates a new TestForm object and inserts it into the database. Returns the id 
of the new TestForm upon success.
