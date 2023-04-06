package com.Mentoria.BRQ.APICapituraCanais1.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

public class CartaoDto {

    @NoArgsConstructor
    @Entity
    @AllArgsConstructor
    @Data



    public class Cartao {
        @Id

        private long matricula;
        private String bandeira;
        private String banco;
        private Instant datacadastro;

    }

}
