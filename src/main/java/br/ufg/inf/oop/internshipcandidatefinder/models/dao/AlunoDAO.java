/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufg.inf.oop.internshipcandidatefinder.models.dao;

import br.ufg.inf.oop.internshipcandidatefinder.models.entities.Aluno;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author karlos
 */
public class AlunoDAO implements DAO<Aluno> {
    
    public void inserir(Aluno t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void atualizar(Aluno t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Aluno buscar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<Aluno> buscarTudo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void remover(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String getNomeDaTabela() {
        return "Aluno";
    }
    
}
