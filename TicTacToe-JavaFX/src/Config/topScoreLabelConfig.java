package Config;


import javafx.scene.control.Label;

import java.awt.*;

public class topScoreLabelConfig extends Label {
    public topScoreLabelConfig(String s){
        super(s);
        setPrefSize(400,50);
    }

    @Override
    public void setPrefSize(double prefWidth, double prefHeight) {
        super.setPrefSize(prefWidth, prefHeight);
    }

}
