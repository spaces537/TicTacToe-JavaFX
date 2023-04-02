package Config;

import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class LblSpelRegels extends Label {
    public LblSpelRegels(String s) {
        super(s);
        this.setFont(Font.font("System", FontWeight.BOLD, 25));
    }
}
