package com.example.persistence.service;


import com.example.persistence.base.exception.CustomException;
import com.example.persistence.dao.CategoryDao;
import com.example.persistence.domain.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryDao entityDao;

    @Override
    public Category create(Category entity) {
        return entityDao.save(entity);
    }

    @Override
    public List<Category> getListCategory() throws CustomException {
        return entityDao.getListCategory();
    }
}
