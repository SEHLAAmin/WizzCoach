package com.wizzcorp.wizzcoachback.repository;

import com.wizzcorp.wizzcoachback.model.Live;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LiveRepository extends JpaRepository<Live , Integer> {
List<Live> findLivesById(int id);
/*
List<Live> getLivesByCoachId(int id);
*/
}
