package com.example.demo.DAO;

import com.example.demo.models.AlumnosModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class AlumnosDAOImp implements AlumnosDAO{

    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<AlumnosModel> getAlumnos() {
        String query = "FROM AlumnosModel";
        return entityManager.createQuery(query).getResultList();
    }
}
