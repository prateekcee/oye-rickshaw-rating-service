package com.example.oyerickshawratingservice;

import com.example.oyerickshawratingservice.Util.RatingObjectFactory;
import com.example.oyerickshawratingservice.repository.RatingRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static com.example.oyerickshawratingservice.dto.RatingType.PASSENGER;
import static com.example.oyerickshawratingservice.dto.RatingType.RIDE;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OyeRickshawRatingServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@DirtiesContext
public class IntegrationTestBase {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    RatingRepository ratingRepository;


    @Before
    public void setup() {

        setupRating();
    }

    private void setupRating() {

        ratingRepository.save(RatingObjectFactory.dummyRating(RIDE));
        Rating rating = RatingObjectFactory.dummyRating(PASSENGER);
        rating.setId(UUID.randomUUID().toString());
        ratingRepository.save(rating);

    }


    @After
    public void tearDown(){
        ratingRepository.deleteAll();
    }

}
