package com.Mentoria.BRQ.APICapituraCanais1.mapper;

import com.Mentoria.BRQ.APICapituraCanais1.dto.CartaoDto;
import com.Mentoria.BRQ.APICapituraCanais1.cartao.Cartao;
import org.springframework.stereotype.Component;

@Component
public class CartaoMapper {
    public Cartao paraCartao(CartaoDto dto){
        Cartao cartao = new Cartao();
        cartao.setBanco(dto.getBanco());
        cartao.setBandeira(dto.getBandeira());
        cartao.setMatricula(dto.getMatricula());
        cartao.setDatacadastro(dto.getDatacadastro());
        return cartao;
    }
}


