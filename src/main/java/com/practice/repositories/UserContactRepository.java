package com.practice.repositories;

import com.practice.models.UserContacts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserContactRepository extends JpaRepository<UserContacts, Integer> {
}
