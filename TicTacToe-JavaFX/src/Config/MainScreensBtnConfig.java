package Config;

import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;

public class MainScreensBtnConfig extends Button {
    public MainScreensBtnConfig(String s) {
        super(s);
        this.setPrefSize(100,70);
        Rectangle rect = new Rectangle();
        rect.widthProperty().bind(this.widthProperty());
        rect.heightProperty().bind(this.heightProperty());
        rect.setArcHeight(80);
        rect.setArcWidth(80);

        this.setShape(rect);
        this.setMinSize(this.getPrefWidth(), this.getPrefHeight());
    }
}
