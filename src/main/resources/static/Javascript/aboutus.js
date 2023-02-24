//

function ValidateEmail(inputText) {

console.log("About us");
  var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
  if (inputText.value.match(mailformat)) {
    alert("Valid email address!");
    document.form1.email.focus();
    return true;
  } else {
    alert("You have entered an invalid email address!");
    document.form1.email.focus();
    return false;
  }
}
