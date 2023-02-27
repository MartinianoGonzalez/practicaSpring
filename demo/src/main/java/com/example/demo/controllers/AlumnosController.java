package com.example.demo.controllers;

import com.example.demo.DAO.AlumnosDAO;
import com.example.demo.models.AlumnosModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AlumnosController {

    @Autowired
    private AlumnosDAO alumnosDAO;

    @GetMapping("/listarAlumnos")
    public List<AlumnosModel> getAlumnos(){
        return alumnosDAO.getAlumnos();
    }
}
