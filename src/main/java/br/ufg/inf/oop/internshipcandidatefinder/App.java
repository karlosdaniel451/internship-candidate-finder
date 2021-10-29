package br.ufg.inf.oop.internshipcandidatefinder;

import br.ufg.inf.oop.internshipcandidatefinder.controllers.UniversidadeController;
import br.ufg.inf.oop.internshipcandidatefinder.exceptions.NotFoundException;
import br.ufg.inf.oop.internshipcandidatefinder.models.entities.Universidade;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        //System.out.println("Hello, world!");

        List<Universidade> todasUniversidades = new ArrayList<>();
        try {
            UniversidadeController universidadeController = new UniversidadeController();

            todasUniversidades = universidadeController.buscarTodasUniversidades();

            JOptionPane.showMessageDialog(null,todasUniversidades.get(0));
        } catch (SQLException | NotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO!", JOptionPane.ERROR_MESSAGE);
        }
    }
}
