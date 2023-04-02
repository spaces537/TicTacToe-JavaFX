package model;

public class Speler {
    private String naam="speler ";
    private Symbool symbool;

    public Speler(String naam)
    {
        this.naam=naam;
    }
    public Speler(String naam, Symbool symbool)
    {
        this.naam=naam;
        this.symbool=symbool;
    }

    public String getNaam() {
        return this.naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Symbool getSymbool() {
        return symbool;
    }
}
