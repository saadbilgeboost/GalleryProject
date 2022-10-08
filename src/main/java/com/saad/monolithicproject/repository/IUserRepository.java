package com.saad.monolithicproject.repository;

import com.saad.monolithicproject.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    @Query("select COUNT(u)>0 from User u where UPPER(u.username)=UPPER(?1) and u.password=?2")
    Boolean isExistUser(String username,String password);
    Optional<User> findOptionalByUsernameAndPassword(String username, String password);
}
