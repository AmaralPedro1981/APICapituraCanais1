package com.Mentoria.BRQ.APICapituraCanais1.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

public class ClienteDto {


    @NoArgsConstructor
    @Entity
    @AllArgsConstructor
    @Data

    public class Cliente {

        @Id
        private long matricula;

        private String nome;

        private String cpf;

        private String telefone;

        private String email;

        private String endereço;

        private Instant datacadastro;
    }


}
