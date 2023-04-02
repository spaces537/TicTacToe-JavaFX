package view.StartScherm;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.TicTacToeModel;
import view.Hoofdmenu.HoofdmenuPresenter;
import view.Hoofdmenu.HoofdmenuView;
import view.Speelveld.SpeelveldPresenter;
import view.Speelveld.SpeelveldView;
import view.Spelregels.SpelregelsPresenter;
import view.Spelregels.SpelregelsView;
import view.Topscores.TopscoresPresenter;
import view.Topscores.TopscoresView;

public class StartschermPresenter {
    private TicTacToeModel model;

    private StartschermView view;

    public StartschermPresenter(StartschermView view,TicTacToeModel model) {
        this.model = model;
        this.view = view;
        this.addEventHandlers();
        this.updateView();
    }

    private void addEventHandlers() {
        view.getBtnTopScores().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                TopscoresView topscoresView = new TopscoresView();
                TicTacToeModel ticTacToeModel = new TicTacToeModel(null);
                TopscoresPresenter topscoresPresenter = new TopscoresPresenter(topscoresView,ticTacToeModel);
                Stage topScoresStage = new Stage();
                topScoresStage.getIcons().add(new Image("TicTacToeLogo.jpg"));
                topScoresStage.initOwner(view.getScene().getWindow());
                topScoresStage.initModality(Modality.WINDOW_MODAL);
                topScoresStage.setScene(new Scene(topscoresView));
                topScoresStage.setX(view.getScene().getWindow().getX());
                topScoresStage.setY(view.getScene().getWindow().getY());
                ((Stage)view.getScene().getWindow()).close();
                topScoresStage.setMaximized(true);
                topScoresStage.show();


            }
        });
        view.getBtnSpelRegels().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                SpelregelsView spelregelsView = new SpelregelsView();
                SpelregelsPresenter spelregelsPresenter = new SpelregelsPresenter(spelregelsView);
                Stage spelRegelsStage = new Stage();
                spelRegelsStage.getIcons().add(new Image("TicTacToeLogo.jpg"));
                spelRegelsStage.initOwner(view.getScene().getWindow());
                spelRegelsStage.initModality(Modality.WINDOW_MODAL);
                spelRegelsStage.setScene(new Scene(spelregelsView));
                spelRegelsStage.setX(view.getScene().getWindow().getX());
                spelRegelsStage.setY(view.getScene().getWindow().getY());
                ((Stage)view.getScene().getWindow()).close();
                spelRegelsStage.setMaximized(true);
                spelRegelsStage.show();



            }
        });
        view.getBtnNewGame().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                TicTacToeModel model = new TicTacToeModel(null);
                HoofdmenuView hoofdmenuView = new HoofdmenuView();
                HoofdmenuPresenter hoofdmenuPresenter = new HoofdmenuPresenter(hoofdmenuView);
                Stage hoofdmenuStage = new Stage();
                hoofdmenuStage.getIcons().add(new Image("TicTacToeLogo.jpg"));
                hoofdmenuStage.initOwner(view.getScene().getWindow());
                hoofdmenuStage.initModality(Modality.WINDOW_MODAL);
                hoofdmenuStage.setScene(new Scene(hoofdmenuView));
                hoofdmenuStage.setX(view.getScene().getWindow().getX());
                hoofdmenuStage.setY(view.getScene().getWindow().getY());
                ((Stage)view.getScene().getWindow()).close();
                hoofdmenuStage.setMaximized(true);
                hoofdmenuStage.show();



            }
        });
        view.getBtnAfsluiten().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ((Stage)view.getScene().getWindow()).close();
            }
        });
/* Koppelt event handlers (
        anon.inner klassen)
// aan de
        controls uit de view.
// Event handlers: roepen methodes aan uit het
// model en zorgen voor een update van de view. */
    }

    private void updateView() {

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
