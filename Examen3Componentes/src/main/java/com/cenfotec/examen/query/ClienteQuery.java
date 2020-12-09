package com.cenfotec.examen.query;

import com.cenfotec.examen.entities.Cliente;
import com.cenfotec.examen.services.ClienteService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteQuery implements GraphQLQueryResolver {

    @Autowired
    private ClienteService service;

    public List<Cliente> getClientes(String apellidoCliente, String direccionCobro) {
        return this.service.getAllClientes(apellidoCliente, direccionCobro);
    }

    public Cliente getCliente(int id) {
        return this.service.findById(id);
    }


}
