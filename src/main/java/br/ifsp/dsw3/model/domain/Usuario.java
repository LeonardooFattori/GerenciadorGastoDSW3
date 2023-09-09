package br.ifsp.dsw3.model.domain;

public class Usuario {
    private String cpf;
    private String nome;
    private String email;
    private String senha;
    private double salario;

    public Usuario() {
        this.cpf = "";
        this.nome = "";
        this.email = "";
        this.senha = "";
        this.salario = 0;
    }

    public Usuario(String cpf, String nome, String email, String senha, double salario) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.salario = salario;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public double getSalario() {
        return salario;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
