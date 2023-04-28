package com.Mentoria.BRQ.APICapituraCanais1.controller;

import com.Mentoria.BRQ.APICapituraCanais1.modelo.Cartao;
import com.Mentoria.BRQ.APICapituraCanais1.repositorio.CartaoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/card")
class Cartaocontroller {

    @Autowired
    private CartaoRepositorio cartaoRepositorio;

    @GetMapping
    public List<Cartao> listar(){
        return cartaoRepositorio.findAll();  // consultar
    }

    @PostMapping
    public void incluir(@RequestBody Cartao cartao)   {
        cartaoRepositorio.save(cartao);    // metodo criar
    }

    @PutMapping
    public void alterar(@RequestBody Cartao cartao) {
        cartaoRepositorio.save(cartao); // metodo alterar
    }


    @DeleteMapping("/{matricula}")
    public void deletar(@PathVariable long matricula){
        cartaoRepositorio.deleteById(matricula);
    }


   @GetMapping("/{matricula}")
    public Optional<Cartao> ler(@PathVariable long matricula) {
        return cartaoRepositorio.findById(matricula);  // metodo consultar
   }

}
