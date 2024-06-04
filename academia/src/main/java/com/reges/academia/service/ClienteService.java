package com.reges.academia.service;

import com.reges.academia.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class ClienteService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Cliente> getAllClientes() {
        String sql = "SELECT * FROM cliente";
        return jdbcTemplate.query(sql, new ClienteRowMapper());
    }

    public Cliente getClienteById(Long id) {
        String sql = "SELECT * FROM cliente WHERE idcli = ?";
        return jdbcTemplate.queryForObject(sql, new ClienteRowMapper(), id);
    }

    public int createCliente(Cliente cliente) {
        String sql = "INSERT INTO cliente (nomecli, endcli, fonecli, emailcli) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, cliente.getNome(), cliente.getEndereco(), cliente.getTelefone(), cliente.getEmail());
    }

    public int updateCliente(Long id, Cliente cliente) {
        String sql = "UPDATE cliente SET nomecli = ?, endcli = ?, fonecli = ?, emailcli = ? WHERE idcli = ?";
        return jdbcTemplate.update(sql, cliente.getNome(), cliente.getEndereco(), cliente.getTelefone(), cliente.getEmail(), id);
    }

    public int deleteCliente(Long id) {
        String sql = "DELETE FROM cliente WHERE idcli = ?";
        return jdbcTemplate.update(sql, id);
    }

    public List<Cliente> searchClientes(String keyword) {
        return getAllClientes().stream()
                            .filter(cliente -> cliente.getNome().toLowerCase().contains(keyword.toLowerCase()))
                            .collect(Collectors.toList());
    }


    private static final class ClienteRowMapper implements RowMapper<Cliente> {
        @Override
        public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
            Cliente cliente = new Cliente();
            cliente.setId(rs.getLong("idcli"));
            cliente.setNome(rs.getString("nomecli"));
            cliente.setEndereco(rs.getString("endcli"));
            cliente.setTelefone(rs.getString("fonecli"));
            cliente.setEmail(rs.getString("emailcli"));
            return cliente;
        }
    }
}
