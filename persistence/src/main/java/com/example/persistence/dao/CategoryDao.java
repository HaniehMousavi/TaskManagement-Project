package com.example.persistence.dao;

import com.example.persistence.base.exception.CustomException;
import com.example.persistence.domain.Category;

import java.util.List;

public interface CategoryDao {
    Category save(Category entity);

    List<Category> getListCategory() throws CustomException;
}
