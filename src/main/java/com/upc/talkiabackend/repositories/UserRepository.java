package com.upc.talkiabackend.repositories;

import com.upc.talkiabackend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUserName(String username);
    User getUserById(int userId);
    @Query("select u from User u where u.iCreatedAt between :startDate and :endDate")
    List<User> listUsersByRegisterDate(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);
    @Query("select sh.user from SuscriptionsHistory sh " +
            "where (:status = 'Activado' and sh.status = 'Activado' and sh.endDate >= current date) " +
            "or (:status = 'Finalizado' and sh.status = 'Finalizado' and sh.endDate < current date " +
            "and not exists ( " +
            "    select 1 from SuscriptionsHistory sh2 " +
            "    where sh2.user = sh.user and sh2.status = 'Activado' and sh2.endDate>=current date" +
            "))")
    List<User> listUsersByStatus(@Param("status") String status);
    List<User> getUserByUserNameContains(String username);

}
