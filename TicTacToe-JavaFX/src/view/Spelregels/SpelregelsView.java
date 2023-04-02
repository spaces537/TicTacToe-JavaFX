package view.Spelregels;

import Config.LblSpelRegels;
import Config.topScoreLabelConfig;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class SpelregelsView extends BorderPane{
//Titles

    //Hbox's en Vboxen en Panes
    private VBox mijnVbox;




    //Labels
    private LblSpelRegels textAreas [];
    //TextFields

    //Buttons
    private Button btnTerugNaarHoofdMenu;


    //Images
    private Image mijnImage;

    //Extra's


    public SpelregelsView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
        //Labels
        textAreas = new LblSpelRegels[4];
        this.textAreas[0] = new LblSpelRegels("1) The game is played on a grid that's 3 or 4 squares by 3 or 4 squares.");
        this.textAreas[1] = new LblSpelRegels("2) Player 1 X,Player 2 is O. Players take turns putting their marks in empty squares.");
        this.textAreas[2] = new LblSpelRegels("3) The first player to get 3 of her marks in a row (up, down, across, or diagonally) is the winner.");
        this.textAreas[3] = new LblSpelRegels("4) When all 9 or 16 squares are full, the game is over.");


        //TextFields


        //Buttons
        this.btnTerugNaarHoofdMenu = new Button("Terug naar hoofdmenu");


        //Images
        mijnImage = new Image("startImage.jpg");

        //Vbox/Hbox/Panes
        mijnVbox = new VBox();

        //Extra's

    }

    private void layoutNodes() {

        //title


        //Button
        this.btnTerugNaarHoofdMenu.setFont(Font.font("Verdana", 16));
        this.btnTerugNaarHoofdMenu.setPadding(new Insets(10));
        this.btnTerugNaarHoofdMenu.setAlignment(Pos.CENTER);
        this.setBottom(btnTerugNaarHoofdMenu);
        BorderPane.setAlignment(btnTerugNaarHoofdMenu,Pos.CENTER);

        //mijnVbox
        for (int i = 0; i < textAreas.length; i++) {
            mijnVbox.getChildren().add(textAreas[i]);
        }
        mijnVbox.setMinSize(500, 500);
        mijnVbox.setAlignment(Pos.CENTER);
        this.setCenter(mijnVbox);


        //Background
        this.setBackground(new Background(new BackgroundImage(mijnImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, true, true))));

    }

    public VBox getMijnVbox() {
        return mijnVbox;
    }

    public LblSpelRegels[] getTextAreas() {
        return textAreas;
    }

    public Button getBtnTerugNaarHoofdMenu() {
        return this.btnTerugNaarHoofdMenu;
    }

    public Image getMijnImage() {
        return mijnImage;
    }
}



//







