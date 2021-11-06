package br.ufg.inf.oop.internshipcandidatefinder;

//import br.ufg.inf.oop.internshipcandidatefinder.services.UniversidadeService;
//import br.ufg.inf.oop.internshipcandidatefinder.exceptions.NotFoundException;
//import br.ufg.inf.oop.internshipcandidatefinder.models.entities.Universidade;
import br.ufg.inf.oop.internshipcandidatefinder.services.AppService;
import br.ufg.inf.oop.internshipcandidatefinder.views.MainView;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {

    private static AppService appService;
    private static MainView mainView;

    public static void main(String[] args) {

        try {
            appService = new AppService();
            appService.synchronizeAppWithDatabase();

            new MainView().setVisible(true);

        } catch (Exception ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,
                    "Não foi possível iniciar o programa pois houve um erro interno."
                    + " Se desejar, contate o suporte explicitando "
                    + "a mensagem de erro abaixo:\n\n " + ex.getMessage(),
                    "ERRO INTERNO", JOptionPane.ERROR_MESSAGE);
        }
    }
}
