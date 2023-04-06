package com.Mentoria.BRQ.APICapituraCanais1.repositorio;

import com.Mentoria.BRQ.APICapituraCanais1.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {


}
