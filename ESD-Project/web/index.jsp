<%-- 
    Document   : index
    Created on : 09-Mar-2016, 16:52:19
    Author     : me-aydin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .logins {
                float: left;
                margin: 110px;
                padding: 15px;
                width: 300px;
                height: 300px;
                border: 1px solid black;
                border-radius: 25px;
                background-color: white; opacity: 0.8;     
            } 
            .logins:hover {
                opacity: 1.0;
                background-color: white;
            }   
        </style>
        <style>
            .logins2 {
                float: right;
                margin: 110px;
                padding: 15px;
                width: 500px;
                height: 300px;
                border: 1px solid black;
                border-radius: 25px;
                background-color: white; opacity: 0.8;

            } 
            .logins2:hover {
                opacity: 1.0;
                background-color: white; 
            }
        </style>
    </head>
    <body background = "${pageContext.request.contextPath}/resources/car.jpg" >
        <div class ="w3-container w3-blue w3-hover-light-blue">    
            <center>
                <h1>XYS Drivers Association </h1>
                <h1>Homepage</h1>
            </center>
        </div>


        <form action="UserLogin.do" method="post">
            <center>


                <div class ="logins">

                    User Sign in <br />
                    <br />
                    <br />
                    Username: <input type="text" name="id"><br />
                    <br />
                    Password: <input type="text" name="password" ><br />
                    <input type=submit value="Login"> <br />
                </div>           
        </form>



        <form action="NewUser.do" method="post">
            <div class ="logins2">

                Register as new user <br />
                <br />
                <br />
                FirstName   :<br /> <input type="text" name="firstname" ><br />
                LastName   :<br /> <input type="text" name="lastname" ><br />
                DOB    :<br /> <input type="date" name="dob" ><br />
                Address: <br />
                <div id="locationField">
                    <input id="autocomplete" placeholder="Enter your address"
                           onFocus="geolocate()" type="text" name = "address"></input>
                </div>
                <input type=submit value="Register"> <br />
                </center>
            </div>

        </form>

    </body>
</html>

<!DOCTYPE html>
<html>
    <head>
        <title>Place Autocomplete Address Form</title>
        <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
        <meta charset="utf-8">
        <style>
            /* Always set the map height explicitly to define the size of the div
             * element that contains the map. */
            #map {
                height: 100%;
            }
            /* Optional: Makes the sample page fill the window. */
            html, body {
                height: 100%;
                margin: 0;
                padding: 0;
            }
        </style>
        <link type="text/css" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500">
        <style>
            #locationField, #controls {
                position: relative;
                width: 480px;
            }
            #autocomplete {
                position: absolute;
                top: 0px;
                left: 0px;
                width: 99%;
            }
            .label {
                text-align: right;
                font-weight: bold;
                width: 100px;
                color: #303030;
            }
            #address {
                border: 1px solid #000090;
                background-color: #f0f0ff;
                width: 480px;
                padding-right: 2px;
            }
            #address td {
                font-size: 10pt;
            }
            .field {
                width: 99%;
            }
            .slimField {
                width: 80px;
            }
            .wideField {
                width: 200px;
            }
            #locationField {
                height: 20px;
                margin-bottom: 2px;
            }
        </style>
    </head>

    <body>
        
        <script>
            // This example displays an address form, using the autocomplete feature
            // of the Google Places API to help users fill in the information.

            // This example requires the Places library. Include the libraries=places
            // parameter when you first load the API. For example:
            // <script src="https://maps.googleapis.com/maps/api/js?key=YOUR_API_KEY&libraries=places">

            var placeSearch, autocomplete;
            var componentForm = {
                street_number: 'short_name',
                route: 'long_name',
                locality: 'long_name',
                administrative_area_level_1: 'short_name',
                country: 'long_name',
                postal_code: 'short_name'
            };

            function initAutocomplete() {
                // Create the autocomplete object, restricting the search to geographical
                // location types.
                autocomplete = new google.maps.places.Autocomplete(
                        /** @type {!HTMLInputElement} */(document.getElementById('autocomplete')),
                        {types: ['geocode']});

                // When the user selects an address from the dropdown, populate the address
                // fields in the form.
                autocomplete.addListener('place_changed', fillInAddress);
            }

            function fillInAddress() {
                // Get the place details from the autocomplete object.
                var place = autocomplete.getPlace();

                for (var component in componentForm) {
                    document.getElementById(component).value = '';
                    document.getElementById(component).disabled = false;
                }

                // Get each component of the address from the place details
                // and fill the corresponding field on the form.
                for (var i = 0; i < place.address_components.length; i++) {
                    var addressType = place.address_components[i].types[0];
                    if (componentForm[addressType]) {
                        var val = place.address_components[i][componentForm[addressType]];
                        document.getElementById(addressType).value = val;
                    }
                }
            }

            // Bias the autocomplete object to the user's geographical location,
            // as supplied by the browser's 'navigator.geolocation' object.
            function geolocate() {
                if (navigator.geolocation) {
                    navigator.geolocation.getCurrentPosition(function (position) {
                        var geolocation = {
                            lat: position.coords.latitude,
                            lng: position.coords.longitude
                        };
                        var circle = new google.maps.Circle({
                            center: geolocation,
                            radius: position.coords.accuracy
                        });
                        autocomplete.setBounds(circle.getBounds());
                    });
                }
            }
        </script>
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD0VEGYQmSNsPkevLc5PGSSEBv6N2yyo0k&libraries=places&callback=initAutocomplete"
        async defer></script>
    </body>
</html>
