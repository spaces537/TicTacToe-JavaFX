package Config;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.DragEvent;
import javafx.scene.shape.Rectangle;

public class StandardBtnConfig extends Button {
    public StandardBtnConfig(String s)
    {
        super(s);
        this.setPrefSize(100,70);
        Rectangle rect = new Rectangle();
        rect.widthProperty().bind(this.widthProperty());
        rect.heightProperty().bind(this.heightProperty());
        rect.setArcHeight(80);
        rect.setArcWidth(80);
        this.setStyle(("-fx-background-color: lightblue; "));
        
        this.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                this.setStyle(("-fx-background-color: #aliceblue; "));

            }

            private void setStyle(String s) {
            }
        });
        this.setShape(rect);
        this.setMinSize(this.getPrefWidth(), this.getPrefHeight());
    }
}
