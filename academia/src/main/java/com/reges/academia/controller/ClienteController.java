package com.reges.academia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import com.reges.academia.model.Cliente;
import com.reges.academia.service.ClienteService;


@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> getClientes() {
        return clienteService.getAllClientes();
    }

    @GetMapping("/{id}")
    public Cliente getClienteById(@PathVariable Long id) {
        return clienteService.getClienteById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createCliente(@RequestBody Cliente cliente) {
        clienteService.createCliente(cliente);
    }

    @PutMapping("/{id}")
    public void updateCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        clienteService.updateCliente(id, cliente);
    }

    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable Long id) {
        clienteService.deleteCliente(id);
    }

    @GetMapping("/search")
    public List<Cliente> searchClientes(@RequestParam String keyword) {
        return clienteService.searchClientes(keyword);
    }

    

}

