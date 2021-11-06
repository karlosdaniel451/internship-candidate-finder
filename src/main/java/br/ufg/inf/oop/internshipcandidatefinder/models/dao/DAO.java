package br.ufg.inf.oop.internshipcandidatefinder.models.dao;

import br.ufg.inf.oop.internshipcandidatefinder.exceptions.NotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;

public interface DAO<T> {

    void inserir(T t) throws SQLException;

    void atualizar(T t);

    T buscar(int id) throws SQLException, NotFoundException;

    List<T> buscarTudo();

    void remover(int id);

    String getNomeDaTabela();

    default int getNumberOfInsertedRecords() throws SQLException {
        int numberOfInstertedRegisters;
        String SQL = String.format("SELECT MAX(id) FROM \"%s\"", getNomeDaTabela());

        PreparedStatement preparedStatement = ConnectionFactory.getConnectionFactory().prepareStatement(SQL);
        ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.next();

        numberOfInstertedRegisters = resultSet.getInt("max");

        return numberOfInstertedRegisters;
    }

}
