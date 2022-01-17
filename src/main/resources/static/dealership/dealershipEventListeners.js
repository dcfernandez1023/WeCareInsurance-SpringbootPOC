export const toggleAddress = () => {
  try {
    console.log("in here");
    var currAddressIds = [
      "street-col",
      "street2-col",
      "city-col",
      "state-col",
      "zip-col"
    ];
    var prevAddressIds = [
      "prev_street-col",
      "prev_street2-col",
      "prev_city-col",
      "prev_state-col",
      "prev_zip-col"
    ];
    var twoMonthElement = document.getElementById("is_two_month");
    if(twoMonthElement.value === "yes") {
      for(var i = 0; i < currAddressIds.length; i++) {
        var currId = currAddressIds[i];
        var prevId = prevAddressIds[i];
        document.getElementById(currId).style.display = "block";
        document.getElementById(prevId).style.display = "block";
      }
    }
    else if(twoMonthElement.value === "no") {
      for(var i = 0; i < currAddressIds.length; i++) {
        var currId = currAddressIds[i];
        var prevId = prevAddressIds[i];
        document.getElementById(currId).style.display = "block";
        document.getElementById(prevId).style.display = "none";
      }
    }
    else {
      for(var i = 0; i < currAddressIds.length; i++) {
        var currId = currAddressIds[i];
        var prevId = prevAddressIds[i];
        document.getElementById(currId).style.display = "none";
        document.getElementById(prevId).style.display = "none";
      }
    }
  }
  catch(error) {
    throw(error);
  }
}

const phoneFormat = (input) => {
  // Strip all characters from the input except digits
  input = input.replace(/\D/g,'');
  // Set the value of the REAL phone number input (which is hidden from the user)
  document.getElementById("phone").value = input;
  // Trim the remaining input to ten characters, to preserve phone number format
  input = input.substring(0,10);
  // Based upon the length of the string, we add formatting as necessary
  var size = input.length;
  if(size == 0) {
    input = input;
  }
  else if(size < 4) {
    input = '(' + input;
  }
  else if(size < 7) {
    input = '(' + input.substring(0, 3) + ') ' + input.substring(3, 6);
  }
  else {
    input = '(' + input.substring(0, 3)+') '+ input.substring(3, 6) + '-' + input.substring(6, 10);
  }
  document.getElementById("phone_facade").value = input;
}

const addPhoneEventListener = () => {
  try {
    document.getElementById("phone_facade").addEventListener("keyup", function(event) {
      var phoneNumber = document.getElementById('phone_facade');
      var charCode = (event.which) ? event.which : event.keyCode;
      phoneFormat(phoneNumber.value);
    });
    phoneFormat(document.getElementById("phone").value);
  }
  catch(error) {
    throw(error);
  }
}

export const eventListeners = [
  toggleAddress,
  addPhoneEventListener
];
