package com.reges.academia.service;

import com.reges.academia.model.Funcionario;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {
    private List<Funcionario> funcionarios = new ArrayList<>();

    public List<Funcionario> findAll() {
        return funcionarios;
    }

    public Funcionario findById(int id) {
        return funcionarios.stream()
                .filter(funcionario -> funcionario.getIdfunc() == id)
                .findFirst()
                .orElse(null);
    }

    public Funcionario save(Funcionario funcionario) {
        funcionarios.add(funcionario);
        return funcionario;
    }

    public Funcionario update(int id, Funcionario newFuncionario) {
        Funcionario funcionario = findById(id);
        if (funcionario != null) {
            funcionario.setNomefunc(newFuncionario.getNomefunc());
            funcionario.setFuncaofunc(newFuncionario.getFuncaofunc());
            funcionario.setContatofunc(newFuncionario.getContatofunc());
            funcionario.setSalariofunc(newFuncionario.getSalariofunc());
        }
        return funcionario;
    }

    public boolean delete(int id) {
        return funcionarios.removeIf(funcionario -> funcionario.getIdfunc() == id);
    }
}
