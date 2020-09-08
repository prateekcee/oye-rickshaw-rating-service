package com.example.oyerickshawratingservice.Util;

import com.example.oyerickshawratingservice.entity.Rating;
import com.example.oyerickshawratingservice.dto.RatingRequest;
import com.example.oyerickshawratingservice.dto.RatingType;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static com.example.oyerickshawratingservice.dto.RatingType.RIDE;

public class RatingObjectFactory {

    public static final String OBJECT_ID = "object_id";

    public static final String RIDE_ID = "ride_id";

    public static final String CREATED_BY = "created_by";

    public static final Timestamp CREATED_ON = Timestamp.valueOf(LocalDateTime.now());

    public static final String ID = "42583d3e-ec09-4688-a7cd-dcd3474e9637";

    public static final String COMMENT = "ride was nice, Driver was polite";

    public static  RatingRequest getDummyRatingRequest(){
        RatingRequest ratingRequest = new RatingRequest();
        ratingRequest.setRideId(RIDE_ID);
        ratingRequest.setRatingType(RIDE);
        ratingRequest.setRatedObjectId(OBJECT_ID);
        ratingRequest.setRating(4);
        ratingRequest.setRaterId(CREATED_BY);
        ratingRequest.setComments(COMMENT);
        return  ratingRequest;
    }

    public static Rating dummyRating(RatingType ratingType){
        Rating rating = new Rating();
        rating.setObjectId(OBJECT_ID);
        rating.setId(ID);
        rating.setRating(4);
        rating.setVersion(0);
        rating.setCreatedBy(CREATED_BY);
        rating.setRatingType(ratingType);
        rating.setRideId(RIDE_ID);
        rating.setCreatedOn(CREATED_ON);
        rating.setRaterId(CREATED_BY);

        return rating;
    }


}
