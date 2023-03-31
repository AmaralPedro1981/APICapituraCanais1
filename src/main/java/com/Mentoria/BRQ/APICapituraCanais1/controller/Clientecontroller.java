package com.Mentoria.BRQ.APICapituraCanais1.controller;

import com.Mentoria.BRQ.APICapituraCanais1.modelo.Cliente;
import com.Mentoria.BRQ.APICapituraCanais1.repositorio.ClienteRepositorio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class Clientecontroller {

    private ClienteRepositorio clienteRepositorio;


    @GetMapping
    public List<Cliente> criar() {
        return clienteRepositorio.findAll();  //Criar
    }

    @PostMapping
    public ResponseEntity incluir(@RequestBody Cliente cliente) {
        clienteRepositorio.save(cliente);        // Incluir
    return ResponseEntity.noContent().build();
    }


    @PutMapping
    public ResponseEntity alterar(@RequestBody Cliente cliente) {

        clienteRepositorio.save(cliente);  // Alterar
    return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{matricula}")
    public void deletar(@PathVariable long matricula){
        clienteRepositorio.deleteById(matricula);
    }


    @GetMapping("/{matricula}")
    public Optional<Cliente> consultar(@PathVariable long matricula) {
        return clienteRepositorio.findById(matricula); // Consultar
    }

}