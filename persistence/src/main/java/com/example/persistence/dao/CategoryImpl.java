package com.example.persistence.dao;

import com.example.persistence.base.exception.CustomException;
import com.example.persistence.domain.Category;
import com.example.persistence.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CategoryImpl implements CategoryDao {

    private final CategoryRepository entityRepository;

    @Override
    public Category save(Category entity) {
        try {
            entityRepository.saveAndFlush(entity);
            return entity;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Category> getListCategory() throws CustomException {
        return entityRepository.getListCategory().orElseThrow(() -> new CustomException("دیتا یافت نشد"));

    }
}
