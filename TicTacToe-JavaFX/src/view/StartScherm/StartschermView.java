package view.StartScherm;

import Config.MainScreensBtnConfig;
import Config.StartTitleConfig;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;


public class StartschermView extends BorderPane
{
    //Hbox's en Vboxen
    HBox borderPane;
    // titels
    StartTitleConfig lblTitle;

    //Labels
    Label lblCredits;

    //TextFields: geen

    //Buttons
    Button btnNewGame;
    Button btnTopScores;
    Button btnMarouane;
    Button btnSpelRegels;
    Button btnAfsluiten;
    Image image;
    //Images

    public  StartschermView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
        borderPane = new HBox();

        //titels
        lblTitle = new StartTitleConfig("TIC-TAC-TOE");
        //Labels
        lblCredits= new Label("Created By Kaan En Marouane");

        //TextFields: geen enkele


        //Buttons
        this.btnNewGame = new MainScreensBtnConfig("New Game");
        this.btnTopScores = new MainScreensBtnConfig("Top Scores");
        this.btnSpelRegels = new MainScreensBtnConfig("Spelregels");
        this.btnAfsluiten = new MainScreensBtnConfig("Afsluiten");
        this.btnMarouane = new MainScreensBtnConfig("Marouane");

        //Images
        image = new Image("startImage.jpg");

        //Vbox/Hbox/Panes


    }
    private void layoutNodes()
    {

        VBox vbox = new VBox();
        borderPane.getChildren().add(btnMarouane);
        borderPane.setAlignment(Pos.BOTTOM_RIGHT);

        vbox.getChildren().add(lblTitle);
        vbox.getChildren().add(btnNewGame);
        vbox.getChildren().add(btnTopScores);
        vbox.getChildren().add(btnSpelRegels);
        vbox.getChildren().add(btnAfsluiten);
        vbox.getChildren().add(lblCredits);

        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(15);


        this.setCenter(vbox);
        this.setBottom(borderPane);

        this.setBackground(new Background(new BackgroundImage( image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, true, true))));
    }

    public Label getLblCredits() {
        return lblCredits;
    }

    public Button getBtnNewGame() {
        return btnNewGame;
    }

    public Button getBtnTopScores() {
        return btnTopScores;
    }

    public Button getBtnSpelRegels() {
        return btnSpelRegels;
    }

    public Button getBtnAfsluiten() {
        return btnAfsluiten;
    }

    public Image getImage() {
        return image;
    }
}




//






