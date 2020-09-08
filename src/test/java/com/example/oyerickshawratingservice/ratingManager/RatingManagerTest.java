package com.example.oyerickshawratingservice.ratingManager;

import com.example.oyerickshawratingservice.entity.Rating;
import com.example.oyerickshawratingservice.common.RatingManager;
import com.example.oyerickshawratingservice.common.RideRatingManager;
import com.example.oyerickshawratingservice.dto.RatingDTO;
import com.example.oyerickshawratingservice.repository.RatingRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.example.oyerickshawratingservice.Util.RatingObjectFactory.dummyRating;
import static com.example.oyerickshawratingservice.Util.RatingObjectFactory.getDummyRatingRequest;
import static com.example.oyerickshawratingservice.dto.RatingType.RIDE;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class RatingManagerTest {

    @Mock
    RatingRepository ratingRepository;

    @Captor
    ArgumentCaptor<Rating> ratingArgumentCaptor;

    @InjectMocks
    private RatingManager ratingManager = new RideRatingManager(ratingRepository);

    @Test
    public void test_RateSuccess(){

        Rating expectedRating = dummyRating(RIDE);

        when(ratingRepository.save(any(Rating.class))).thenReturn(expectedRating);

        RatingDTO actualRatingDTO = ratingManager.rate(getDummyRatingRequest());

        verify(ratingRepository,times(1)).save(ratingArgumentCaptor.capture());

        Assertions.assertThat(actualRatingDTO).isEqualToComparingFieldByField(expectedRating);

    }


}
