class SelectElement {
  constructor(id, parentId, value, label, required, placeholder, tooltip, columns, options, onChange, isHidden, isDisplay) {
    this.id = id;
    this.parentId = parentId;
    this.containerId = id + "-col";
    this.type = "SELECT";
    this.value = value;
    this.label = label;
    this.required = required;
    this.placeholder = placeholder;
    this.tooltip = tooltip;
    this.columns = columns;
    this.options = options;
    this.onChange = onChange;
    this.isHidden = isHidden;
    this.isDisplay = isDisplay;
  }

  render(sessionData) {
    let isSession = (sessionData !== undefined && sessionData !== null);
    // Create column for element
    let col = document.createElement("div");
    col.id = this.containerId;
    col.classList.add("col-md-" + this.columns.toString());
    col.style.marginBottom = "12px";
    if(this.isHidden) {
      col.style.display = "none";
    }
    // Create label for element
    let label = document.createElement("label");
    label.setAttribute("for", this.id);
    label.innerHTML = this.label;
    label.style.marginBottom = "8px";
    // Create element
    let selectElement = document.createElement("select");
    selectElement.id = this.id;
    selectElement.value = isSession && sessionData[this.id] === undefined ? sessionData[this.id] : this.value;
    selectElement.required = this.required;
    selectElement.placeholder = this.placeholder;
    selectElement.onchange = this.onChange;
    // Add options to the select element
    for(var x = 0; x < this.options.length; x++) {
      var option = document.createElement("option");
      option.text = this.options[x].displayName;
      option.value = this.options[x].value;
      if(this.options[x].value === this.value) {
        option.selected = true;
      }
      selectElement.add(option, undefined);
    }
    selectElement.classList.add("form-select");
    // Put it all together
    col.appendChild(label);
    col.appendChild(selectElement);
    document.getElementById(this.parentId).appendChild(col);
  }
}

export { SelectElement };
