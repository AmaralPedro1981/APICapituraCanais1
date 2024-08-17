package com.Mentoria.BRQ.APICapituraCanais1;

import com.Mentoria.BRQ.APICapituraCanais1.controller.ClienteController;
import com.Mentoria.BRQ.APICapituraCanais1.modelo.Cliente;
import com.Mentoria.BRQ.APICapituraCanais1.repositorio.ClienteRepositorio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class ClienteControllerTest {

        private ClienteController clienteController;

        @Mock
        private ClienteRepositorio clienteRepositorio;

        @BeforeEach
        void setUp() {
            MockitoAnnotations.openMocks(this);
            clienteController = new ClienteController(clienteRepositorio);
        }

        @Test
        void testListarClientes() {
            List<Cliente> clientes = new ArrayList<>();
            when(clienteRepositorio.findAll()).thenReturn(clientes);

            List<Cliente> result = clienteController.criar();

            assertEquals(clientes, result);
        }

        @Test
        void testIncluirCliente() {
            Cliente cliente = new Cliente();
            clienteController.incluir(cliente);

            verify(clienteRepositorio, times(1)).save(cliente);
        }

        @Test
        void testAlterarCliente() {
            Cliente cliente = new Cliente();
            ResponseEntity response = clienteController.alterar(cliente);

            verify(clienteRepositorio, times(1)).save(cliente);
            assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        }

        @Test
        void testDeletarCliente() {
            long matricula = 1;
            clienteController.deletar(matricula);

            verify(clienteRepositorio, times(1)).deleteById(matricula);
        }

        @Test
        void testConsultarCliente() {
            long matricula = 1;
            Cliente cliente = new Cliente();
            when(clienteRepositorio.findById(matricula)).thenReturn(Optional.of(cliente));

            Optional<Cliente> result = clienteController.consultar(matricula);

            assertTrue(result.isPresent());
            assertEquals(cliente, result.get());
        }
    }


