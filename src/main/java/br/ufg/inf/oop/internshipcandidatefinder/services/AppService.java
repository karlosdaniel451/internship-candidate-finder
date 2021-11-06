/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufg.inf.oop.internshipcandidatefinder.services;

import br.ufg.inf.oop.internshipcandidatefinder.models.dao.AlunoDAO;
import br.ufg.inf.oop.internshipcandidatefinder.models.dao.CursoDAO;
import br.ufg.inf.oop.internshipcandidatefinder.models.dao.EnderecoDAO;
import br.ufg.inf.oop.internshipcandidatefinder.models.dao.UniversidadeDAO;
import br.ufg.inf.oop.internshipcandidatefinder.models.entities.Aluno;
import br.ufg.inf.oop.internshipcandidatefinder.models.entities.Curso;
import br.ufg.inf.oop.internshipcandidatefinder.models.entities.Endereco;
import br.ufg.inf.oop.internshipcandidatefinder.models.entities.Universidade;

/**
 *
 * @author karlos
 */
public class AppService {

    private UniversidadeDAO universidadeDAO;
    private CursoDAO cursoDAO;
    private AlunoDAO alunoDAO;
    private EnderecoDAO enderecoDAO;

    public void synchronizeAppWithDatabase() throws Exception {
        universidadeDAO = new UniversidadeDAO();
        cursoDAO = new CursoDAO();
        alunoDAO = new AlunoDAO();
        enderecoDAO = new EnderecoDAO();

        Universidade.numberOfCreatedObjects = universidadeDAO.getNumberOfInsertedRecords();
        Curso.numberOfCreatedObjects = cursoDAO.getNumberOfInsertedRecords();
        Aluno.numberOfCreatedObjects = alunoDAO.getNumberOfInsertedRecords();
        Endereco.numberOfCreatedObjects = enderecoDAO.getNumberOfInsertedRecords();
    }

}
