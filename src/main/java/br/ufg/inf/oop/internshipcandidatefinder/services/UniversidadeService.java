package br.ufg.inf.oop.internshipcandidatefinder.services;

import br.ufg.inf.oop.internshipcandidatefinder.exceptions.InvalidInputFromUserException;
import br.ufg.inf.oop.internshipcandidatefinder.exceptions.NotFoundException;
import br.ufg.inf.oop.internshipcandidatefinder.models.dao.EnderecoDAO;
import br.ufg.inf.oop.internshipcandidatefinder.models.dao.UniversidadeDAO;
import br.ufg.inf.oop.internshipcandidatefinder.models.entities.Endereco;
import br.ufg.inf.oop.internshipcandidatefinder.models.entities.UnidadeFederativa;
import br.ufg.inf.oop.internshipcandidatefinder.models.entities.Universidade;
import br.ufg.inf.oop.internshipcandidatefinder.views.MainView;
import java.security.InvalidParameterException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UniversidadeService {

    private static UniversidadeService instance;

    UniversidadeDAO universidadeDAO;
    EnderecoDAO enderecoDAO;

    private UniversidadeService() throws SQLException {
        this.universidadeDAO = new UniversidadeDAO();
        this.enderecoDAO = new EnderecoDAO();
    }

    public static synchronized UniversidadeService getInstance() throws Exception {
        if (instance == null) {
            instance = new UniversidadeService();
        }
        return instance;
    }

    /*public UniversidadeService() throws Exception {
        this.universidadeDAO = new UniversidadeDAO();
        this.enderecoDAO = new EnderecoDAO();
    }*/
    public void inserirUniversidade(Universidade universidade, Endereco endereco) throws InvalidParameterException,
            InvalidInputFromUserException, Exception {

        validarInsercaoUniversidade(universidade);

        enderecoDAO.inserir(endereco);

        universidadeDAO.inserir(universidade);

        //Endereco.numberOfCreatedObjects++;
        //Universidade.numberOfCreatedObjects++;
    }

    public void validarInsercaoUniversidade(Universidade universidade) throws InvalidParameterException,
            InvalidInputFromUserException, IllegalArgumentException, Exception {

        if (universidadeENula(universidade)) {
            throw new InvalidParameterException("Tentativa de inserir uma Universidade nula.");
        }

        if (universidade.getId() <= 0) {
            throw new InvalidInputFromUserException("O id da Universidade deve ser maior do que 0.");
        }

        if (universidade.getNome() == null || universidade.getNome().isBlank()) {
            throw new InvalidInputFromUserException("O nome da Universidade é invalido.");
        }

        if (universidade.getSigla() == null || universidade.getSigla().isBlank()) {
            throw new InvalidInputFromUserException("A sigla da Universidade é invalida.");
        }

        if (universidade.getCnpj() == null || universidade.getCnpj().isBlank()) {
            throw new InvalidInputFromUserException("O cnpj da Universidade é invalido.");
        }

        if (universidade.getTelefone() == null || universidade.getTelefone().isBlank()) {
            throw new InvalidInputFromUserException("O telefone da Universidade é invalido.");
        }

        if (universidade.getEndereco() == null) {
            throw new InvalidInputFromUserException("O endereco da Universidade é invalido.");
        }

        if (universidade.getEndereco() == null) {
            throw new InvalidInputFromUserException("A sigla da UF digitada é inválida.");
        }

        try {
            buscarUniversidadePorId(universidade.getId());

        } catch (NotFoundException ex) {
            // Nao faz nada, ja que a `universidade` nao existe no banco de dados.
        }

        if (contains(universidade.getId())) {
            MainView.reportInternalError(null, new IllegalArgumentException("Já existe uma Universidade com o id "
                    + universidade.getId()));
        }
    }

    public boolean contains(int id) throws Exception {
        try {
            buscarUniversidadePorId(id);
            return true;
        } catch (NotFoundException ex) {
            return false;
        }
    }

    public Universidade buscarUniversidadePorId(int id) throws NotFoundException, Exception {
        Universidade universidade = universidadeDAO.buscar(id);

        return universidade;
    }

    public List<Universidade> buscarUniversidadePorNome(String nome) throws Exception, NotFoundException {
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

    public List<Universidade> buscarTodasUniversidades() throws NotFoundException, Exception {
        List<Universidade> todasUniversidades;

        todasUniversidades = universidadeDAO.buscarTudo();

        if (todasUniversidades.isEmpty()) {
            throw new NotFoundException("Não há nenhuma Universidade cadastrada.");
        }

        return todasUniversidades;
    }

    public void atualizarUniversidade(Universidade universidade) throws IllegalArgumentException, Exception {
        if (!contains(universidade.getId())) {
            throw new IllegalArgumentException("Não existe nenhuma Universidade com o id "
                    + universidade.getId());
        }

        enderecoDAO.atualizar(universidade.getEndereco());
        universidadeDAO.atualizar(universidade);
    }

    public void removerUniversidadePorId(int id) throws IllegalArgumentException, Exception {
        try {
            Universidade universidadeASerRemovida = buscarUniversidadePorId(id);
            Endereco enderecoASerRemovido = enderecoDAO.buscar(universidadeASerRemovida.getId());

            universidadeDAO.remover(id);
            enderecoDAO.remover(enderecoASerRemovido.getId());

        } catch (Exception ex) {
            //throw new IllegalArgumentException("Não existe nenhuma Universidade com o id " + id);
            throw ex;
        }

    }

    public boolean universidadeENula(Universidade universidade) {
        return universidade == null;
    }
}
