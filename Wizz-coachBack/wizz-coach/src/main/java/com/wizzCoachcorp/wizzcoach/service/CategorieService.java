package com.wizzCoachcorp.wizzcoach.service;

import com.wizzCoachcorp.wizzcoach.model.Categorie;
import com.wizzCoachcorp.wizzcoach.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface CategorieService {
    public Categorie findCategorieBylibelle(String libelle);

    @Service
    class CategorieServiceImpl {
        @Autowired
        CategorieRepository categorieRepository;

            public Categorie findCategorieBylibelle(String libelle){
          return  categorieRepository.findCategorieBylibelle(libelle);
            }
    }
}
