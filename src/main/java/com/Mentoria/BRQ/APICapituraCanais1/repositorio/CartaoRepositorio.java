package com.Mentoria.BRQ.APICapituraCanais1.repositorio;

import com.Mentoria.BRQ.APICapituraCanais1.modelo.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartaoRepositorio extends JpaRepository<Cartao, Long> {
    //void deletar(long);
}
