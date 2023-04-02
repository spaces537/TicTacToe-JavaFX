package view.Topscores;

import Config.topScoreLabelConfig;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.Collections;

public class TopscoresView extends BorderPane {
    //Titles

    //Hbox's en Vboxen en Panes

    private GridPane scoreBordPane;



    //Labels
    private Label title;
    private Label lblplaats;
    private Label lblplayer;
    private Label lblStartDatum;
    private Label lblEindDatum;

    private Label lblScore;
    //TextFields

    //Buttons
    private Button btnTerugNaarHoofdMenu;


    //Images
    private Image mijnImage;

    //Extra's


    public TopscoresView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
        //Labels
        title = new Label("Highscores");
        lblplaats = new topScoreLabelConfig("Plaats");
        lblplayer = new topScoreLabelConfig("Speler");
        lblStartDatum = new topScoreLabelConfig("Datum");

        lblScore = new topScoreLabelConfig("Snelheid");

        //TextFields


        //Buttons
        btnTerugNaarHoofdMenu = new Button("Terug naar hoofdmenu");


        //Images
        mijnImage = new Image("startImage.jpg");

        //Vbox/Hbox/Panes
        scoreBordPane = new GridPane();

        //Extra's

    }

    private void layoutNodes() {

       //title
        title.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
        title.setPadding(new Insets(20));
        title.setAlignment(Pos.CENTER);
        this.setTop(title);

        //Button
        btnTerugNaarHoofdMenu.setFont(Font.font("Verdana", 16));
        btnTerugNaarHoofdMenu.setPadding(new Insets(10));
        btnTerugNaarHoofdMenu.setAlignment(Pos.CENTER);
        this.setBottom(btnTerugNaarHoofdMenu);
        BorderPane.setAlignment(btnTerugNaarHoofdMenu,Pos.CENTER);

        //Scorebord pane
        scoreBordPane.setAlignment(Pos.CENTER);
        scoreBordPane.setVgap(20);
        scoreBordPane.setHgap(20);
        scoreBordPane.setPadding(new Insets(20));
        scoreBordPane.add(lblplaats, 0, 0);
        scoreBordPane.add(lblplayer, 1, 0);
        scoreBordPane.add(lblStartDatum, 2, 0);
        scoreBordPane.add(lblScore, 3, 0);
        this.setCenter(scoreBordPane);
        //Background
        this.setBackground(new Background(new BackgroundImage(mijnImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, true, true))));

    }

    public GridPane getScoreBordPane() {
        return scoreBordPane;
    }

    public Label getTitle() {
        return title;
    }

    public Label getLblplaats() {
        return lblplaats;
    }

    public Label getLblplayer() {
        return lblplayer;
    }

    public Label getLblStartDatum() {
        return lblStartDatum;
    }

    public Label getLblScore() {
        return lblScore;
    }

    public Button getBtnTerugNaarHoofdMenu() {
        return btnTerugNaarHoofdMenu;
    }

    public Image getMijnImage() {
        return mijnImage;
    }

    public void setLblplaats(Label lblplaats) {
        this.lblplaats = lblplaats;
    }

    public void setLblplayer(Label lblplayer) {
        this.lblplayer = lblplayer;
    }

    public void setLblDatum(Label lblDatum) {
        this.lblStartDatum = lblDatum;
    }

    public void setLblScore(Label lblScore) {
        this.lblScore = lblScore;
    }

    public Label getLblEindDatum() {
        return lblEindDatum;
    }

    public void setLblEindDatum(Label lblEindDatum) {
        this.lblEindDatum = lblEindDatum;
    }
}




//






