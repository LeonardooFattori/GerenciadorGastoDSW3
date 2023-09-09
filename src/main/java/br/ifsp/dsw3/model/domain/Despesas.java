package br.ifsp.dsw3.model.domain;

public class Despesas {
    private int id;
    private String descricao;
    private String categoria;
    private Double valor;
    private String cpfusuario;

    public Despesas() {
        this.id = -1;
        this.descricao = "";
        this.categoria = "";
        this.cpfusuario = "";
    }

    public Despesas(int id, String descricao, String categoria, Double valor, String cpfusuario) {
        this.id = id;
        this.descricao = descricao;
        this.categoria = categoria;
        this.valor = valor;
        this.cpfusuario = cpfusuario;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public Double getValor() {
        return valor;
    }

    public String getCpfusuario() {
        return cpfusuario;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public void setCpfusuario(String cpfusuario) {
        this.cpfusuario = cpfusuario;
    }
}
