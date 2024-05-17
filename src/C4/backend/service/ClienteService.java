package C4.backend.service;

import C4.backend.dao.IDao;
import C4.backend.model.Cliente;

public class ClienteService {

    private IDao<Cliente> clienteIDao;

    public ClienteService(IDao<Cliente> clienteIDao){
        this.clienteIDao = clienteIDao;
    }

    public Cliente registrarCliente(Cliente cliente){
        return clienteIDao.registarCliente(cliente);
    }
}
