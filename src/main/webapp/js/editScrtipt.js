var phones = {};
var wrongFields = [];
var WebServiceUrl = '/services/rest/updatePhones';
var edited = [];

function saveField(editableObj) {
    edited.push(editableObj);
    editableObj.style.backgroundColor  = "#ffff66";
    phones[editableObj.getAttribute("phoneNumberId")] = {
        phoneId:parseInt(editableObj.getAttribute("phoneNumberId")),
        phoneType:editableObj.parentElement.childNodes[5].firstElementChild.options[editableObj.parentElement.childNodes[5].firstElementChild.selectedIndex].value,
        comment:editableObj.parentElement.childNodes[4].textContent,
        phoneNumber:editableObj.parentElement.childNodes[3].textContent
    };
}
function saveSelect(editableObj) {
    edited.push(editableObj.parentElement);
    editableObj.parentElement.style.backgroundColor  = "#ffff66";
    phones[editableObj.getAttribute("phoneNumberId")] = {
        phoneId:parseInt(editableObj.getAttribute("phoneNumberId")),
        phoneType:editableObj.parentElement.parentElement.childNodes[5].firstElementChild.options[editableObj.parentElement.parentElement.childNodes[5].firstElementChild.selectedIndex].value,
        comment:editableObj.parentElement.parentElement.childNodes[4].textContent,
        phoneNumber:editableObj.parentElement.parentElement.childNodes[3].textContent
    };
}

function upload() {
    var array = $.map(phones, function(value, index) {
        return [value];
    });
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    $.ajax({
        type: "PUT",
        contentType: "application/json; charset=utf-8",
        url: WebServiceUrl,
        headers: {
            [header]:token,
            'Content-Type':'application/json'
        },
        data: JSON.stringify(array),
        dataType: "json",
        success: function (msg) {
            // console.log(msg);
            edited.forEach(function (element) {
                element.style.backgroundColor = "white";
            })
        },
        error: function (err){
            console.log(msg);
        }
    });
}

function checkOnlyNumber( data ) {
    if (isNaN(data.textContent)) {
        return false;
    } else {
        return true;
    }

}

function checkNotEmpty ( data ) {
    if (data.textContent) {
        return true;
    } else {
        return false;
    }
}

function setFieldIsValid( isValid, element ) {

    if (isValid) {
        wrongFields = wrongFields.filter(function (e) {
            return e !== element;
        });
        if(!(wrongFields.length > 0)) {
            document.getElementById("upload").onclick = upload;
        }
    } else {
        wrongFields.push(element);
        document.getElementById("upload").onclick = function() {
            alert("Fill all fields correctly.")
        };
        element.style.backgroundColor  = "#FFB6C1";
    }
}