import { InputElement } from "./InputElement.js";
import { SelectElement } from "./SelectElement.js";
import { SwitchElement } from "./SwitchElement.js";

class FormElementFactory {
  getFormElement(type, metadata) {
    if(type === "INPUT") {
      return new InputElement(
        metadata.id,
        metadata.parentId,
        metadata.value,
        metadata.label,
        metadata.required,
        metadata.placeholder,
        metadata.tooltip,
        metadata.columns,
        metadata.onChange,
        metadata.isHidden,
        metadata.isDisplay
      );
    }
    else if(type === "SELECT") {
      return new SelectElement(
        metadata.id,
        metadata.parentId,
        metadata.value,
        metadata.label,
        metadata.required,
        metadata.placeholder,
        metadata.tooltip,
        metadata.columns,
        metadata.options,
        metadata.onChange,
        metadata.isHidden,
        metadata.isDisplay
      );
    }
    else if(type === "SWITCH") {
      return new SwitchElement(
        metadata.id,
        metadata.parentId,
        metadata.onValue,
        metadata.offValue,
        metadata.label,
        metadata.required,
        metadata.placeholder,
        metadata.tooltip,
        metadata.columns,
        metadata.onChange,
        metadata.isHidden,
        metadata.isDisplay
      );
    }
    return null;
  }
}

export { FormElementFactory };
