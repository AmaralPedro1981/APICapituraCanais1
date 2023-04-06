package com.Mentoria.BRQ.APICapituraCanais1.repositorio;

import com.Mentoria.BRQ.APICapituraCanais1.pagamento.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepositorio extends JpaRepository<Pagamento, Long> {
}
