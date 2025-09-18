package com.unincor.projetows.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "produtos")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String cep;
    private String logradouro;
    private String Complemento;
    private String bairro;
    private String numero;
    private String cidade;
    private String uf;

    @OneToOne(mappedBy = "pedido")
    private Pedido pedido;
    
    

}
