package com.wizzCoachcorp.wizzcoach.repository;

import com.wizzCoachcorp.wizzcoach.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    List<Account> findByNameContaining(String search);
}
