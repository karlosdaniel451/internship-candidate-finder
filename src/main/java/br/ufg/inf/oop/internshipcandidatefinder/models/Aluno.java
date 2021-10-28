package br.ufg.inf.oop.internshipcandidatefinder.models;

import java.util.Date;

public class Aluno implements Enderecavel {
    private static int numberOfCreatedObjects = 0;

    private int id = 0;
    private String codigoDeMatricula;
    private String nome;
    private Date dataDeNascimento;
    private String email;
    private String telefone;
    private Date dataDeMatricula;
    private Endereco endereco;

    public Aluno(String codigoDeMatricula, String nome, Date dataDeNascimento, String email,
                 String telefone, Date dataDeMatricula, Endereco enderecoDeMatricula) {

        Aluno.numberOfCreatedObjects++;

        this.id = numberOfCreatedObjects;
        this.codigoDeMatricula = codigoDeMatricula;
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.email = email;
        this.telefone = telefone;
        this.dataDeMatricula = dataDeMatricula;
        this.endereco = enderecoDeMatricula;
    }

    public String getCodigoDeMatricula() {
        return codigoDeMatricula;
    }

    public void setCodigoDeMatricula(String codigoDeMatricula) {
        this.codigoDeMatricula = codigoDeMatricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getDataDeMatricula() {
        return dataDeMatricula;
    }

    public void setDataDeMatricula(Date dataDeMatricula) {
        this.dataDeMatricula = dataDeMatricula;
    }

    @Override
    public Endereco getEndereco() {
        return endereco;
    }

    @Override
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "codigoDeMatricula='" + codigoDeMatricula + '\'' +
                ", nome='" + nome + '\'' +
                ", dataDeNascimento=" + dataDeNascimento +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", dataDeMatricula=" + dataDeMatricula +
                ", endereco=" + endereco +
                '}';
    }
}
