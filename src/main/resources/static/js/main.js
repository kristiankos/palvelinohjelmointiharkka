var citylist;
var listCities;
var buttonAddCity;
var fieldCityName;




$(document).ready(function(){
    citylist = $("#citylist");
    listCities = $("#listCities");
    fieldCityName = $("#fieldCityName");
    buttonAddCity = $("#buttonAddCity");

    buttonAddCity.click(function(){
        addCity();
    });

    $('.table .eBtn').on('click', function (event) {
        loadCitiesForEdit();
        event.preventDefault();

        var href = $(this).attr('href');
        $.get(href, function(park, status){
            $('.saveForm #parkId').val(park.parkId);
            $('.saveForm #name').val(park.name);
            $('.saveForm #city').val(park.city.cityId);
        });

        $('.saveForm #exampleModal').modal();
    });

    $('.table .delBtn').on('click', function (event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#myModal #delRef').attr('href', href);
		$('#myModal').modal();

    });

});

//add city
function addCity(){
    url = "/cities/";
    cityName = fieldCityName.val();
    jsonData = {name: cityName};

    $.ajax({
        type: "POST",
        url: url,
        beforeSend: function(xhr) {
            xhr.setRequestHeader(csrfHeader, csrfToken);
        },

        data: JSON.stringify(jsonData),
        contentType: 'application/json'
    }).done(function() {
        loadCitiesList();
        fieldCityName.val("").focus();
    }).fail(function() {
        alert("failed");
    });

}

//for edit
function loadCitiesForEdit(){
    url = "/cities";

    $.get(url, function(responseJson){
        citylist.empty();

        $.each(responseJson, function(index, city) {
            
            $("<option>").val(city.cityId).text(city.name).appendTo(citylist);
        });

    }).done(function(){

       // alert('Toimii);
       

    }).fail(function(){
       // alert('Failed');

    });
}

//table 
function loadCitiesList(){
    url = "/cities";

    $.get(url, function(responseJson){
        listCities.empty();

        $.each(responseJson, function(index, city) {
                $tr = $('<tr>').append(
                $('<td>').text(city.cityId),
                $('<td>').text(city.name)
            ).appendTo(listCities);
        });

    }).done(function(){

       // alert('Done');
       

    }).fail(function(){
       // alert('Failed');

    });
}








