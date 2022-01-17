class SwitchElement {
  constructor(id, parentId, onValue, offValue, label, required, placeholder, tooltip, columns, onChange, isHidden, isDisplay) {
    this.id = id;
    this.parentId = parentId;
    this.containerId = id + "-col";
    this.type = "SWITCH";
    this.onValue = onValue;
    this.offValue = offValue;
    this.label = label;
    this.required = required;
    this.placeholder = placeholder;
    this.tooltip = tooltip;
    this.columns = columns;
    this.onChange = onChange;
    this.isHidden = isHidden;
    this.isDisplay = isDisplay;
  }
}

export { SwitchElement };
