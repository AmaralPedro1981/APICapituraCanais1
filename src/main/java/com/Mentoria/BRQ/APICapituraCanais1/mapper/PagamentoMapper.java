package com.Mentoria.BRQ.APICapituraCanais1.mapper;

import com.Mentoria.BRQ.APICapituraCanais1.dto.PagamentoDto;
import com.Mentoria.BRQ.APICapituraCanais1.pagamento.Pagamento;
import org.springframework.stereotype.Component;

@Component
public class PagamentoMapper {

    public Pagamento paraPagamento(PagamentoDto dto){
           Pagamento pagamento = new Pagamento();
           pagamento.setStatus(dto.getStatus());
           pagamento.setFormaDePagamento(dto.getFormaDePagamento());
           pagamento.setId(dto.getId());
           pagamento.setDia(dto.getDia());
           pagamento.setSemana(dto.getSemana());
           pagamento.setValor(dto.getValor());
           pagamento.setNumero(dto.getNumero());
           pagamento.setNome(dto.getNome());
           pagamento.setExpiracao(dto.getExpiracao());
           pagamento.setCodigo(dto.getCodigo());
           return pagamento;
    }
}
