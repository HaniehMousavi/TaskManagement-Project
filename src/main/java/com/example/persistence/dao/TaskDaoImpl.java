package com.example.persistence.dao;

import com.example.persistence.base.exception.CustomException;
import com.example.persistence.domain.Task;
import com.example.persistence.repository.TaskRepository;
import com.example.persistence.rest.dto.ReqTaskUpdateDTO;
import com.example.persistence.rest.dto.ResTaskGetListDTO;
import com.example.persistence.rest.dto.ResTaskGetOneDTO;
import com.example.persistence.rest.dto.ResTaskGetPageDTO;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class TaskDaoImpl implements TaskDao {

    private final TaskRepository entityRepository;
    private final EntityManager entityManager;

    private SessionFactory getSessionFactory() {
        Session session = entityManager.unwrap(Session.class);
        return session.getSessionFactory();
    }

    private Session openSession() {
        return this.getSessionFactory().openSession();
    }

    @Override
    public Boolean save(Task entity) {
        try {
            entityRepository.saveAndFlush(entity);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean update(String id, ReqTaskUpdateDTO entity) {
        Optional<Integer> optionalInteger = entityRepository.update(id, entity.getTitle(), entity.getDescription(), entity.getComment(), entity.getTaskStatus());
        return optionalInteger.isPresent() && optionalInteger.get() > 0;
    }

    @Override
    public List<ResTaskGetListDTO> getListTasks(String id) throws CustomException {
        return entityRepository.getListTasks(id).orElseThrow(() -> new CustomException("دیتا یافت نشد"));
    }

    @Override
    public Boolean updateMyTask(String id, ReqTaskUpdateDTO entity) {
        Optional<Integer> optionalInteger = entityRepository.updateMyTask(id, entity.getDescription(), entity.getComment(), entity.getTaskStatus());
        return optionalInteger.isPresent() && optionalInteger.get() > 0;
    }

    @Override
    public List<ResTaskGetListDTO> getListMyTask(String userId) throws CustomException {
        return entityRepository.getListMyTask(userId).orElseThrow(() -> new CustomException("دیتا یافت نشد"));
    }

    @Override
    public Boolean deleteById(String id) {
        Optional<Integer> optionalInteger = entityRepository.delete(id);
        return optionalInteger.isPresent() && optionalInteger.get() > 0;
    }

    @Override
    public Page<ResTaskGetPageDTO> findWithPaginationAsDTO(String term, Pageable pageable) throws CustomException {
        return entityRepository.findWithPaginationAsDTO(term, pageable).orElseThrow(() -> new CustomException("دیتا یافت نشد"));
    }

    @Override
    public List<ResTaskGetListDTO> getListByTermAsDTO(String term, Integer limit) throws CustomException {
        return entityRepository.getListByTermAsDTO(term, limit).orElseThrow(() -> new CustomException("دیتا یافت نشد"));
    }

    @Override
    public ResTaskGetOneDTO getOneByIdAsDTO(String id) throws CustomException {
        return entityRepository.getOneById(id).orElseThrow(() -> new CustomException("دیتا یافت نشد"));
    }

}

