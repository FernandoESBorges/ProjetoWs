package com.unincor.projetows.model.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name = "Pedidos")

public class Pedido {
    /*Gerar id  */
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime dataPedido;
    /*relacionando o pedido com o cliento , Um cliente para muitos pedidos, o que vem depois na class  */
    /*Se tiver uma lista usar many */
    /*Se for so uma class usar one */
    /*Então basicamente usar muito (para) um */
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    private Double valorTotal;
    private Double valorDesconto;
    private Double valorProdutos;
    private Double valorFrete;
    @OneToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;
    private String observacaoDoCliente;
    private boolean cancelamento = false;
    @OneToMany(mappedBy = "pedido")
    private List<ProdutoPedido> produtospedidos = new ArrayList<>();

}
