package com.example.persistence.repository;

import com.example.persistence.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query(value = "SELECT " +
            "t.id AS id, " +
            "t.title AS title " +
            "FROM task_management.category AS t "
            , nativeQuery = true)
    Optional<List<Category>> getListCategory();
}
