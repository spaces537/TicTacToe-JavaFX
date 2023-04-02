package Config;

import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class StartTitleConfig extends Label {
    public StartTitleConfig(String s) {
        super(s);
        this.setFont(Font.font("System", FontWeight.BOLD, 35));
        //this.setFont(Font.font("Georgia", FontPosture.ITALIC, 18));
    }
}
