package com.Mentoria.BRQ.APICapituraCanais1.repositorio;
import com.Mentoria.BRQ.APICapituraCanais1.cartao.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartaoRepositorio extends JpaRepository<Cartao, Long> {

}
