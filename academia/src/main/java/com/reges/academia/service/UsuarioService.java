package com.reges.academia.service;

import com.reges.academia.model.UsuarioModel;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList; // Para simulação
import java.util.stream.Collectors;


@Service
public class UsuarioService {

    private List<UsuarioModel> usuarios = new ArrayList<>();

    public List<UsuarioModel> getAllUsuarios() {
        return new ArrayList<>(usuarios);
    }

    public UsuarioModel getUsuarioById(Long id) {
        return usuarios.stream()
                       .filter(u -> u.getId().equals(id))
                       .findFirst()
                       .orElse(null);
    }

    public void createUsuario(UsuarioModel usuario) {
        // Aqui assumimos que o ID do novo usuário é gerado de maneira simplificada.
        // Em um ambiente real, isso deveria ser gerenciado de forma mais robusta ou pelo banco de dados.
        long maxId = usuarios.stream()
                             .mapToLong(UsuarioModel::getId)
                             .max()
                             .orElse(0);
        usuario.setId(maxId + 1);
        usuarios.add(usuario);
    }

    public void updateUsuario(Long id, UsuarioModel updatedUsuario) {
        usuarios = usuarios.stream()
                           .map(u -> u.getId().equals(id) ? updatedUsuario : u)
                           .collect(Collectors.toList());
    }

    public void deleteUsuario(Long id) {
        usuarios.removeIf(u -> u.getId().equals(id));
    }
}

