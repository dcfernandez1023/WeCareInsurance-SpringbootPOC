import { getSessionVar } from "../js/sessionStorageHelper.js";
import { dealershipElements } from "./dealershipFormData.js";
import { FormElementFactory } from "../js/models/FormElementFactory.js";
import { eventListeners } from "./dealershipEventListeners.js";

class DealershipFormRenderer {
  // Place any eventListeners that need to be set on the window in the constructor
  constructor(eventListeners) {
  }

  renderElements() {
    let sessionData = getSessionVar("dealershipForm");
    sessionData = sessionData !== null ? sessionData = JSON.parse(sessionData) : null;
    let factory = new FormElementFactory();
    for(var i = 0; i < dealershipElements.length; i++) {
      let metadata = dealershipElements[i];
      let elementObj = factory.getFormElement(metadata.type, metadata);
      elementObj.render(sessionData);
    }
  }

  loadEventListeners() {
    document.addEventListener("DOMContentLoaded", (event) => {
      for(var i = 0; i < eventListeners.length; i++) {
        let func = eventListeners[i];
        func();
      }
    });
  }
}

export { DealershipFormRenderer };
