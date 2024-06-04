package com.reges.academia.service;

import com.reges.academia.model.Plano;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlanoService {

    private List<Plano> planos = new ArrayList<>();

    public List<Plano> getAllPlanos() {
        return planos;
    }

    public Plano getPlanoById(Long id) {
        return planos.stream()
                     .filter(p -> p.getId().equals(id))
                     .findFirst()
                     .orElse(null);
    }

    public void createPlano(Plano plano) {
        planos.add(plano);
    }

    public void updatePlano(Long id, Plano updatedPlano) {
        planos = planos.stream()
                       .map(p -> p.getId().equals(id) ? updatedPlano : p)
                       .collect(Collectors.toList());
    }

    public void deletePlano(Long id) {
        planos.removeIf(p -> p.getId().equals(id));
    }
}
