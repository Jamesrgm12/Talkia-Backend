package com.upc.talkiabackend.repositories;

import com.upc.talkiabackend.dtos.queries.ShowContentByFilterDTO;
import com.upc.talkiabackend.entities.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContentRepository extends JpaRepository<Content, Integer> {
  @Query("select new com.upc.talkiabackend.dtos.queries.ShowContentByFilterDTO(c.title, c.year) from Content c " +
    "join c.levels l where l.level = :level and c.theme =:theme")
  public List<ShowContentByFilterDTO>  listContentByLevelsAndTheme(@Param("level") String level, @Param("theme") String theme);
  @Query("select new com.upc.talkiabackend.dtos.queries.ShowContentByFilterDTO(c.title, c.year) from Content c " +
    "join c.levels l where l.level = :level and c.type =:type")
  public List<ShowContentByFilterDTO>  listContentByLevelsAndTypes(@Param("level") String level, @Param("type") String type);
  @Query("select new com.upc.talkiabackend.dtos.queries.ShowContentByFilterDTO(c.title, c.year) from Content c " +
    "join c.levels l where l.level = :level")
  public List<ShowContentByFilterDTO> listContentByLevels(@Param("level") String level);
}
