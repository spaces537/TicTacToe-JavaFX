package view.Hoofdmenu;

import Config.MainScreensTxtFieldConfig;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.*;
import view.Speelveld.SpeelveldPresenter;
import view.Speelveld.SpeelveldView;
import view.Spelregels.SpelregelsView;
import view.StartScherm.StartschermPresenter;
import view.StartScherm.StartschermView;

public class HoofdmenuPresenter {
    private TicTacToeModel model;

    private int gametype=0;
    private HoofdmenuView view;

    public HoofdmenuPresenter(HoofdmenuView view) {

        this.view = view;
        this.addEventHandlers();
        this.updateView();
    }

    private void addEventHandlers() {

        view.getBtnStart().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Speler speler1 = new Speler(view.getTxtSpellerEen().getText(),Symbool.CROSS);
                Speler speler2 = new Speler(view.getTxtSpellerTwee().getText(),Symbool.CIRCLE);
                TicTacToeModel model = new TicTacToeModel(new Game(speler1,speler2,new Speelveld(gametype)));
                if (gametype == 0 || speler1.getNaam().equals("") || speler2.getNaam().equals("")) {
                    addWindowEventHandlers();
                    return;

                }
                else if (speler2.getNaam().matches("^[A-Za-z]+$") && speler1.getNaam().matches("^[A-Za-z]+$"))
                {

                }
                else
                {
                    addWindowEventHandlers();
                    return;
                }

                if (gametype == 3) {
                    model.getHuidigeGame().getSpeelveld().setVeldGrootte(gametype);
                    model.getHuidigeGame().getSpeelveld().fillVakjes();

                } else if (gametype == 4) {

                    model.getHuidigeGame().getSpeelveld().setVeldGrootte(gametype);
                    model.getHuidigeGame().getSpeelveld().fillVakjes();

                }

                SpeelveldView speelveldView = new SpeelveldView(model);
                SpeelveldPresenter speelveldPresenter = new SpeelveldPresenter(model,speelveldView);

                Stage speelveldStage = new Stage();
                speelveldStage.getIcons().add(new Image("TicTacToeLogo.jpg"));
                speelveldStage.initOwner(view.getScene().getWindow());
                speelveldStage.initModality(Modality.WINDOW_MODAL);
                speelveldStage.setScene(new Scene(speelveldView));
                speelveldStage.setX(view.getScene().getWindow().getX());
                speelveldStage.setY(view.getScene().getWindow().getY());
                ((Stage)view.getScene().getWindow()).close();
                speelveldStage.setMaximized(true);
                speelveldStage.setFullScreen(true);
                speelveldStage.show();

            }
        });
        view.getBtnTypeGame1().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                gametype = 3;

            }
        });
        view.getBtnTypeGame2().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                gametype = 5;

            }
        });

    }



    private void updateView() {


    }


    // Vult de view met data uit model
    public void addWindowEventHandlers() {

        if (gametype == 0) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please select a game type!", ButtonType.OK);
            alert.showAndWait();
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Geef je naam in of je naam matched de regex niet", ButtonType.OK);
            alert.showAndWait();
        }
    }


}
