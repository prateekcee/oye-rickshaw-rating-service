package com.example.oyerickshawratingservice.repository;

import com.example.oyerickshawratingservice.Rating;
import com.example.oyerickshawratingservice.dto.RatingType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, String> {

    List<Rating> findAllByRatingTypeAndObjectId(RatingType ratingType, String objectId);

}
