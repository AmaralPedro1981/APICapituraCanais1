package com.Mentoria.BRQ.APICapituraCanais1;

import com.Mentoria.BRQ.APICapituraCanais1.controller.PagamentoController;
import com.Mentoria.BRQ.APICapituraCanais1.dto.PagamentoDto;
import com.Mentoria.BRQ.APICapituraCanais1.service.PagamentoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PagamentoControllerTest {

    @InjectMocks
    private PagamentoController pagamentoController;

    @Mock
    private PagamentoService pagamentoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testListarPagamentos() {
        Pageable pageable = Pageable.ofSize(10);
        List<PagamentoDto> pagamentos = new ArrayList<>();
        when(pagamentoService.obterTodos(pageable)).thenReturn(Page.empty());

        Page<PagamentoDto> result = pagamentoController.List(pageable);

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void testDetalharPagamento() {
        Long pagamentoId = 1L;
        PagamentoDto pagamentoDto = new PagamentoDto();
        when(pagamentoService.obterPorId(pagamentoId)).thenReturn(pagamentoDto);

        ResponseEntity<PagamentoDto> response = pagamentoController.detail(pagamentoId);

        assertNotNull(response);
        assertEquals(pagamentoDto, response.getBody());
    }

    @Test
    void testRegistrarPagamento() {
        PagamentoDto pagamentoDto = new PagamentoDto();
        when(pagamentoService.criarPagamento(pagamentoDto)).thenReturn(pagamentoDto);

        ResponseEntity<PagamentoDto> response = pagamentoController.register(pagamentoDto, UriComponentsBuilder.fromUri(URI.create("")));

        assertNotNull(response);
        assertEquals(pagamentoDto, response.getBody());
    }

    @Test
    void testAtualizarPagamento() {
        Long pagamentoId = 1L;
        PagamentoDto pagamentoDto = new PagamentoDto();
        when(pagamentoService.atualizarPagamento(pagamentoId, pagamentoDto)).thenReturn(pagamentoDto);

        ResponseEntity<PagamentoDto> response = pagamentoController.update(pagamentoId, pagamentoDto);

        assertNotNull(response);
        assertEquals(pagamentoDto, response.getBody());
    }

    @Test
    void testRemoverPagamento() {
        long pagamentoId = 1L;
        ResponseEntity<PagamentoDto> response = pagamentoController.remove(pagamentoId);

        assertNotNull(response);
        assertEquals(204, response.getStatusCodeValue());
    }
}
