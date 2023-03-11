package com.example.persistence.repository;

import com.example.persistence.domain.Task;
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
    @Query("UPDATE Task " +
            "SET title = :title, " +
            " description = :description, " +
            " comment = :comment, " +
            " taskStatus = :taskStatus " +
            "WHERE id = :id ")
    Optional<Integer> update(@Param("id") String id,
                             @Param("title") String title,
                             @Param("description") String description,
                             @Param("comment") String comment,
                             @Param("taskStatus") Task.TaskStatus taskStatus);

    @Transactional
    @Modifying
    @Query("UPDATE Task " +
            "SET title = :title, " +
            " description = :description, " +
            " comment = :comment, " +
            " taskStatus = :taskStatus " +
            "WHERE id = :id ")
    Optional<Integer> updateMyTask(@Param("id") String id,
                                   @Param("description") String description,
                                   @Param("comment") String comment,
                                   @Param("taskStatus") Task.TaskStatus taskStatus);

    @Transactional
    @Modifying
    @Query("DELETE FROM Task " +
            "WHERE id = :id ")
    Optional<Integer> delete(@Param("id") String id);

    @Query(value = "SELECT " +
            "t.id AS id, " +
            "t.title AS title, " +
            "t.description AS description, " +
            "t.comment AS comment, " +
            "t.taskStatus AS taskStatus " +
            "FROM Task AS t " +
            "WHERE ( :term ='' OR :term IS NULL OR t.title LIKE %:term% )",
            countQuery = "SELECT " +
                    "count(t.id) " +
                    "FROM Task AS t " +
                    "WHERE ( :term ='' OR :term IS NULL OR t.title LIKE %:term% )")
    Optional<Page<ResTaskGetPageDTO>> findWithPaginationAsDTO(@Param("term") String term, Pageable pageable);


    @Query(value = "SELECT " +
            "t.id AS id " +
            "FROM task_management.task AS t LIMIT :limit " +
            "WHERE ( :term = '' OR :term IS NULL OR t.title LIKE %:term% )"
            , nativeQuery = true)
    Optional<List<ResTaskGetListDTO>> getListByTermAsDTO(@Param("term") String term, @Param("limit") Integer limit);

    @Query(value = "SELECT " +
            "t.id AS id, " +
            "t.title AS title," +
            "t.description AS description, " +
            "t.comment AS comment," +
            "t.taskStatus As TaskStatus " +
            "FROM task_management.task AS t " +
            "WHERE t.user_id = :userId ", nativeQuery = true)
    Optional<List<ResTaskGetListDTO>> getListMyTask(@Param("userId") String userId);


    @Query("SELECT " +
            "t.id AS id, " +
            "t.title AS title," +
            "t.description AS description, " +
            "t.comment AS comment," +
            "t.taskStatus As TaskStatus " +
            "FROM Task AS t " +
            "WHERE t.id = :id")
    Optional<List<ResTaskGetListDTO>> getListTasks(@Param("id") String id);

    @Query("SELECT " +
            "t.id AS id, " +
            "t.title AS title," +
            "t.description AS description, " +
            "t.comment AS comment," +
            "t.taskStatus As TaskStatus " +
            "FROM Task AS t " +
            "WHERE t.id = :id")
    Optional<ResTaskGetOneDTO> getOneById(@Param("id") String id);

}

