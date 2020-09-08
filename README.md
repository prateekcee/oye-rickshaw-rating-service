# oye-rickshaw-rating-service

Assumptions Made : 1. When a costumer rates a ride, that rating is the rating that the driver should see,( thats the drivers rating as well)

                   2. There are two types of ratings a) Passenger rating the Ride (rating of the driver) , b) Driver rating the passenger.
                   
                   3. when all ratings of a driver are to be fetched from the rating service, the rating service will be sent the driver_id as objectId and RIDE as rating type
                   
                   4. when all ratings of a passenger are to be fetched from rating service , the rating service will be sent the passenger_id as objectId and PASSENGER as                            rating type.
                   
                   5 Rating can be updated, hence a version and modified columns have been added.

Approach : 
               Took two types of ratings -> RIDE, PASSENGER.
               
               Ride rating has one to one map with Driver's Rating.
               
               Used Strategy Pattern using abstract class.
               
               Used abstract class instead of interface becuase the add rating algo will be same for RIDE as well as PASSENGER rating.
               
               Even the get rating could be made in the same class but for future there could be difference in logic for these tow ratings, hence strategy pattern.
               
               Getting all the ratings was a simple query to get ratings based on rating type(which rating) and object id( whose rating)
               
To run the application : Simply run this class : https://github.com/prateekcee/oye-rickshaw-rating-service/blob/master/src/main/java/com/example/oyerickshawratingservice/OyeRickshawRatingServiceApplication.java

after that the application runs on port 8081 on your machine.

have added the postman request in the repo as well.
 
here it is : https://github.com/prateekcee/oye-rickshaw-rating-service/blob/master/Rating%20Service.postman_collection.json



               
               
