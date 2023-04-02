package Config;

import javafx.scene.control.TextField;

public class MainScreensTxtFieldConfig extends TextField {
    private static final String pattern = "^[A-Za-z]+$";
    public MainScreensTxtFieldConfig() {
        super();
        this.setMaxWidth(300);
        this.setPrefHeight(35);
        super.textProperty().addListener((observable, oldValue, newValue) -> {
        if (!newValue.matches(pattern)) {
                super.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
            } else {
                super.setStyle("");
            }
        });




    }

}
