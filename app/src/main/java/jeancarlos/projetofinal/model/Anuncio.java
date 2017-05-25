package jeancarlos.projetofinal.model;

import java.io.Serializable;

/**
 * Created by Jean Carlos on 21/05/2017.
 */

public class Anuncio implements Serializable {

    private Long id;
    private String descricao;
    private String estado;
    private String preco;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }
}
