package C4.backend.test;

import C4.backend.dao.impl.ClienteDaoH2;
import C4.backend.model.Cliente;
import C4.backend.service.ClienteService;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class ClienteServiceTest {

    private static Logger LOGGER = Logger.getLogger(ClienteServiceTest.class);
    private static ClienteService clienteService = new ClienteService(new ClienteDaoH2());

    @BeforeAll
    static void crearTablas(){
        Connection connection = null;
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:~/db_clientes_banco;INIT=RUNSCRIPT FROM 'create.sql'", "sa", "sa");
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error(e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                LOGGER.error(e.getMessage());
            }
        }
    }

    @Test
    @DisplayName("Testeo de registro y almacenamiento de paciente")
    void test1(){
        Cliente cliente = new Cliente(6584, "LISSA", "SIMPSON", 12, 2500 );

        Cliente clienteNuevo = clienteService.registrarCliente(cliente);

        assertNotNull(clienteNuevo);
    }
}