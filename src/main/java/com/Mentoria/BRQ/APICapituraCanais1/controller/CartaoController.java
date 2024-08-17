package com.Mentoria.BRQ.APICapituraCanais1.controller;

import com.Mentoria.BRQ.APICapituraCanais1.dto.CartaoDto;
import com.Mentoria.BRQ.APICapituraCanais1.service.CartaoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;


@RestController
@RequestMapping("/cartoes")
public class CartaoController {

    @Autowired
    private CartaoService service;


    @GetMapping("/{id}")
    public ResponseEntity<CartaoDto> detail(@PathVariable @NotNull Long id){
        CartaoDto dto = service.obterPorId(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping   // metodo listar
    public Page<CartaoDto> List(@PageableDefault(size = 10) Pageable paginacao) {
        return service.obterTodos(paginacao);
    }

    @PostMapping   // metodo criar
    public ResponseEntity<CartaoDto> incluir(@RequestBody @Valid CartaoDto dto, URI cartaoDto) {
        CartaoDto cartao = service.criarCartao(dto);
        return ResponseEntity.created(cartaoDto).body(dto);
    }

  // metodo alterar
    @PutMapping("/{matricula}")
    public ResponseEntity<CartaoDto> alterar(@PathVariable @NotNull Long matricula, @RequestBody @Valid CartaoDto dto) {
        CartaoDto atualizado = service.atualizarCartao(matricula, dto);
        return ResponseEntity.ok(atualizado);
    }


    @DeleteMapping("/{matricula}")   // metodo deletar
    public ResponseEntity<CartaoDto> deletar(@PathVariable @NotNull Long matricula) {
        service.excluirCartao(matricula);
        return ResponseEntity.noContent().build();
    }



}











