package com.example.persistence.repository;

import com.example.persistence.domain.Task;
import com.example.persistence.rest.dto.TaskGetListDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.persistence.rest.dto.ResTaskGetListDTO;
import com.example.persistence.rest.dto.ResTaskGetOneDTO;
import com.example.persistence.rest.dto.ResTaskGetPageDTO;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE task_management.task " +
            "SET title = :title, " +
            " description = :description, " +
            " comment = :comment, " +
            " task_status = :taskStatus " +
            "WHERE id = :taskId ", nativeQuery = true)
    Optional<Integer> update(@Param("taskId") Long id,
                             @Param("title") String title,
                             @Param("description") String description,
                             @Param("comment") String comment,
                             @Param("taskStatus") Task.TaskStatus taskStatus);

    @Transactional
    @Modifying
    @Query(value = "UPDATE task_management.task " +
            "SET title = :title, " +
            " description = :description, " +
            " comment = :comment, " +
            " task_status = :taskStatus " +
            "WHERE id = :taskId ", nativeQuery = true)
    Optional<Integer> updateMyTask(@Param("taskId") Long id,
                                   @Param("title") String title,
                                   @Param("description") String description,
                                   @Param("comment") String comment,
                                   @Param("taskStatus") Task.TaskStatus taskStatus);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM task_management.task " +
            "WHERE id = :id ", nativeQuery = true)
    Optional<Integer> delete(@Param("id") Long id);

    @Query(value = "SELECT " +
            "t.id AS id, " +
            "t.title AS title, " +
            "t.description AS description, " +
            "t.comment AS comment, " +
            "t.taskStatus AS taskStatus " +
            "FROM task_management.task AS t " +
            "WHERE ( :term ='' OR :term IS NULL OR t.title LIKE %:term% )",
            countQuery = "SELECT " +
                    "count(t.id) " +
                    "FROM task_management.task AS t " +
                    "WHERE ( :term ='' OR :term IS NULL OR t.title LIKE %:term% )", nativeQuery = true)
    Optional<Page<ResTaskGetPageDTO>> findWithPaginationAsDTO(@Param("term") String term, Pageable pageable);


    @Query(value = "SELECT " +
            "t.id AS id " +
            "FROM task_management.task AS t LIMIT :limit " +
            "WHERE ( :term = '' OR :term IS NULL OR t.title LIKE %:term% )"
            , nativeQuery = true)
    Optional<List<ResTaskGetListDTO>> getListByTermAsDTO(@Param("term") String term, @Param("limit") Integer limit);

    @Query(value = "SELECT " +
            "t.id AS taskId, " +
            "t.title AS title," +
            "t.description AS description, " +
            "t.comment AS comment," +
            "t.task_status AS TaskStatus," +
            "c.id AS categoryId, " +
            "c.title AS categoryTitle " +
            "FROM task_management.task AS t " +
            "LEFT JOIN task_management.category AS c " +
            "ON t.category_id = c.id " +
            "WHERE (:categoryId ='' OR :categoryId IS NULL OR t.category_id = :categoryId ) " +
            "AND t.user_id = :userId ", nativeQuery = true)
    Optional<List<ResTaskGetListDTO>> getListMyTask(@Param("categoryId") Long categoryId, @Param("userId") Long userId);


    @Query("SELECT " +
            "t.id AS id, " +
            "t.title AS title," +
            "t.description AS description, " +
            "t.comment AS comment," +
            "t.taskStatus As TaskStatus " +
            "FROM Task AS t " +
            "WHERE t.id = :id")
    Optional<List<ResTaskGetListDTO>> getListTasks(@Param("id") Long id);

    @Query(value = "SELECT " +
            "t.id AS id, " +
            "t.title AS title," +
            "t.description AS description, " +
            "t.comment AS comment," +
            "t.task_status As TaskStatus " +
            "FROM task_management.task AS t " +
            "WHERE t.id = :id", nativeQuery = true)
    Optional<ResTaskGetOneDTO> getOneById(@Param("id") Long id);


    @Query(value = "SELECT * FROM task_management.task ;", nativeQuery = true)
    List<Task> getListTask();

    @Query(value = "SELECT " +
            "t.id AS taskId, " +
            "t.title AS title, " +
            "t.description AS description, " +
            "t.comment AS comment, " +
            "t.task_status AS TaskStatus, " +
            "c.id AS categoryId, " +
            "c.title AS categoryTitle " +
            "FROM task_management.task AS t " +
            "LEFT JOIN task_management.category AS c " +
            "ON t.category_id = c.id " +
            "WHERE (:categoryId ='' OR :categoryId IS NULL OR t.category_id = :categoryId ) ", nativeQuery = true)
    Optional<List<TaskGetListDTO>> getListByCategoryId(@Param("categoryId") Long categoryId);
}

