package C4.backend.dao.impl;

import C4.backend.dao.IDao;
import C4.backend.db.H2Connection;
import C4.backend.model.Cliente;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.List;

public class ClienteDaoH2 implements IDao<Cliente> {

    private static Logger LOGGER = Logger.getLogger(ClienteDaoH2.class);
    private static String SQL_INSERT = "INSERT INTO CLIENTES VALUES (DEFAULT, ?, ?, ?, ?, ?)";


    @Override
    public Cliente registarCliente(Cliente cliente) {
        Connection connection = null;
        Cliente retornarCliente = null;

        try {
            connection = H2Connection.getConnection();
            connection.setAutoCommit(false);

            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setInt(1, cliente.getCodigo());
            preparedStatement.setString(2, cliente.getNombre());
            preparedStatement.setString(3, cliente.getApellido());
            preparedStatement.setInt(4, cliente.getBanco());
            preparedStatement.setInt(5, cliente.getSaldo());

            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()){
                Integer id = resultSet.getInt(1);
                retornarCliente = new Cliente(id, cliente.getCodigo(), cliente.getNombre(), cliente.getApellido(), cliente.getBanco(), cliente.getSaldo());
            }

            LOGGER.info("El cliente es: " + retornarCliente);

            connection.commit();
            connection.setAutoCommit(true);

        }catch (Exception e){
            if(connection!=null){
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    LOGGER.info(ex.getMessage());
                    ex.printStackTrace();
                }
            }
            LOGGER.info(e.getMessage());
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                LOGGER.info(e.getMessage());
                e.printStackTrace();
            }
        }
        return retornarCliente;
    }

    @Override
    public Cliente buscarPorId(Integer id) {
        return null;
    }

    @Override
    public Cliente buscarPorNombre(String nombre) {
        return null;
    }

    @Override
    public List<Cliente> listarTodos() {
        return null;
    }
}
