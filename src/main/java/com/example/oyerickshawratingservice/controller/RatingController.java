package com.example.oyerickshawratingservice.controller;

import com.example.oyerickshawratingservice.common.RatingManager;
import com.example.oyerickshawratingservice.common.RideRatingManager;
import com.example.oyerickshawratingservice.dto.RatingDTO;
import com.example.oyerickshawratingservice.dto.RatingRequest;
import com.example.oyerickshawratingservice.dto.RatingsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Optional;

@RestController
public class RatingController {

    private static final String STRATEGY_PREFIX = "RM_";

    private Map<String, RatingManager> ratingManagerMap;

    private RideRatingManager ratingManager;

    @Autowired
    public RatingController(Map<String, RatingManager> ratingManagerMap, RideRatingManager ratingManager){
        this.ratingManagerMap = ratingManagerMap;
        this.ratingManager = ratingManager;
    }


    @PostMapping(value = "/v1/rating", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public RatingDTO rate(@RequestBody RatingRequest ratingRequest){

        return ratingManager.rate(ratingRequest);

    }

    @GetMapping(value = "/v1/rating", produces = MediaType.APPLICATION_JSON_VALUE)
    public RatingsResponse getRatings(@RequestParam("ratedObjectId") String ratedObjectId,
                                      @RequestParam("ratingType")String ratingType){

        return Optional.ofNullable(ratingManagerMap.get(STRATEGY_PREFIX+ratingType))
                .orElseThrow(InputMismatchException::new)
                .getAllRatings(ratedObjectId);

    }

}
