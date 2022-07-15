package com.narola.testspringboot.category.repository;

import com.narola.testspringboot.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category,Integer> {

}
