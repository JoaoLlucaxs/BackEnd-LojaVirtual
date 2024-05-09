package jl.software.lojavirtual.loja_virtual_mentoria.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "item_venda_loja")
@SequenceGenerator(name = "seq_item_venda_loja",sequenceName = "seq_item_venda_loja", initialValue = 1,allocationSize = 1)
public class ItemVendaLoja implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_item_venda_loja")
    private Long id;

    @ManyToOne(targetEntity = Produto.class)
    @JoinColumn(name = "produto_id",nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "produto_fk"))
    Produto produto;
    @ManyToOne(targetEntity =VendaCompraLojaVirtual.class)
    @JoinColumn(name = "vd_compra_loja_virtual_id",nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "vd_compra_loja_virtual_fk"))
    private VendaCompraLojaVirtual vendaCompraLojaVirtual;

    private Double quantidade;
}
