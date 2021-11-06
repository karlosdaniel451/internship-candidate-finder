/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufg.inf.oop.internshipcandidatefinder.services;

import br.ufg.inf.oop.internshipcandidatefinder.exceptions.InvalidInputFromUserException;
import br.ufg.inf.oop.internshipcandidatefinder.models.dao.EnderecoDAO;
import br.ufg.inf.oop.internshipcandidatefinder.models.entities.Endereco;
import java.security.InvalidParameterException;
import java.sql.SQLException;

/**
 *
 * @author karlos
 */
public class EnderecoService {

    EnderecoDAO enderecoDAO;

    public EnderecoService() throws Exception {
        this.enderecoDAO = new EnderecoDAO();
    }

    public void inserirEndereco(Endereco endereco) throws InvalidParameterException,
            InvalidInputFromUserException, SQLException {

        validarInsercaoEndereco(endereco);

        enderecoDAO.inserir(endereco);

        Endereco.numberOfCreatedObjects++;
    }

    public void validarInsercaoEndereco(Endereco endereco) throws InvalidParameterException,
            InvalidInputFromUserException {

        if (endereco == null) {
            throw new InvalidParameterException("Tentativa de inserir um Endereco nulo.");
        }
    }
}
