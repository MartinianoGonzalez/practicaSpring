package com.example.demo.DAO;

import com.example.demo.models.MangasModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class MangasDAOImp implements MangasDAO{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<MangasModel> getMangas() {
        String query = "FROM MangasModel";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void save(MangasModel manga) {
        entityManager.persist(manga);
    }

    @Override
    public void update(MangasModel manga) {

        MangasModel manga2 = entityManager.find(MangasModel.class, manga.getId());

        if (manga2 != null) {
            if (!manga.getNombre().equals("")) {
                manga2.setNombre(manga.getNombre());
            }
            if (manga.getTomo()>0) {
                manga2.setTomo(manga.getTomo());
            }
            if (manga.getPrecio()>0) {
                manga2.setPrecio(manga.getPrecio());
            }

            entityManager.merge(manga2);
        }
    }

    @Override
    public void delete(MangasModel manga) {
        MangasModel manga2 = entityManager.find(MangasModel.class, manga.getId());
        if (manga2 != null) {
            entityManager.remove(manga2);
        }
    }

    @Override
    public List<MangasModel> searchMangas(MangasModel manga) {
        Query query = entityManager.createQuery("SELECT m FROM MangasModel m WHERE m.nombre LIKE :nombre", MangasModel.class);
        query.setParameter("nombre", "%" + manga.getNombre() + "%");
        return query.getResultList();
    }

    @Override
    public List<MangasModel> searchId(MangasModel manga) {
        Query query = entityManager.createQuery("SELECT m FROM MangasModel m WHERE m.id = :id", MangasModel.class);
        query.setParameter("id", manga.getId());
        return query.getResultList();
    }
}
