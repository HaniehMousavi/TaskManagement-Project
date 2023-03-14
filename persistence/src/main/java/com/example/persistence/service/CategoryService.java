package com.example.persistence.service;

import com.example.persistence.base.exception.CustomException;
import com.example.persistence.domain.Category;

import java.util.List;

public interface CategoryService {

    Category create(Category entity);

    List<Category> getListCategory() throws CustomException;
}
