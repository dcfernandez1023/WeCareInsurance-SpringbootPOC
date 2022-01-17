class InputElement {
  constructor(id,
    parentId,
    value,
    label,
    required,
    placeholder,
    tooltip,
    columns,
    onChange,
    isHidden,
    isDisplay
  ) {
    this.id = id;
    this.parentId = parentId;
    this.containerId = id + "-col";
    this.type = "INPUT";
    this.value = value;
    this.label = label;
    this.required = required;
    this.placeholder = placeholder;
    this.tooltip = tooltip;
    this.columns = columns;
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
    let inputElement = document.createElement("input");
    inputElement.id = this.id;
    inputElement.value = isSession && sessionData[this.id] === undefined ? sessionData[this.id] : this.value;
    inputElement.required = this.required;
    inputElement.placeholder = this.placeholder;
    inputElement.onchange = this.onChange;
    inputElement.classList.add("form-control");
    // Put it all together
    col.appendChild(label);
    col.appendChild(inputElement);
    document.getElementById(this.parentId).appendChild(col);
  }
}

export { InputElement };
