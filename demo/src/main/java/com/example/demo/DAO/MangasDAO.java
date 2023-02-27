package com.example.demo.DAO;

import com.example.demo.models.MangasModel;

import java.util.List;

public interface MangasDAO {

    List<MangasModel> getMangas();

    void save(MangasModel manga);

    void update(MangasModel manga);

    void delete(MangasModel manga);

    List<MangasModel> searchMangas(MangasModel manga);

    List<MangasModel> searchId(MangasModel manga);
}
