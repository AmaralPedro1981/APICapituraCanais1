package com.Mentoria.BRQ.APICapituraCanais1.cartao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
@Entity
@Table(name = "cartao")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class Cartao {


        @Id

        private long matricula;

        private String bandeira;

        private String banco;

        private Instant datacadastro;


}




