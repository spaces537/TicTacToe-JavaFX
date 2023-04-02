package model;

import model.Symbool;

public class Vakje {
    private Symbool inhoud;

    public void setInhoud(Symbool inhoud) {
        this.inhoud = inhoud;
    }

    public Vakje(Symbool inhoud)
    {
        this.inhoud=inhoud;

    }

    public Symbool getInhoud() {


        return inhoud;
    }
}
