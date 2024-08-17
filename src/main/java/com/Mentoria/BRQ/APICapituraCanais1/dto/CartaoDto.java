package com.Mentoria.BRQ.APICapituraCanais1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CartaoDto {



        private Long matricula;
        private String bandeira;
        private String banco;
        private Instant datacadastro;

    }


