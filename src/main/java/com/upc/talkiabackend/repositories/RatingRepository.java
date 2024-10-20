package com.upc.talkiabackend.repositories;


import com.upc.talkiabackend.dtos.queries.ShowRatingByContentDTO;
import com.upc.talkiabackend.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {
  @Query("select new com.upc.talkiabackend.dtos.queries.ShowRatingByContentDTO(r.content.title, avg(r.score), r.content.year) from Rating r group by r.content.title, r.content.year order by avg(r.score) desc")
  public List<ShowRatingByContentDTO> listContentOrderByScore();

}
