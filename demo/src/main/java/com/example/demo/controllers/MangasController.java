package com.example.demo.controllers;

import com.example.demo.DAO.MangasDAO;
import com.example.demo.models.MangasModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MangasController {

    @Autowired
    private MangasDAO mangasDAO;

    @GetMapping("/listar")
    public List<MangasModel> getMangas(){
        return mangasDAO.getMangas();
    }

    @PostMapping("/agregar")
    public void saveManga(@RequestBody MangasModel body) {
        MangasModel manga = new MangasModel();
        manga.setNombre(body.getNombre());
        manga.setTomo(body.getTomo());
        manga.setPrecio(body.getPrecio());
        mangasDAO.save(manga);
    }

    @PostMapping("/eliminar")
    public void deleteManga(@RequestBody MangasModel body) {
        MangasModel manga = new MangasModel();
        manga.setId(body.getId());
        mangasDAO.delete(manga);
    }

    @PostMapping("/actualizar")
    public void updateManga(@RequestBody MangasModel body) {
        MangasModel manga = new MangasModel();
        manga.setId(body.getId());
        manga.setNombre(body.getNombre());
        manga.setTomo(body.getTomo());
        manga.setPrecio(body.getPrecio());
        mangasDAO.update(manga);
    }

    @PostMapping("/buscar")
    public List<MangasModel> searchMangas(@RequestBody MangasModel body) { return mangasDAO.searchMangas(body); }

    @PostMapping("/id")
    public  List<MangasModel> searchId(@RequestBody MangasModel body) { return mangasDAO.searchId(body); }

}
