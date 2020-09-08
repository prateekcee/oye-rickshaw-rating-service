package com.example.oyerickshawratingservice;

import com.example.oyerickshawratingservice.dto.RatingType;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
@Data
public class Rating {

    @Id
    private String id;

    private int rating;

    private String objectId;

    @Enumerated(EnumType.STRING)
    private RatingType ratingType;

    private String createdBy;

    private Timestamp createdOn;

    private String modifiedBy;

    private Timestamp modifiedOn;

    private int version;

    private String rideId;

    private String raterId;

}
