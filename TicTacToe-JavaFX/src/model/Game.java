package model;


public class Game {

    //Spelers
    Speler speler1;
    Speler speler2;

    //Speelveld
    Speelveld speelveld;

    //Huidgeactieve speler
    String huidigeActieveSpeler =  "";

    // start game

    int currentspeler;

    public Game(Speler speler1,Speler speler2,Speelveld speelveld)
    {
        this.speler1 =speler1;
        this.speler2=speler2;
        this.speelveld=speelveld;
        currentspeler = speelveld.getCurrentspeler();
        speelveld.fillVakjes();
    }









    public Speelveld getSpeelveld() {
        return speelveld;
    }





    public String getHuidigeActieveSpeler() {


        if (getCurrentspeler()== 1) {
            huidigeActieveSpeler = speler1.getNaam();
            return this.huidigeActieveSpeler;
        } else {
            huidigeActieveSpeler = speler2.getNaam();
            return this.huidigeActieveSpeler;
        }

    }

    public int getCurrentspeler() {
        return currentspeler;
    }

    public void setCurrentspeler(int currentspeler) {

        this.currentspeler = currentspeler;
    }
}
