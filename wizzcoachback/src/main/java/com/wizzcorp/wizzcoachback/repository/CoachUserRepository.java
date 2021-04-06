package com.wizzcorp.wizzcoachback.repository;

import com.wizzcorp.wizzcoachback.model.CoachUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoachUserRepository extends JpaRepository <CoachUser , Integer> {
}
