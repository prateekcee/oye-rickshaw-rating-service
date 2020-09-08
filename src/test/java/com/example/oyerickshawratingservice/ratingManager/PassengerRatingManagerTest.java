package com.example.oyerickshawratingservice.ratingManager;

import com.example.oyerickshawratingservice.entity.Rating;
import com.example.oyerickshawratingservice.Util.RatingObjectFactory;
import com.example.oyerickshawratingservice.common.PassengerRatingManager;
import com.example.oyerickshawratingservice.dto.RatingDTO;
import com.example.oyerickshawratingservice.dto.RatingsResponse;
import com.example.oyerickshawratingservice.repository.RatingRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.Timestamp;
import java.util.List;

import static com.example.oyerickshawratingservice.Util.RatingObjectFactory.OBJECT_ID;
import static com.example.oyerickshawratingservice.dto.RatingType.PASSENGER;
import static com.example.oyerickshawratingservice.dto.RatingType.RIDE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PassengerRatingManagerTest {

    @Mock
    private RatingRepository ratingRepository;

    @InjectMocks
    PassengerRatingManager passengerRatingManager = new PassengerRatingManager(ratingRepository);

    @Test
    public void test_getAllRating_success(){

        Rating rating = RatingObjectFactory.dummyRating(PASSENGER);

        Rating rating1 = RatingObjectFactory.dummyRating(PASSENGER);
        rating1.setCreatedOn(Timestamp.valueOf(rating.getCreatedOn().toLocalDateTime().plusDays(3)));

        when(ratingRepository.findAllByRatingTypeAndObjectId(any(),anyString())).
                thenReturn(newArrayList(rating, rating1));

        RatingsResponse ratingsResponse = passengerRatingManager.getAllRatings(OBJECT_ID);

        List<RatingDTO> ratingDTOList = ratingsResponse.getRatingDTOList();

        verify(ratingRepository,times(1)).findAllByRatingTypeAndObjectId(PASSENGER,OBJECT_ID);

        assertThat(ratingDTOList.size()).isEqualTo(2);
        assertThat(ratingDTOList.get(0)).isEqualToComparingFieldByField(rating1);
        assertThat(ratingDTOList.get(1)).isEqualToComparingFieldByField(rating);

    }

}
