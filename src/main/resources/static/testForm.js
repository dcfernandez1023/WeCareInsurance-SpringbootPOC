const INPUT = "input";
const SELECT = "select";
const OPTION = "option";

const TEST_FORM_ELEMENTS = [
    {id: "name", label: "Name", element: INPUT, type: "text"},
    {id: "age", label: "Age", element: INPUT, type: "number"},
    {id: "email", label: "Email", element: INPUT, type: "text"},
    {id: "phone", label: "Phone", element: INPUT, type: "text"},
    {id: "company", label: "Company", element: INPUT, type: "text"},
    {id: "isEmployed", label: "Currently Employed", element: SELECT, type: "text", options: [
            {display: "Yes", value: "yes"},
            {display: "No", value: "no"}
        ]
    }
];

const renderTestFormInputs = (containerId) => {
    var container = document.getElementById(containerId);
    let row = document.createElement("div");
    row.classList.add("row");
    for(var i = 0; i < TEST_FORM_ELEMENTS.length; i++) {
        let elementMetaData = TEST_FORM_ELEMENTS[i];
        let element = null;
        if(elementMetaData.element === INPUT) {
            element = document.createElement(INPUT);
            element.id = elementMetaData.id;
            element.type = elementMetaData.type;
            element.classList.add("form-control");
        }
        else if(elementMetaData.element === SELECT) {
            element = document.createElement(SELECT);
            element.id = elementMetaData.id;
            element.type = elementMetaData.type;
            element.classList.add("form-select");
            for(var x = 0; x < elementMetaData.options.length; x++) {
              var option = document.createElement(OPTION);
              option.text = elementMetaData.options[x].display;
              option.value = elementMetaData.options[x].value;
              element.add(option, undefined);
            }
        }
        else {
            continue;
        }
        let label = document.createElement("label");
        label.innerHTML = elementMetaData.label;
        label.setAttribute("for", elementMetaData.id);
        label.style.marginBottom = "3px";
        let col = document.createElement("div");
        col.classList.add("col-md-6");
        col.style.marginTop = "8px";
        col.appendChild(label);
        col.appendChild(element);
        row.appendChild(col);
    }
    container.appendChild(row);
}

const onSubmit = () => {
    try {
        let data = {};
        for(var i = 0; i < TEST_FORM_ELEMENTS.length; i++) {
            let id = TEST_FORM_ELEMENTS[i].id;
            let element = document.getElementById(id);
            if(element === null) {
                alert("Error: Cannot find required input for: " + id);
                return;
            }
            if(element.value.trim().length == 0) {
                alert(id + " is required");
                return;
            }
            if(id === "isEmployed") {
                data[id] = element.value === "yes" ? true : false;
            }
            else {
                data[id] = element.value;
            }
        }
        console.log(data);
        var full = location.protocol+'//'+location.hostname+(location.port.toString().trim().length !== 0 ? ':'+location.port: '');
        axios.post(full + "/api/testForm/create", data)
            .then((res) => {
                alert("New form id: " + res.data);
            })
            .catch((error) => {
                alert("Error: " + error.response.data.message);
            });
    }
    catch(error) {
        alert("Error: " + error.message);
    }
}