package com.example.oyerickshawratingservice.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class RatingDTO {

    private String id;

    private int rating;

    private String objectId;

    private RatingType ratingType;

    private String createdBy;

    private Timestamp createdOn;

    private String modifiedBy;

    private Timestamp modifiedOn;

    private int version;

    private String rideId;

    private String raterId;

}
