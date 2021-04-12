package com.wizzcorp.wizzcoachback.repository;

import com.wizzcorp.wizzcoachback.model.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoryRepository extends PagingAndSortingRepository <Category, Long> {

}
