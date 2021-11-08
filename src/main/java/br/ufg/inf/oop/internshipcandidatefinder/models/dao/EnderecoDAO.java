package br.ufg.inf.oop.internshipcandidatefinder.models.dao;

import br.ufg.inf.oop.internshipcandidatefinder.exceptions.NotFoundException;
import br.ufg.inf.oop.internshipcandidatefinder.models.entities.Endereco;
import br.ufg.inf.oop.internshipcandidatefinder.models.entities.UnidadeFederativa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EnderecoDAO implements DAO<Endereco> {

    private Connection connection;

    public EnderecoDAO() throws SQLException {
        this.connection = ConnectionFactory.getConnectionFactory();
    }

    @Override
    public void inserir(Endereco endereco) {
        String SQL = String.format("INSERT INTO \"%s\" values (?, ?, ?, ?, ?, ?)", getNomeDaTabela());

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setInt(1, endereco.getId());
            preparedStatement.setString(2, endereco.getCep());
            preparedStatement.setString(3, endereco.getLogradouro());
            preparedStatement.setString(4, endereco.getBairro());
            preparedStatement.setString(5, endereco.getMunicipio());
            preparedStatement.setString(6, endereco.getUnidadeFedrativa().getSigla());

            preparedStatement.executeUpdate();

            preparedStatement.close();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    @Override
    public void atualizar(Endereco endereco) {

    }

    @Override
    public Endereco buscar(int id) throws SQLException, NotFoundException {
        Endereco endereco = null;

        String SQL = String.format("SELECT * FROM \"%s\" WHERE id = ?", getNomeDaTabela());

        PreparedStatement preparedStatement = connection.prepareStatement(SQL,
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE);

        preparedStatement.setInt(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.first()) {
            endereco = new Endereco();
            
            endereco.setId(resultSet.getInt("id"));
            //String cep = resultSet.getString("cep");
            endereco.setCep(resultSet.getString("cep"));
            //String logradouro = resultSet.getString("logradouro");
            endereco.setLogradouro(resultSet.getString("logradouro"));
            //String bairro = resultSet.getString("bairro");
            endereco.setBairro(resultSet.getString("bairro"));
            //String municipio = resultSet.getString("municipio");
            endereco.setMunicipio(resultSet.getString("municipio"));
            //UnidadeFederativa uf = UnidadeFederativa.fromSigla(resultSet.getString("sigla_da_unidade_federativa"));
            endereco.setUnidadeFedrativa(UnidadeFederativa.fromSigla(resultSet.getString("sigla_da_unidade_federativa")));
        }

        resultSet.close();
        preparedStatement.close();

        if (endereco == null) {
            throw new NotFoundException("Não foi encontrada nenhum Endereço com o id " + id + " .");
        }

        return endereco;
    }

    @Override
    public List<Endereco> buscarTudo() {
        return null;
    }

    @Override
    public void remover(int id) throws SQLException {
        String SQL = String.format("DELETE FROM \"%s\" where id = ?", getNomeDaTabela());

        PreparedStatement preparedStatement = connection.prepareStatement(SQL);

        preparedStatement.setInt(1, id);

        preparedStatement.execute();

        preparedStatement.close();
    }

    @Override
    public String getNomeDaTabela() {
        return "Endereco";
    }
}
