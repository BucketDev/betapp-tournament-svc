package com.bucketdev.betapptournamentsvc.repository;

import com.bucketdev.betapptournamentsvc.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
