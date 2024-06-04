package com.reges.academia.service;

import com.reges.academia.model.Pagamento;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PagamentosService {

    private List<Pagamento> pagamentos = new ArrayList<>();

    public List<Pagamento> getAllPagamentos() {
        return pagamentos;
    }

    public Pagamento getPagamentoById(int id) {
        return pagamentos.stream().filter(p -> p.getIdpagamento() == id).findFirst().orElse(null);
    }

    public void createPagamento(Pagamento pagamento) {
        pagamentos.add(pagamento);
    }

    public void updatePagamento(int id, Pagamento pagamento) {
        pagamentos = pagamentos.stream()
            .map(p -> p.getIdpagamento() == id ? pagamento : p)
            .collect(Collectors.toList());
    }

    public void deletePagamento(int id) {
        pagamentos.removeIf(p -> p.getIdpagamento() == id);
    }
}
