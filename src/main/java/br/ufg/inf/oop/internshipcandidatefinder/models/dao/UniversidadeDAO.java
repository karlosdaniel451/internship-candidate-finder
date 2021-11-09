package br.ufg.inf.oop.internshipcandidatefinder.models.dao;

import br.ufg.inf.oop.internshipcandidatefinder.exceptions.NotFoundException;
import br.ufg.inf.oop.internshipcandidatefinder.models.entities.Endereco;
import br.ufg.inf.oop.internshipcandidatefinder.models.entities.Universidade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UniversidadeDAO implements DAO<Universidade> {

    private Connection connection;
    private EnderecoDAO enderecoDAO;

    public UniversidadeDAO() throws SQLException {
        this.connection = ConnectionFactory.getConnectionFactory();
        this.enderecoDAO = new EnderecoDAO();
    }

    @Override
    public void inserir(Universidade universidade) throws SQLException {
        String SQL = String.format("INSERT INTO \"%s\" (id, nome, sigla, cnpj, telefone, "
                + "endereco_id) values (?, ?, ?, ?, ?, ?)", getNomeDaTabela());

        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setInt(1, universidade.getId());
        preparedStatement.setString(2, universidade.getNome());
        preparedStatement.setString(3, universidade.getSigla());
        preparedStatement.setString(4, universidade.getCnpj());
        preparedStatement.setString(5, universidade.getTelefone());
        preparedStatement.setInt(6, universidade.getEndereco().getId());

        preparedStatement.executeUpdate();

        preparedStatement.close();
    }

    @Override
    public void atualizar(Universidade universidade) throws SQLException {
        String SQL = String.format("UPDATE \"%s\" SET nome = ?, sigla = ?, cnpj = ?, telefone = ? where id = ?",
                getNomeDaTabela());

        PreparedStatement preparedStatement = connection.prepareStatement(SQL);

        preparedStatement.setString(1, universidade.getNome());
        preparedStatement.setString(2, universidade.getSigla());
        preparedStatement.setString(3, universidade.getCnpj());
        preparedStatement.setString(4, universidade.getTelefone());
        preparedStatement.setInt(5, universidade.getId());

        preparedStatement.executeUpdate();

        preparedStatement.close();

    }

    @Override
    public Universidade buscar(int id) throws SQLException, NotFoundException, Exception {
        Universidade universidade = null;

        String SQL = String.format("SELECT * FROM \"%s\" WHERE id = ?", getNomeDaTabela());

        PreparedStatement preparedStatement = connection.prepareStatement(SQL);

        preparedStatement.setInt(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            universidade = new Universidade();

            universidade.setId(resultSet.getInt("id"));
            //String nome = resultSet.getString("nome");
            universidade.setNome(resultSet.getString("nome"));
            //String sigla = resultSet.getString("sigla");
            universidade.setSigla(resultSet.getString("sigla"));
            //String cnpj = resultSet.getString("cnpj");
            universidade.setCnpj(resultSet.getString("cnpj"));
            //String telefone = resultSet.getString("telefone");
            universidade.setTelefone(resultSet.getString("telefone"));
            //Endereco endereco = enderecoDAO.buscar(resultSet.getInt("endereco_id"));
            universidade.setEndereco(enderecoDAO.buscar(resultSet.getInt("endereco_id")));

        }

        resultSet.close();
        preparedStatement.close();

        if (universidade == null) {
            throw new NotFoundException("Não foi encontrada nenhuma Universidade com o id " + id + " .");
        }

        return universidade;
    }

    @Override
    public List<Universidade> buscarTudo() throws SQLException, Exception {
        List<Universidade> universidades = new ArrayList<>();
        Universidade universidade;

        String SQL = String.format("SELECT * FROM \"%s\"", getNomeDaTabela());

        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            universidade = new Universidade();

            universidade.setId(resultSet.getInt("id"));
            //String nome = resultSet.getString("nome");
            universidade.setNome(resultSet.getString("nome"));
            //String sigla = resultSet.getString("sigla");
            universidade.setSigla(resultSet.getString("sigla"));
            //String cnpj = resultSet.getString("cnpj");
            universidade.setCnpj(resultSet.getString("cnpj"));
            //String telefone = resultSet.getString("telefone");
            universidade.setTelefone(resultSet.getString("telefone"));
            //endereco = enderecoDAO.buscar(resultSet.getInt("endereco_id"));
            universidade.setEndereco(enderecoDAO.buscar(resultSet.getInt("endereco_id")));

            universidades.add(universidade);
        }

        return universidades;
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
        return "Universidade";
    }

    public List<Universidade> buscarPorNome(String nome) throws SQLException, Exception {
        List<Universidade> universidades = new ArrayList<>();
        Universidade universidade;

        String SQL = String.format("SELECT * FROM \"%s\" WHERE nome ILIKE '%%%s%%'", getNomeDaTabela(), nome);

        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            universidade = new Universidade();
            universidade.setId(resultSet.getInt("id"));
            //String nomeUniversidade = resultSet.getString("nome");
            universidade.setNome(resultSet.getString("nome"));
            //String sigla = resultSet.getString("sigla");
            universidade.setSigla(resultSet.getString("sigla"));
            //String cnpj = resultSet.getString("cnpj");
            universidade.setCnpj(resultSet.getString("cnpj"));
            //String telefone = resultSet.getString("telefone");
            universidade.setTelefone(resultSet.getString("telefone"));
            //Endereco endereco = enderecoDAO.buscar(resultSet.getInt("endereco_id"));
            universidade.setEndereco(enderecoDAO.buscar(resultSet.getInt("endereco_id")));

            universidades.add(universidade);
        }

        return universidades;

    }

    /*public int getNumberOfInsertedRecords() throws SQLException {
        int numberOfInstertedRegisters = 0;
        String SQL = String.format("SELECT MAX(id) FROM \"%s\"", getNomeDaTabela());

        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.next();
        
        numberOfInstertedRegisters = resultSet.getInt("max");

        return numberOfInstertedRegisters;
    }*/
}
