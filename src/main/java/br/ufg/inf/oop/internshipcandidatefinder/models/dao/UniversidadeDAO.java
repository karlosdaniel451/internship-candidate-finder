package br.ufg.inf.oop.internshipcandidatefinder.models.dao;

import br.ufg.inf.oop.internshipcandidatefinder.models.entities.Endereco;
import br.ufg.inf.oop.internshipcandidatefinder.models.entities.Universidade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UniversidadeDAO implements DAO<Universidade> {
    private Connection connection;
    private EnderecoDAO enderecoDAO;

    public UniversidadeDAO() throws SQLException {
        this.connection = ConnectionFactory.getConnectionFactory();
        this.enderecoDAO = new EnderecoDAO();
    }

    @Override
    public void inserir(Universidade universidade) {
        String SQL = String.format("INSERT INTO %s (id, nome, sigla, cnpj, telefone, " +
                "endereco_id) values (?, ?, ?, ?, ?, ?)", getNomeDaTabela());

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, universidade.getId());
            preparedStatement.setString(2, universidade.getNome());
            preparedStatement.setString(3, universidade.getSigla());
            preparedStatement.setString(4, universidade.getCnpj());
            preparedStatement.setString(5, universidade.getTelefone());
            preparedStatement.setInt(6, universidade.getEndereco().getId());

            preparedStatement.executeUpdate();

            preparedStatement.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    @Override
    public void atualizar(Universidade universidade) {
        String SQL = String.format("UPDATE %s SET nome = ?, sigla = ?, cnpj = ?, telefone = ?," +
                "endereco_id = ?", getNomeDaTabela());

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, universidade.getNome());
            preparedStatement.setString(2, universidade.getSigla());
            preparedStatement.setString(3, universidade.getCnpj());
            preparedStatement.setString(4, universidade.getTelefone());
            preparedStatement.setInt(5, universidade.getEndereco().getId());

            preparedStatement.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    @Override
    public Universidade buscar(int id) {
        Universidade universidade = null;

        String SQL = String.format("SELECT * FROM \"%s\" WHERE id = ?", getNomeDaTabela());

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.first()) {
                String nome = resultSet.getString("nome");
                String sigla = resultSet.getString("sigla");
                String cnpj = resultSet.getString("cnpj");
                String telefone = resultSet.getString("telefone");
                Endereco endereco = enderecoDAO.buscar(resultSet.getInt("endereco_id"));

                universidade = new Universidade(nome, sigla, cnpj, telefone, endereco);
            }

            resultSet.close();
            preparedStatement.close();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return universidade;
    }

    @Override
    public List<Universidade> buscarTudo() {
        List<Universidade> universidades = new ArrayList<>();
        String SQL = String.format("SELECT * FROM \"%s\"", getNomeDaTabela());

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String sigla = resultSet.getString("sigla");
                String cnpj = resultSet.getString("cnpj");
                String telefone = resultSet.getString("telefone");
                Endereco endereco = enderecoDAO.buscar(resultSet.getInt("endereco_id"));

                universidades.add(new Universidade(nome, sigla, cnpj, telefone, endereco));
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return universidades;
    }

    @Override
    public void remover(int id) {
        String SQL = String.format("DELETE FROM \"%s\" where id = ?", getNomeDaTabela());

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setInt(1, id);

            preparedStatement.execute();

            preparedStatement.close();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    @Override
    public String getNomeDaTabela() {
        return "Universidade";
    }

}
