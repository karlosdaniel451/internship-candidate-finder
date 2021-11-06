package br.ufg.inf.oop.internshipcandidatefinder.models.entities;

import java.util.ArrayList;
import java.util.List;

public class Universidade implements Enderecavel {

    public static int numberOfCreatedObjects = 0;

    private int id;
    private String nome;
    private String sigla;
    private String cnpj;
    private String telefone;
    private Endereco endereco;
    private List<Curso> cursos = new ArrayList<>();

    public Universidade() {

    }

    public Universidade(String nome, String sigla, String cnpj, String telefone, Endereco endereco) {
        Universidade.numberOfCreatedObjects++;
        this.id = numberOfCreatedObjects;
        this.nome = nome;
        this.sigla = sigla;
        this.cnpj = cnpj;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public Endereco getEndereco() {
        return endereco;
    }

    @Override
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void addCurso(Curso curso) {
        if (cursos.contains(curso)) {
            throw new IllegalArgumentException("Tentativa de adicionar um curso ja existente na"
                    + "lista de cursos.");
        }

        cursos.add(curso);
    }

    @Override
    public String toString() {
        return String.format("%s - %s.\nCNPJ: %s.\nTelefone: %s.\nEndereço: %s\nNúmero de cursos: %d",
                nome, sigla, cnpj, telefone, endereco, cursos.size());
    }
}
