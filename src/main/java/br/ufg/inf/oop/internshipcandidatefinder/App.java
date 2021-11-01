package br.ufg.inf.oop.internshipcandidatefinder;

import br.ufg.inf.oop.internshipcandidatefinder.services.UniversidadeService;
import br.ufg.inf.oop.internshipcandidatefinder.exceptions.NotFoundException;
import br.ufg.inf.oop.internshipcandidatefinder.models.entities.Universidade;
import br.ufg.inf.oop.internshipcandidatefinder.views.MainView;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {
    public static void main(String[] args) {
        try {
            //System.out.println("Hello, world!");
            
            /*List<Universidade> todasUniversidades = new ArrayList<>();
            try {
            UniversidadeService universidadeService = new UniversidadeService();

            todasUniversidades = universidadeService.buscarTodasUniversidades();

            JOptionPane.showMessageDialog(null,todasUniversidades.get(0));
            } catch (SQLException | NotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO!", JOptionPane.ERROR_MESSAGE);
            }*/
            new MainView().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Mensagem de erro: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }
}
