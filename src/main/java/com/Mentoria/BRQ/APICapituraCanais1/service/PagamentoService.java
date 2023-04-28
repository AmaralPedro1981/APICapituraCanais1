package com.Mentoria.BRQ.APICapituraCanais1.service;

import com.Mentoria.BRQ.APICapituraCanais1.dto.PagamentoDto;
import com.Mentoria.BRQ.APICapituraCanais1.mapper.PagamentoMapper;
import com.Mentoria.BRQ.APICapituraCanais1.modelo.Status;
import com.Mentoria.BRQ.APICapituraCanais1.pagamento.Pagamento;
import com.Mentoria.BRQ.APICapituraCanais1.repositorio.PagamentoRepositorio;
import jakarta.persistence.EntityNotFoundException;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Configuration
@Service
@Setter
public class PagamentoService {



    @Autowired
    private PagamentoRepositorio repositorio;

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PagamentoMapper pagamentoMapper;


    public Page<PagamentoDto> obterTodos(Pageable paginacao) {
        return repositorio
                .findAll(paginacao)
                .map(p -> modelMapper.map(p, PagamentoDto.class));

    }


    public PagamentoDto obterPorId(Long id) {
        Pagamento pagamento = repositorio.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());
        return modelMapper.map(pagamento, PagamentoDto.class);

    }


    public PagamentoDto criarPagamento(PagamentoDto dto){
        Pagamento pagamento = pagamentoMapper.paraPagamento(dto);
        pagamento.setStatus(Status.CRIADO);
        repositorio.save(pagamento);

        return modelMapper.map(pagamento, PagamentoDto.class);

    }


    public PagamentoDto atualizarPagamento(Long id,PagamentoDto dto) {
          Pagamento pagamento = modelMapper.map(dto, Pagamento.class);
          pagamento.setId(id);
          pagamento = repositorio.save(pagamento);
          return  modelMapper.map(pagamento, PagamentoDto.class);
    }


    public void excluirPagamento(Long id) {
        repositorio.deleteById(id);
    }

}
