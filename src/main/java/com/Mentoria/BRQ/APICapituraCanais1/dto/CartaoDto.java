package com.Mentoria.BRQ.APICapituraCanais1.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

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
