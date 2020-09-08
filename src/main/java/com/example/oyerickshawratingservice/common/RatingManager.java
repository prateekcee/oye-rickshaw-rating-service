package com.example.oyerickshawratingservice.common;

import com.example.oyerickshawratingservice.entity.Rating;
import com.example.oyerickshawratingservice.Util.ConverterUtil;
import com.example.oyerickshawratingservice.dto.RatingDTO;
import com.example.oyerickshawratingservice.dto.RatingRequest;
import com.example.oyerickshawratingservice.dto.RatingsResponse;
import com.example.oyerickshawratingservice.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public abstract class RatingManager {

    protected RatingRepository ratingRepository;

    @Autowired
    public RatingManager(RatingRepository ratingRepository){
        this.ratingRepository= ratingRepository;
    }


    public RatingDTO rate(RatingRequest ratingRequest) {
        Rating rating = ratingRepository.save(buildRating(ratingRequest));
        return ConverterUtil.copyProperties(rating, RatingDTO.class);
    }

    private Rating buildRating(RatingRequest ratingRequest){
        Rating rating = new Rating();
        rating.setId(UUID.randomUUID().toString());
        rating.setCreatedBy(ratingRequest.getRaterId());
        rating.setCreatedOn(Timestamp.valueOf(LocalDateTime.now()));
        rating.setRating(ratingRequest.getRating());
        rating.setObjectId(ratingRequest.getRatedObjectId());
        rating.setRatingType(ratingRequest.getRatingType());
        rating.setRideId(ratingRequest.getRideId());
        rating.setRaterId(ratingRequest.getRaterId());
        rating.setVersion(1);
        return rating;
    }

    public abstract RatingsResponse getAllRatings(String ratedObjectId);

}
