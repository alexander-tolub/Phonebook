$(document).ready( function () {
    $.getJSON(
        "/services/rest/getPhoneTypes",
        function (data) {
            phoneTypes = data;
            addContent();
        }
    )
} );

var phoneTypes;
var winCached = $(window),
    docCached = $(document);
var page = 0;


function addContent() {
    dettachScrollEvent();
    if (docCached.height() - winCached.height() < winCached.scrollTop() + 300) {
        $.ajax({
            dataType: "json",
            url: '/services/rest/getCustomers',
            data: { page: page },
            success: function (data) {
                if (!$.trim(data)){
                    return;
                }
                $.each(data, function (key, val) {
                    $('#phonebook tbody')
                        .append(
                            '<tr>' +
                                '<td>' + val.firstName + '</td>' +
                                '<td>' + val.lastName + '</td>' +
                                '<td>' + val.patronymic + '</td>' +
                                '<td contenteditable="true" oninput="saveField(this); setFieldIsValid((checkOnlyNumber(this) && checkNotEmpty(this)), this);" phoneNumberId="' + val.phoneNumber.phoneId + '">' + val.phoneNumber.phoneNumber + '</td>' +
                                '<td contenteditable="true" oninput="saveField(this); setFieldIsValid(checkNotEmpty(this), this);" phoneNumberId="' + val.phoneNumber.phoneId + '">' + val.phoneNumber.comment + '</td>' +
                                '<td><select oninput="saveSelect(this)" phoneNumberId="' + val.phoneNumber.phoneId + '">' + printPhoneOptions(phoneTypes, val.phoneNumber.phoneType) + '</select></td>' +
                            '</tr>');
                });
                page++;
                addContent();
            }
        });
    }
    attachScrollEvent();
}

function printPhoneOptions( data, selected ) {
    var result = "";
    data.forEach( function (phone, index) {
        if(new String(selected).valueOf() == new String(phone).valueOf())
        {
            result = result.concat('<option selected="selected" value="' + phone + '">' + phone.toLowerCase() + '</option>');
        } else {
            result = result.concat('<option value="' + phone + '">' + phone.toLowerCase() + '</option>');
        }

    });
    return result;
}

function attachScrollEvent() {
    winCached.scroll(addContent);
}

function dettachScrollEvent() {
    winCached.unbind('scroll', addContent);
}