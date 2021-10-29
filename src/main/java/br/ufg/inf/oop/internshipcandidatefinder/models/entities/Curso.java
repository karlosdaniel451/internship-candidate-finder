package br.ufg.inf.oop.internshipcandidatefinder.models.entities;

import java.util.List;

public class Curso implements Enderecavel {
    private static int numberOfCreatedObjects = 0;

    private int id;
    private String nome;
    private String sigla;
    private int numeroVagasAnuais;
    private short cargaHoraria;
    private short duracaoEmSemestres;
    private Endereco endereco;
    private List<Aluno> alunos;

    public Curso(String nome, String sigla, int numeroVagasAnuais, short cargaHoraria,
                 short duracaoEmSemestres, Endereco enderecoDaSede) {
        Curso.numberOfCreatedObjects++;

        this.id = numberOfCreatedObjects;
        this.nome = nome;
        this.sigla = sigla;
        this.numeroVagasAnuais = numeroVagasAnuais;
        this.cargaHoraria = cargaHoraria;
        this.duracaoEmSemestres = duracaoEmSemestres;
        this.endereco = enderecoDaSede;
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

    public int getNumeroVagasAnuais() {
        return numeroVagasAnuais;
    }

    public void setNumeroVagasAnuais(int numeroVagasAnuais) {
        this.numeroVagasAnuais = numeroVagasAnuais;
    }

    public short getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(short cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public short getDuracaoEmSemestres() {
        return duracaoEmSemestres;
    }

    public void setDuracaoEmSemestres(short duracaoEmSemestres) {
        this.duracaoEmSemestres = duracaoEmSemestres;
    }

    @Override
    public Endereco getEndereco() {
        return endereco;
    }

    @Override
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void addAluno(Aluno aluno) {
        if (alunos.contains(aluno)) {
            throw new IllegalArgumentException("Tentativa de adicionar um aluno ja existente na" +
                    "lista de alunos.");
        }

        alunos.add(aluno);
    }

    @Override
    public String toString() {
        return "Curso{" +
                "nome='" + nome + '\'' +
                ", sigla='" + sigla + '\'' +
                ", numeroVagasAnuais=" + numeroVagasAnuais +
                ", cargaHoraria=" + cargaHoraria +
                ", duracaoEmSemestres=" + duracaoEmSemestres +
                ", enderecoDaSede=" + endereco +
                ", alunos=" + alunos +
                '}';
    }
}
