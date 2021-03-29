package com.wizzCoachcorp.wizzcoach.repository;

import com.wizzCoachcorp.wizzcoach.model.Categorie;
import com.wizzCoachcorp.wizzcoach.model.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategorieRepository extends PagingAndSortingRepository<Categorie, Integer> {

     Categorie findCategorieBylibelle(String libelle);
}
