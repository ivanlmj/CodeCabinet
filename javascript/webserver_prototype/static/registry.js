function welcome() {
    alert("Welcome to User Registry");
};

function validateForm() {

    var empty_fields = false;
    var inputs = document.forms["form_user"].getElementsByTagName("input");

    for (index = 0; index < inputs.length; index++) {
        if (inputs[index].value == null || inputs[index].value == "") {
	    empty_fields = true;
	    break;
	}
    }

    if (empty_fields == true) {
        alert("Please, review empty fields.");
	return false;
    } else {
	return true;
    }

};
