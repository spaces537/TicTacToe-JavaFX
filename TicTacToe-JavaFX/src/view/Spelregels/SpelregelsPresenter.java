package view.Spelregels;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.TicTacToeModel;
import view.Speelveld.SpeelveldPresenter;
import view.Speelveld.SpeelveldView;
import view.StartScherm.StartschermPresenter;
import view.StartScherm.StartschermView;


public class SpelregelsPresenter {


    private SpelregelsView view;

    public SpelregelsPresenter(SpelregelsView view) {

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
    }
/* Koppelt event handlers (
        anon.inner klassen)
// aan de
        controls uit de view.
// Event handlers: roepen methodes aan uit het
// model en zorgen voor een update van de view. */


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
