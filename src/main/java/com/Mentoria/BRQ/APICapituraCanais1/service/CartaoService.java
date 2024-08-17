package com.Mentoria.BRQ.APICapituraCanais1.service;

import com.Mentoria.BRQ.APICapituraCanais1.cartao.Cartao;
import com.Mentoria.BRQ.APICapituraCanais1.dto.CartaoDto;
import com.Mentoria.BRQ.APICapituraCanais1.mapper.CartaoMapper;
import com.Mentoria.BRQ.APICapituraCanais1.repositorio.CartaoRepositorio;
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
public class CartaoService {



        @Autowired
        private CartaoRepositorio repositorio;

        @Autowired
        private ModelMapper modelMapper;
        @Autowired
        private CartaoMapper cartaoMapper;


        public Page<CartaoDto> obterTodos(Pageable paginacao) {
            return repositorio
                    .findAll(paginacao)
                    .map(p -> modelMapper.map(p, CartaoDto.class));

        }



        public CartaoDto obterPorId(Long id) {
            Cartao cartao = repositorio
                    .findById(id)
                    .orElseThrow(() -> new EntityNotFoundException());
            return modelMapper.map(cartao, CartaoDto.class);

        }


        public CartaoDto criarCartao(CartaoDto dto){
            Cartao cartao = cartaoMapper.paraCartao(dto);
//            cartao.setStatus(CRIADO);
            repositorio.save(cartao);
            return modelMapper.map(cartao, CartaoDto.class);

        }


        public CartaoDto atualizarCartao(Long id,CartaoDto dto) {
            Cartao cartao = modelMapper.map(dto, Cartao.class);
//            cartao.setId(id);
            cartao = repositorio.save(cartao);
            return  modelMapper.map(cartao, CartaoDto.class);
        }


        public void excluirCartao (Long id) {
            repositorio.deleteById(id);
        }


}

