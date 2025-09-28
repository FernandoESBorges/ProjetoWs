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
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    @NotNull(message = "A data do pedido não pode estar vazia")
    private LocalDateTime dataPedido;
    /*relacionando o pedido com o cliento , Um cliente para muitos pedidos, o que vem depois na class  */
    /*Se tiver uma lista usar many */
    /*Se for so uma class usar one */
    /*Então basicamente usar muito (para) um */

    @NotNull(message = "O cliente é obrigatório")
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @NotNull(message = "O valor total é obrigatório")
    private Double valorTotal;

    @NotNull(message = "O valor do desconto é obrigatório") 
    private Double valorDesconto;

    @NotNull(message = "O valor dos produtos é obrigatório")
    private Double valorProdutos;

    @NotNull(message = "O valor do frete é obrigatório")
    private Double valorFrete;

    @NotNull(message = "O endereço é obrigatório")
    @OneToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @Size(max = 255, message = "A observação não pode ter mais que 255 caracteres")
    private String observacaoDoCliente;
    private boolean cancelamento = false;

    @NotEmpty(message = "O pedido deve possuir ao menos um produto")
    @OneToMany(mappedBy = "pedido")
    private List<ProdutoPedido> produtospedidos = new ArrayList<>();

}
