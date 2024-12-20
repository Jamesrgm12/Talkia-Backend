package com.upc.talkiabackend.repositories;

import com.upc.talkiabackend.dtos.queries.ShowContentHistoryDTO;
import com.upc.talkiabackend.dtos.queries.ShowHistorialContentDTO;
import com.upc.talkiabackend.entities.UserContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserContentRepository extends JpaRepository<UserContent, Integer> {
    @Query("select new com.upc.talkiabackend.dtos.queries.ShowHistorialContentDTO(uc.user.name, uc.content.title, uc.iViewedAt)" +
            "from UserContent uc")
    List<ShowHistorialContentDTO> listUserContent();
    //Rol admin
    @Query("select new com.upc.talkiabackend.dtos.queries.ShowContentHistoryDTO(uc.user.name, uc.content.title, uc.iViewedAt)" +
            "from UserContent uc where uc.user.id = :userId")
    public List<ShowContentHistoryDTO> ListUserContentByUser(@Param("userId") int userId);
}
