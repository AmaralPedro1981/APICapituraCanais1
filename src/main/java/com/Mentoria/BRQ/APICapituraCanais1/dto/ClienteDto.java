package com.Mentoria.BRQ.APICapituraCanais1.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

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

        @CPF
        @NotNull
        private String cpf;

        private String telefone;

        @Email
        private String email;

        private String endereco;

        private Instant datacadastro;
    }


}
