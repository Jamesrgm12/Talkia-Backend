package com.upc.talkiabackend.repositories;

import com.upc.talkiabackend.dtos.queries.AveragePointsLevelDTO;
import com.upc.talkiabackend.dtos.queries.QuizzesPerLevelDTO;
import com.upc.talkiabackend.entities.Level;
import com.upc.talkiabackend.entities.Question;
import com.upc.talkiabackend.entities.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Integer> {
    @Query("select q from Quiz q where q.user.id=:userId")
    public List<Quiz> listQuizzesByUserId(@Param("userId") int userId);
    @Query("select new com.upc.talkiabackend.dtos.queries.AveragePointsLevelDTO(avg(q.totalPoints), le.level) " +
            "from Quiz q JOIN User u on q.user.id= u.id JOIN Level le  on u.level.id=le.id group by le.level ")
    public List<AveragePointsLevelDTO> listAveragePoints();

    @Query("select new com.upc.talkiabackend.dtos.queries.QuizzesPerLevelDTO(count(q.id), le.level) " +
            "from Quiz q JOIN User u on q.user.id= u.id JOIN Level le  on u.level.id=le.id group by le.level ")
    public List<QuizzesPerLevelDTO> listQuizzesPerLevel();
}
