package com.reges.academia.controller;

import com.reges.academia.model.Funcionario;
import com.reges.academia.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public List<Funcionario> getAllFuncionarios() {
        return funcionarioService.findAll();
    }

    @GetMapping("/{id}")
    public Funcionario getFuncionarioById(@PathVariable int id) {
        return funcionarioService.findById(id);
    }

    @PostMapping
    public Funcionario createFuncionario(@RequestBody Funcionario funcionario) {
        return funcionarioService.save(funcionario);
    }

    @PutMapping("/{id}")
    public Funcionario updateFuncionario(@PathVariable int id, @RequestBody Funcionario funcionario) {
        return funcionarioService.update(id, funcionario);
    }

    @DeleteMapping("/{id}")
    public boolean deleteFuncionario(@PathVariable int id) {
        return funcionarioService.delete(id);
    }
}