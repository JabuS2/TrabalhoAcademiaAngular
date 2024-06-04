package com.reges.academia.controller;

import com.reges.academia.model.Plano;
import com.reges.academia.service.PlanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/planos")
public class PlanoController {

    @Autowired
    private PlanoService planoService;

    @GetMapping
    public List<Plano> getPlanos() {
        return planoService.getAllPlanos();
    }

    @GetMapping("/{id}")
    public Plano getPlanoById(@PathVariable Long id) {
        return planoService.getPlanoById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createPlano(@RequestBody Plano plano) {
        planoService.createPlano(plano);
    }

    @PutMapping("/{id}")
    public void updatePlano(@PathVariable Long id, @RequestBody Plano plano) {
        planoService.updatePlano(id, plano);
    }

    @DeleteMapping("/{id}")
    public void deletePlano(@PathVariable Long id) {
        planoService.deletePlano(id);
    }
}
