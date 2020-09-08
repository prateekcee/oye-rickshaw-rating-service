package com.example.oyerickshawratingservice;

import com.example.oyerickshawratingservice.dto.RatingRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static com.example.oyerickshawratingservice.dto.RatingType.RIDE;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class RatingControllerIT extends IntegrationTestBase{

    @Test
    public void createRating() throws Exception {

        RatingRequest ratingRequest = new RatingRequest();
        ratingRequest.setComments("comments");
        ratingRequest.setRaterId("rater_id");
        ratingRequest.setRating(4);
        ratingRequest.setRatedObjectId("object_id");
        ratingRequest.setRatingType(RIDE);
        ratingRequest.setRideId("ride_id");

        mockMvc.perform(post("/v1/rating")
                .content(asJsonString(ratingRequest))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    public void getAllRatings() throws Exception {

        mockMvc.perform(
                get("/v1/rating?ratedObjectId=object_id&ratingType=RIDE")
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.ratingDTOList", hasSize(1)))
                .andExpect(jsonPath("$.ratingDTOList.[0].rating", is(4)))
                .andExpect(jsonPath("$.ratingDTOList.[0].objectId", is("object_id")))
                .andExpect(jsonPath("$.ratingDTOList.[0].ratingType", is("RIDE")));
    }

}
