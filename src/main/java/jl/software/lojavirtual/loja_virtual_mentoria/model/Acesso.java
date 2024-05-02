package jl.software.lojavirtual.loja_virtual_mentoria.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "acesso")
@SequenceGenerator(name = "seq_acesso", sequenceName = "seq_acesso", allocationSize = 1,initialValue = 1)
public class Acesso implements GrantedAuthority  {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_acesso")
    private Long id;

    @Column(nullable = false)
    private String descricao; // EX: ROLE_ADMIN ou ROLE_SECRETARIO

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Acesso acesso = (Acesso) o;
        return Objects.equals(id, acesso.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String getAuthority() {
        return this.descricao;
    }
}
