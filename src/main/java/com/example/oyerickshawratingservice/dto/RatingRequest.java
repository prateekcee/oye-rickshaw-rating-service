package com.example.oyerickshawratingservice.dto;

import lombok.Data;

@Data
public class RatingRequest {

    private RatingType ratingType;

    private String raterId;

    private String ratedObjectId;

    //rating will be related to one ride for sure
    private String rideId;

    private int rating;

    private String comments;

}
