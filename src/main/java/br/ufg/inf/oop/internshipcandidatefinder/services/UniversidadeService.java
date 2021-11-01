package br.ufg.inf.oop.internshipcandidatefinder.services;

import br.ufg.inf.oop.internshipcandidatefinder.exceptions.NotFoundException;
import br.ufg.inf.oop.internshipcandidatefinder.models.dao.UniversidadeDAO;
import br.ufg.inf.oop.internshipcandidatefinder.models.entities.Universidade;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UniversidadeService {

    UniversidadeDAO universidadeDAO;

    public UniversidadeService() throws SQLException {
        this.universidadeDAO = new UniversidadeDAO();
    }

    public void inserirUniversidade(Universidade universidade) throws Exception {
        try {
            validarInsercaoUniversidade(universidade);
        } catch (Exception exception) {
            throw new Exception(exception);
        }

        universidadeDAO.inserir(universidade);
    }

    public void validarInsercaoUniversidade(Universidade universidade) throws Exception {
        if (universidadeENula(universidade)) {
            throw new IllegalArgumentException("Tentativa de inserir uma Universidade nula.");
        }

        if (universidade.getId() <= 0) {
            throw new IllegalArgumentException("O id da Universidade deve ser maior do");
        }

        if (universidade.getNome() == null || universidade.getNome().isBlank()) {
            throw new IllegalArgumentException("O nome da Universidade é invalido.");
        }

        if (universidade.getSigla() == null || universidade.getSigla().isBlank()) {
            throw new IllegalArgumentException("A sigla da Universidade é invalida.");
        }

        if (universidade.getCnpj() == null || universidade.getCnpj().isBlank()) {
            throw new IllegalArgumentException("O cnpj da Universidade é invalido.");
        }

        if (universidade.getTelefone() == null || universidade.getTelefone().isBlank()) {
            throw new IllegalArgumentException("O telefone da Universidade é invalido.");
        }

        if (universidade.getEndereco() == null) {
            throw new IllegalArgumentException("O endereco da Universidade é invalido.");
        }

        if (universidadeDAO.buscar(universidade.getId()) != null) {
            throw new IllegalArgumentException("Ja existe essa universidade.");
        }
    }

    public Universidade buscarUniversidadePorId(int id) throws NotFoundException {
        Universidade universidade = universidadeDAO.buscar(id);

        if (universidade == null) {
            throw new NotFoundException("Id inválido.");
        }

        return universidade;
    }

    public List<Universidade> buscarUniversidadePorNome(String nome) throws NotFoundException {
        List<Universidade> universidadesBuscadas = new ArrayList<>();

        if (nome.isBlank()) {
            return buscarTodasUniversidades();
        }

        universidadesBuscadas = universidadeDAO.buscarPorNome(nome);

        if (universidadesBuscadas.isEmpty()) {
            throw new NotFoundException("Não foi encontrada nenhuma Universidade.");
        }

        return universidadesBuscadas;
    }

    public List<Universidade> buscarTodasUniversidades() throws NotFoundException {
        List<Universidade> todasUniversidades;

        todasUniversidades = universidadeDAO.buscarTudo();

        if (todasUniversidades.isEmpty()) {
            throw new NotFoundException("Não há nenhuma Universidade cadastrada");
        }

        return todasUniversidades;
    }

    public boolean universidadeENula(Universidade universidade) {
        return universidade == null;
    }
}
