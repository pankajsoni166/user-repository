package com.pramati.userservice.repository;

import com.pramati.userservice.model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<MyUser, Long> {

}
