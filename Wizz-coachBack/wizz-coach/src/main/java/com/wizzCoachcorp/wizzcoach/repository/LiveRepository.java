package com.wizzCoachcorp.wizzcoach.repository;

import com.wizzCoachcorp.wizzcoach.model.Live;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LiveRepository extends JpaRepository <Live, Integer > {
}
