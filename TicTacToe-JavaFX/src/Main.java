
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.TicTacToeModel;

import view.StartScherm.StartschermPresenter;
import view.StartScherm.StartschermView;

public class Main extends Application {


    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage)  {
        TicTacToeModel model = new TicTacToeModel(null);


        //TopscoresView view = new TopscoresView();
        //TopscoresPresenter presenter = new TopscoresPresenter();

        StartschermView startschermView = new StartschermView();
        StartschermPresenter startschermPresenter = new StartschermPresenter(startschermView, model);
        stage.getIcons().add(new Image("TicTacToeLogo.jpg"));
        stage.setScene(new Scene(startschermView));
        stage.setMaximized(true);
        stage.show();
    }
}