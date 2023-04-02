package view.Speelveld;

import Config.LblSpelRegels;
import Config.MainScreensBtnConfig;
import Config.StandardBtnConfig;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import model.TicTacToeModel;

public class SpeelveldView extends VBox {


    //Hbox's en Vboxen/Panes
    GridPane gridPane;
    BorderPane borderPane;
    HBox mijnHbox;
    private int gametype =4;


    //Labels

    private Label zinSpelen;
    private Label lblWinnaar;


    //TextFields: geen

    //Buttons
    private Button[][] fieldButtons;
    private Button backToHome;
    private Button Opslaan;
    private Button reset;
    private Button speelButton;

    private Image image1;
    private Image image2;
;

    //Images
    private Image image;

    TicTacToeModel model;

    public SpeelveldView(TicTacToeModel model) {
        this.model = model;
        this.initialiseNodes();
        this.layoutNodes();
    }


    public void setSpeelButton(Button speelButton) {
        this.speelButton = speelButton;
    }

    private void initialiseNodes() {
        this.gametype=model.getHuidigeGame().getSpeelveld().getVeldGrootte();

        //Labels
        zinSpelen = new Label(model.getHuidigeGame().getHuidigeActieveSpeler() + " is aan de beurt");

        lblWinnaar = new LblSpelRegels(null);
        this.fieldButtons = new Button[gametype][gametype];
        speelButton = new Button();

        //TextFields: geen enkele


        //Buttons
        backToHome = new MainScreensBtnConfig("terug naar hoofdmenu");
        reset = new MainScreensBtnConfig("reset");
        Opslaan = new Button("Opslaan");

        //Images
        image = new Image("startImage.jpg");
        image1 = new Image("cross.png");
        image2 = new Image("circle.png");

        //Vbox/Hbox/Panes
        gridPane = new GridPane();
        mijnHbox = new HBox();
        borderPane = new BorderPane();


    }
    public SpeelveldView()
    {}

    private void layoutNodes() {
        Opslaan.setPrefSize(80,30);
        Opslaan.setVisible(false);
        speelButton.setPrefSize(100, 100);
        borderPane.setCenter(Opslaan);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setAlignment(Pos.CENTER);
        mijnHbox.getChildren().add(reset);
        mijnHbox.getChildren().add(backToHome);
        mijnHbox.setSpacing(29);
        mijnHbox.setAlignment(Pos.BOTTOM_CENTER);
        this.setBackground(new Background(new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, true, true))));
        this.getChildren().add(borderPane);
        this.getChildren().add(zinSpelen);
        this.getChildren().add(gridPane);
        this.getChildren().add(lblWinnaar);
        this.getChildren().add(mijnHbox);
        this.setAlignment(Pos.CENTER);

    }

    public GridPane getGridPane() {
        return gridPane;
    }

    public HBox getMijnHbox() {
        return mijnHbox;
    }

    public Label getZinSpelen() {
        return zinSpelen;
    }

    public Label getLblWinnaar() {
        return lblWinnaar;
    }

    public Button getOpslaan() {
        return Opslaan;
    }

    public Button[][] getFieldButtons() {
        return fieldButtons;
    }

    public void setGridPane(GridPane gridPane) {
        this.gridPane = gridPane;
    }

    public Button getBackToHome() {
        return backToHome;
    }

    public Button getReset() {
        return reset;
    }

    public Button getSpeelButton(int row, int col) {
        return fieldButtons[row][col];
    }

    public Button getSpeelButton() {
        return speelButton;
    }

    public int getGametype() {
        return gametype;
    }

    public void setGametype(int gametype) {
        this.gametype = gametype;
    }

    public Image getImage() {
        return image;
    }



    public Image getImage1() {
        return image1;
    }

    public Image getImage2() {
        return image2;
    }

    public TicTacToeModel getModel() {
        return model;
    }
}