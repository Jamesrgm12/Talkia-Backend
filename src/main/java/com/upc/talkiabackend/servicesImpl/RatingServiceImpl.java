package com.upc.talkiabackend.servicesImpl;

import com.upc.talkiabackend.dtos.queries.ShowRatingByContentDTO;
import com.upc.talkiabackend.entities.Content;
import com.upc.talkiabackend.entities.Rating;
import com.upc.talkiabackend.entities.User;
import com.upc.talkiabackend.repositories.ContentRepository;
import com.upc.talkiabackend.repositories.RatingRepository;
import com.upc.talkiabackend.repositories.UserRepository;
import com.upc.talkiabackend.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {
  @Autowired
  private RatingRepository ratingRepository;
  @Autowired
  private ContentRepository contentRepository;

  @Autowired
  private UserRepository userRepository;

  @Override
  @Transactional
  public Rating insertRating(int id_content, int id_user, int score){
    User user = userRepository.findById(id_user).get();
    Content content = contentRepository.findById(id_content).get();
    Rating rating = new Rating();
    rating.setUser(user);
    rating.setContent(content);
    rating.setScore(score);
    return ratingRepository.save(rating);
  }

}
