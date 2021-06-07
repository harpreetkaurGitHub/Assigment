# booking hotel

Instructions::

The BookingSQL.sql file in the resources folder contains the SQL Scripts for the database.
Run the Scripts in MySQL Workbench.

Import into Intellij idea as a Gradle Project and do a Gradle Install/Update.
Run the AssignmentApplication.java as a Java Application.
 
Since the Tomcat libraries are still there as dependancies we are able to run this application on it’s own.

The following features have been successfully implemented:

Search hotel by date/city,facilities like Wi-Fi,restaurant,air-condition,breakfast,etc

Service to add/update hotel information in the system.

Service to add/update user information in the system.

Service for a user to add reviews for a hotel. A review will include rating and reviews.

Delete information of a hotel, user or delete a review. The data associated with each hotel and user are also deleted accordingly.

All this information will be stored in an RDBMS like MySQL.

The following technologies have been used:

Java

MySQL

SpringBoot

Gradle

* GET Fetch All

http://localhost:8080/booking/customers

http://localhost:8080/booking/reviews

* GET Fetch by Id

http://localhost:8080/booking/hotel/{id}
--> get hotel by id

http://localhost:8080/booking/customer/{id}

http://localhost:8080/booking/review/{id}

* DELETE Delete by Id

http://localhost:8080/booking/customer/{id}

http://localhost:8080/booking/review/{id}

http://localhost:8080/booking/amenity/{id}

* POST With proper body as Input
This API is for search of hotel by filters
http://localhost:8080/booking/search/hotel
--> get all hotels by filter
{
"city":"delhi",
"airCondition":true,
"breakfast":true,
"restaurant":true,
  "date":"2021-07-10",
  "wifi":true
}

http://localhost:8080/booking/hotel
--> add hotel
{
"hotelId":5,
"hotelName":"Palm",
"hotelEmail":"palm@gmail.com",
"hotelAddress":" ",
"city":"Haryana",
"rating":3
}

http://localhost:8080/booking/customer
{
"customerName":"Happy",
"customerGender":"Fe-Male",
"customerDOB":"1998-11-03",
"customerBio":"enjoy life"
}

http://localhost:8080/booking/review

http://localhost:8080/booking/amenity
{
"amenityId":5,
"amenityRestaurant":false,
"amenityWifi":true,
"amenityAirconditioning":false,
"amenityBreakfast":true,
"amenityPool":false,
"amenityGym":false
}

http://localhost:8080/booking/reservation
{
"reservationDate":"2019-05-12",
"reservationCheckIn":"2019-06-10",
"reservationCheckOut":"2019-04-10",
"room":{
"roomId":2
},
"customer":{
"customerId":2
}


}

* PUT Update with proper body as Input

http://localhost:8080/booking/hotel
--> update hotel
{
"hotelId":5,
"hotelName":"Palm",
"hotelEmail":"palm@gmail.com",
"hotelAddress":" ",
"city":"Haryana",
"rating":3
}

http://localhost:8080/booking/customer
{
"customerId":4,
"customerName":"Happy",
"customerGender":"Fe-Male",
"customerDOB":"1998-11-03",
"customerBio":"enjoy life"
}

http://localhost:8080/booking/review

http://localhost:8080/booking/amenity
{
"amenityId":5,
"amenityRestaurant":false,
"amenityWifi":true,
"amenityAirconditioning":false,
"amenityBreakfast":true,
"amenityPool":false,
"amenityGym":false
}

