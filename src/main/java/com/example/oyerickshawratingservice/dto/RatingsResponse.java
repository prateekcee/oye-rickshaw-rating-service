package com.example.oyerickshawratingservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class RatingsResponse {
    private List<RatingDTO> ratingDTOList;
}
