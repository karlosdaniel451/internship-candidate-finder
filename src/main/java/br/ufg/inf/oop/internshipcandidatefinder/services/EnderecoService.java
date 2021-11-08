/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufg.inf.oop.internshipcandidatefinder.services;

import br.ufg.inf.oop.internshipcandidatefinder.exceptions.InvalidInputFromUserException;
import br.ufg.inf.oop.internshipcandidatefinder.exceptions.NotFoundException;
import br.ufg.inf.oop.internshipcandidatefinder.models.dao.EnderecoDAO;
import br.ufg.inf.oop.internshipcandidatefinder.models.entities.Endereco;
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

    public void inserirEndereco(Endereco endereco) throws IllegalArgumentException,
            InvalidInputFromUserException, SQLException {

        validarInsercaoEndereco(endereco);

        enderecoDAO.inserir(endereco);

        Endereco.numberOfCreatedObjects++;
    }

    public void validarInsercaoEndereco(Endereco endereco) throws IllegalArgumentException,
            InvalidInputFromUserException {

        if (endereco == null) {
            throw new IllegalArgumentException("Tentativa de inserir um Endereco nulo.");
        }
    }

    public boolean contains(int id) throws Exception {
        try {
            buscarEnderecoPorId(id);
            return true;
        } catch (NotFoundException ex) {
            return false;
        }
    }

    public Endereco buscarEnderecoPorId(int id) throws NotFoundException, Exception {
        Endereco endereco = enderecoDAO.buscar(id);

        return endereco;
    }
}
