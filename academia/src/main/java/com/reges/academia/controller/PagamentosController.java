package com.reges.academia.controller;

import com.reges.academia.model.Pagamento;
import com.reges.academia.service.PagamentosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagamentos")
public class PagamentosController {

    @Autowired
    private PagamentosService pagamentosService;

    @GetMapping
    public List<Pagamento> getPagamentos() {
        return pagamentosService.getAllPagamentos();
    }

    @GetMapping("/{id}")
    public Pagamento getPagamentoById(@PathVariable int id) {
        return pagamentosService.getPagamentoById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createPagamento(@RequestBody Pagamento pagamento) {
        pagamentosService.createPagamento(pagamento);
    }

    @PutMapping("/{id}")
    public void updatePagamento(@PathVariable int id, @RequestBody Pagamento pagamento) {
        pagamentosService.updatePagamento(id, pagamento);
    }

    @DeleteMapping("/{id}")
    public void deletePagamento(@PathVariable int id) {
        pagamentosService.deletePagamento(id);
    }
}
