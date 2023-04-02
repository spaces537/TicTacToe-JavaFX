package view.Topscores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.HighscoreEntry;
import model.TicTacToeModel;
import view.Speelveld.SpeelveldPresenter;
import view.Speelveld.SpeelveldView;
import view.Spelregels.SpelregelsPresenter;
import view.Spelregels.SpelregelsView;
import view.StartScherm.StartschermPresenter;
import view.StartScherm.StartschermView;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Collections;

public class TopscoresPresenter {
    private TopscoresView view;
    private TicTacToeModel model;

    public TopscoresPresenter(TopscoresView view, TicTacToeModel model) {
        this.model = model;
        this.view = view;
        this.addEventHandlers();
        this.updateView();
    }

    private void addEventHandlers() {
        view.getBtnTerugNaarHoofdMenu().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TicTacToeModel model = new TicTacToeModel(null);
                StartschermView startschermView = new StartschermView();
                StartschermPresenter presenter = new StartschermPresenter(startschermView,model);
                Stage startSchermStage = new Stage();
                startSchermStage.initOwner(view.getScene().getWindow());
                startSchermStage.initModality(Modality.WINDOW_MODAL);
                startSchermStage.setScene(new Scene(startschermView));
                startSchermStage.setX(view.getScene().getWindow().getX());
                startSchermStage.setY(view.getScene().getWindow().getY());
                ((Stage)view.getScene().getWindow()).close();
                startSchermStage.setMaximized(true);
                startSchermStage.show();
            }
        });

/* Koppelt event handlers (
        anon.inner klassen)
// aan de
        controls uit de view.
// Event handlers: roepen methodes aan uit het
// model en zorgen voor een update van de view. */
    }

    private void updateView()  {

            model.fillHighscores();
            for (int i = 0; i < model.getHighscoreEntryList().size(); i++) {
                HighscoreEntry entry = model.getHighscoreEntryList().get(i);
                Label setLblplaats = (new Label(Integer.toString(i + 1)));
                Label setLblplayer = (new Label(entry.getSpelernaam()));
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
                Label setlblStartDatum = (new Label(entry.getStartTijdSpel().format(formatter).toString()));
                Label setlblScore = (new Label(Integer.toString(entry.getTijd())+ " seconden" ));

                view.getScoreBordPane().add(setLblplaats, 0, i + 1);
                view.getScoreBordPane().add(setLblplayer, 1, i + 1);
                view.getScoreBordPane().add(setlblStartDatum, 2, i + 1);
                view.getScoreBordPane().add(setlblScore, 3, i + 1);

            }


    }


    // Vult de view met data uit model
    public void addWindowEventHandlers() {
    }


    /*Window event
    handlers anon .
    inner klassen)
    // Koppeling via
    view.getScene getWindow */
}

