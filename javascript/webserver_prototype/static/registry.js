function welcome() {
    alert("Welcome to User Registry");
};

function validateForm() {
    let empty_field = false;

    let inputs = document.forms["form_user"].getElementsByTagName("input");
    for (index = 0; index < inputs.length; index++) {
        if (inputs[index].value == null || inputs[index].value == "") {
	    empty_field = true;
	    break;
	}
    }

    if (empty_field = true) {
        alert("Please, review empty fields.");
	return false;
    } else {
	return true;
    }

};
