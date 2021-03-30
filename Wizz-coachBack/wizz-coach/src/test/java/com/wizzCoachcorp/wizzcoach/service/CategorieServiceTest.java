package com.wizzCoachcorp.wizzcoach.service;

import com.wizzCoachcorp.wizzcoach.model.Categorie;
import com.wizzCoachcorp.wizzcoach.repository.CategorieRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CategorieServiceTest {

    @Mock
    CategorieRepository repository;
    @InjectMocks
    CategorieService service = (CategorieService) new CategorieService.CategorieServiceImpl();

    @BeforeEach
    public void init () {
        MockitoAnnotations.initMocks(this);
    }

    @DisplayName("find all cate")
    @Test
    public void findAllTest() {


    }
}
