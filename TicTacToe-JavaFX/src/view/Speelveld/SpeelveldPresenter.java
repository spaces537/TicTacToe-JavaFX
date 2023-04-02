package view.Speelveld;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.*;
import view.Hoofdmenu.HoofdmenuPresenter;
import view.Hoofdmenu.HoofdmenuView;
import view.StartScherm.StartschermPresenter;
import view.StartScherm.StartschermView;
import view.Topscores.TopscoresView;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SpeelveldPresenter {
    private TicTacToeModel model;
    private SpeelveldView view;
    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private int scoret=0;

    public SpeelveldPresenter(TicTacToeModel model, SpeelveldView view) {
        startTime = LocalDateTime.now();
        this.model = model;
        this.view = view;
        this.addEventHandlers();
        this.updateView();

    }

    private void addEventHandlers() {


        view.getOpslaan().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                        File mijnBestand = new File( "resources/leaderboard.csv");
                ArrayList<String> inhoud = new ArrayList<String>();
                inhoud.add(model.getHuidigeGame().getHuidigeActieveSpeler() + "," + startTime + "," + endTime+ "," + scoret);
                try {

                            Files.write(mijnBestand.toPath(), inhoud, StandardOpenOption.APPEND);
                        } catch (IOException ex) {
                           // Seef bijvoorbeeld een aangepaste foutboodschap
                            System.out.println("Eris een fout");
                        }

                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Opgeslagen!", ButtonType.OK);
                    alert.showAndWait();
                    view.getOpslaan().setDisable(true);
            }
        });
        view.getReset().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                model.getHuidigeGame().getSpeelveld().fillVakjes();
                model.getHuidigeGame().setCurrentspeler(1);
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

        view.getBackToHome().setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                TicTacToeModel model = new TicTacToeModel(null);
                StartschermView startschermView = new StartschermView();
                StartschermPresenter startschermPresenter = new StartschermPresenter(startschermView,model);
                Stage StartschermStage = new Stage();
                StartschermStage.getIcons().add(new Image("TicTacToeLogo.jpg"));

                StartschermStage.initOwner(view.getScene().getWindow());
                StartschermStage.initModality(Modality.WINDOW_MODAL);
                StartschermStage.setScene(new Scene(startschermView));
                StartschermStage.setX(view.getScene().getWindow().getX());
                StartschermStage.setY(view.getScene().getWindow().getY());
                ((Stage)view.getScene().getWindow()).close();
                StartschermStage.setMaximized(true);
                StartschermStage.show();
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
        // create container for buttons
        Vakje vakjes[][] = model.getHuidigeGame().getSpeelveld().getVakjes();
        GridPane gridPane = new GridPane();
        // Check if there is a winner
        for (int row = 0; row < model.getHuidigeGame().getSpeelveld().getVeldGrootte(); row++) {
            for (int col = 0; col < model.getHuidigeGame().getSpeelveld().getVeldGrootte(); col++) {
                int frow = row;
                int fcol = col;




                // create new button and set ID or userData
                Button button = new Button();
                button.setPrefSize(100, 100);
                button.setUserData(new int[]{frow, fcol});


                // set button text or graphics based on vakjes value


                // set button action
                button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        model.getHuidigeGame().getSpeelveld().checkWinnaar();
                        int currentplayer = model.getHuidigeGame().getCurrentspeler();
                        if (currentplayer == 1) {
                            vakjes[frow][fcol] = new Vakje(Symbool.CROSS);
                            BackgroundImage backgroundImage = new BackgroundImage(
                                    new ImageView(view.getImage1()).getImage(),
                                    BackgroundRepeat.NO_REPEAT,
                                    BackgroundRepeat.NO_REPEAT,
                                    BackgroundPosition.CENTER,
                                    new BackgroundSize(button.getWidth(), button.getHeight(), false, false, false, false)
                            );
                            button.setBackground(new Background(backgroundImage));
                            button.setDisable(true);

                            model.getHuidigeGame().setCurrentspeler(2);
                            view.getZinSpelen().setText(model.getHuidigeGame().getHuidigeActieveSpeler() + " is aan de beurt");

                        } else if (currentplayer == 2) {
                            vakjes[frow][fcol] = new Vakje(Symbool.CIRCLE);

                            BackgroundImage backgroundImage = new BackgroundImage(
                                    new ImageView(view.getImage2()).getImage(),
                                    BackgroundRepeat.NO_REPEAT,
                                    BackgroundRepeat.NO_REPEAT,
                                    BackgroundPosition.CENTER,
                                    new BackgroundSize(button.getWidth(), button.getHeight(), false, false, false, false)
                            );
                            button.setBackground(new Background(backgroundImage));

                            button.setDisable(true);
                            model.getHuidigeGame().setCurrentspeler(1);
                            view.getZinSpelen().setText(model.getHuidigeGame().getHuidigeActieveSpeler() + " is aan de beurt");


                        }
                        model.getHuidigeGame().getSpeelveld().setVakjes(vakjes);
                        model.getHuidigeGame().getSpeelveld().checkWinnaar();
                        if (model.getHuidigeGame().getSpeelveld().checkWinnaar()) {
                            endTime = LocalDateTime.now();
                            view.getOpslaan().setVisible(true);



                            Symbool winnaarSymbool = Symbool.WINNER;
                            view.getZinSpelen().setText(null);

                            for (int row = 0; row < model.getHuidigeGame().getSpeelveld().getVeldGrootte(); row++) {
                                for (int col = 0; col < model.getHuidigeGame().getSpeelveld().getVeldGrootte(); col++) {
                                    // Get all the children of the GridPane
                                    for (Node node : gridPane.getChildren()) {
                                        if (node instanceof Button) {
                                            Button button = (Button) node;
                                            button.setDisable(true);
                                        }
                                    }
                                    if (vakjes[row][col].getInhoud() == winnaarSymbool) {
                                        int buttonRow = row;
                                        int buttonCol = col;

                                        // Change the background color of the button at row 'buttonRow' and column 'buttonCol'
                                        Button button = (Button) gridPane.getChildren().get(buttonRow * model.getHuidigeGame().getSpeelveld().getVeldGrootte() + buttonCol);
                                        button.setStyle("-fx-background-color: red;");
                                    }
                                }
                            }
                            if (currentplayer==1)
                            {
                                model.getHuidigeGame().setCurrentspeler(1);
                            }
                            else if(currentplayer==2)
                            {
                                model.getHuidigeGame().setCurrentspeler(2);
                            }
                            view.getLblWinnaar().setText(model.getHuidigeGame().getHuidigeActieveSpeler() + " is de winnaar");

                            long durationSeconds = Duration.between(startTime, endTime).getSeconds();
                            int score = (int)durationSeconds;
                            scoret = score;
                            HighscoreEntry highscoreEntry = new HighscoreEntry(model.getHuidigeGame().getHuidigeActieveSpeler(),startTime,endTime,scoret);




                        }
                        addWindowEventHandlers();


                    }

                });



                gridPane.add(button, col, row);
                gridPane.setAlignment(Pos.CENTER);
            }


        }


        // gridpane vervangen binnen inde view door eerste te verwijderen en dan mijn gridpane toe te voegen
        for (Node child : view.getChildren()) {
            if (child instanceof GridPane) {
                view.getChildren().remove(child);
                break;
            }
        }
        // add new GridPane to view
        view.getChildren().add(gridPane);


    }



        // Vult de view met data uit model
        public void addWindowEventHandlers () {
            view.getScene().getWindow().setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Zeker dat je wil sluiten??", ButtonType.YES, ButtonType.NO);
                    alert.showAndWait();
                    if (alert.getResult() == ButtonType.NO) {
                        event.consume();
                    }
                }
            });
            boolean heeftLeeg = false;
            for (int row = 0; row < model.getHuidigeGame().getSpeelveld().getVeldGrootte(); row++) {
                for (int col = 0; col < model.getHuidigeGame().getSpeelveld().getVeldGrootte(); col++) {
                    if (model.getHuidigeGame().getSpeelveld().getVakjes()[row][col].getInhoud() == Symbool.LEEG) {
                        heeftLeeg = true;
                        break;
                    }
                }
                if (heeftLeeg) {
                    break;
                }
            }

            if(!model.getHuidigeGame().getSpeelveld().checkWinnaar()) {
                if (!heeftLeeg) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Gelijkspel!", ButtonType.OK);
                    alert.showAndWait();
                    view.getReset().fire();
                }
            }
        }


    /*Window event
    handlers anon .
    inner klassen)
    // Koppeling via
    view.getScene getWindow */

}
