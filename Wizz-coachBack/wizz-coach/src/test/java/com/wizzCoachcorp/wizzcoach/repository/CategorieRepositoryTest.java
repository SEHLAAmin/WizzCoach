package com.wizzCoachcorp.wizzcoach.repository;

import com.wizzCoachcorp.wizzcoach.model.Categorie;
import com.wizzCoachcorp.wizzcoach.repository.CategorieRepository;
import org.assertj.core.api.AbstractBigDecimalAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Locale;
@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CategorieRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CategorieRepository categorieRepository;

    @DisplayName("find categorie by name ")
    @Test
    public void findByNameContainingTest (){
        /*
        Categorie cateYoga = new Categorie(1 , "Yoga" , null);
        entityManager.persist(cateYoga);
        Categorie cateMuscu = new Categorie( 2 , "Muscu" , null);
        entityManager.persist(cateMuscu);


        //When
        Categorie selectCate = categorieRepository.findCategorieBylibelle("yoga");

        //THEN
       /* assertThat(selectCate. ) .isEqualTo("Yoga"); */

    }

}
