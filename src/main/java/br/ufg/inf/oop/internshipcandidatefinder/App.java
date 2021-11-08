package br.ufg.inf.oop.internshipcandidatefinder;

//import br.ufg.inf.oop.internshipcandidatefinder.services.UniversidadeService;
//import br.ufg.inf.oop.internshipcandidatefinder.exceptions.NotFoundException;
//import br.ufg.inf.oop.internshipcandidatefinder.models.entities.Universidade;
import br.ufg.inf.oop.internshipcandidatefinder.services.AppService;
import br.ufg.inf.oop.internshipcandidatefinder.views.MainView;

public class App {

    private static AppService appService;
    private static MainView mainView;

    public static void main(String[] args) {

        try {
            appService = new AppService();
            appService.synchronizeAppWithDatabase();

            mainView = new MainView();
            mainView.setVisible(true);

        } catch (Exception ex) {
            MainView.reportInternalError(null, ex);

        }
    }
}
