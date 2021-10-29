package br.ufg.inf.oop.internshipcandidatefinder.models.dao;

import br.ufg.inf.oop.internshipcandidatefinder.exceptions.NotFoundException;

import java.util.List;

public interface DAO<T> {
    void inserir(T t);

    void atualizar(T t);

    T buscar(int id);

    List<T> buscarTudo();

    void remover(int id);

    String getNomeDaTabela();
}
