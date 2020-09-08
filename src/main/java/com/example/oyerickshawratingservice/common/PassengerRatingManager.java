package com.example.oyerickshawratingservice.common;

import com.example.oyerickshawratingservice.Util.ConverterUtil;
import com.example.oyerickshawratingservice.dto.RatingDTO;
import com.example.oyerickshawratingservice.dto.RatingType;
import com.example.oyerickshawratingservice.dto.RatingsResponse;
import com.example.oyerickshawratingservice.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.stream.Collectors;

@Component("RM_PASSENGER")
public class PassengerRatingManager extends RatingManager {

    @Autowired
    public PassengerRatingManager(RatingRepository ratingRepository) {
        super(ratingRepository);
    }

    @Override
    public RatingsResponse getAllRatings(String ratedObjectId) {
        RatingsResponse ratingsResponse = new RatingsResponse();
        ratingsResponse.setRatingDTOList(
               ratingRepository
                .findAllByRatingTypeAndObjectId(RatingType.PASSENGER, ratedObjectId)
                .stream()
                .map(r-> ConverterUtil.copyProperties(r,RatingDTO.class))
                .sorted(Comparator.comparing(RatingDTO::getCreatedOn))
                .collect(Collectors.toList()));

        return ratingsResponse;
    }
}
