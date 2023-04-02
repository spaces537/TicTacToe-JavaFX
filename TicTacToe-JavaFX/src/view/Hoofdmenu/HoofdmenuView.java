package view.Hoofdmenu;

import Config.MainScreensBtnConfig;
import Config.MainScreensTxtFieldConfig;
import Config.StartTitleConfig;
import model.Speler;
import model.Symbool;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;


public class HoofdmenuView extends VBox
{
    //Titles
    StartTitleConfig lblTitle;
    //Hbox's en Vboxen
    HBox hbox;


    //Labels
    Label lblSpelerEen;
    Label lblSpelerTwee;


    Label lblCredits;

    //TextFields
    MainScreensTxtFieldConfig txtSpellerEen;
    MainScreensTxtFieldConfig txtSpellerTwee;
    //Buttons
    MainScreensBtnConfig btnStart;
    Button btnTypeGame1;
    Button btnTypeGame2;

    //Images
    Image mijnImage;

    //Extra's
    Speler speler1;
    Speler speler2;

    public  HoofdmenuView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
        //Labels
        lblTitle = new StartTitleConfig("TIC-TAC-TOE");
        lblSpelerEen = new Label("Speler 1: ");
        lblSpelerTwee = new Label("Speler 2: ");

        //TextFields
        txtSpellerEen = new MainScreensTxtFieldConfig();
        txtSpellerTwee = new MainScreensTxtFieldConfig();

        //Buttons
        btnStart = new MainScreensBtnConfig("Start");
        btnTypeGame1 = new Button("3x3 Form");
        btnTypeGame2 = new Button("4x4 Form");


        //Images
        mijnImage = new Image("startImage.jpg");

        //Vbox/Hbox/Panes
        hbox = new HBox(btnTypeGame1,btnTypeGame2);

        //Extra's
        speler1 = new Speler(txtSpellerEen.getText(), Symbool.CROSS);
        speler2 = new Speler(txtSpellerTwee.getText(), Symbool.CIRCLE);

    }
    private void layoutNodes()
    {
       
        hbox.setSpacing(10);
        hbox.setAlignment(Pos.CENTER);

       
        this.getChildren().add(lblTitle);
        this.getChildren().add(lblSpelerEen);
        this.getChildren().add(txtSpellerEen);
        this.getChildren().add(lblSpelerTwee);
        this.getChildren().add(txtSpellerTwee);
        this.getChildren().add(btnStart);
        this.getChildren().add(hbox);

        this.setAlignment(Pos.CENTER);
        this.setSpacing(30);
        this.setBackground(new Background(new BackgroundImage(mijnImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, true, true))));

    }

    public StartTitleConfig getLblTitle() {
        return lblTitle;
    }

    public HBox getHbox() {
        return hbox;
    }

    public Label getLblSpelerEen() {
        return lblSpelerEen;
    }

    public Label getLblSpelerTwee() {
        return lblSpelerTwee;
    }

    public Label getLblCredits() {
        return lblCredits;
    }

    public MainScreensTxtFieldConfig getTxtSpellerEen() {
        return txtSpellerEen;
    }

    public MainScreensTxtFieldConfig getTxtSpellerTwee() {
        return txtSpellerTwee;
    }

    public MainScreensBtnConfig getBtnStart() {
        return btnStart;
    }

    public Button getBtnTypeGame1() {
        return btnTypeGame1;
    }

    public Button getBtnTypeGame2() {
        return btnTypeGame2;
    }

    public Image getMijnImage() {
        return mijnImage;
    }

    public Speler getSpeler1() {
        return speler1;
    }

    public Speler getSpeler2() {
        return speler2;
    }
}




//






