package model;

import java.time.LocalDateTime;

public class HighscoreEntry implements Comparable<HighscoreEntry>{
    private String spelernaam; //Dit zou eventueel ook een model.Speler-object kunnen zijn
    private LocalDateTime eindmomentSpel;

    private LocalDateTime startTijdSpel;

    private int score;

    public int getScore() {
        return score;
    }

    public LocalDateTime getStartTijdSpel() {
        return startTijdSpel;
    }

    public void setStartTijdSpel(LocalDateTime startTijdSpel) {
        this.startTijdSpel = startTijdSpel;
    }

    private int tijd;

    public String getSpelernaam() {
        return spelernaam;
    }

    public void setSpelernaam(String spelernaam) {
        this.spelernaam = spelernaam;
    }

    public LocalDateTime getEindmomentSpel() {
        return eindmomentSpel;
    }

    public void setEindmomentSpel(LocalDateTime eindmomentSpel) {
        this.eindmomentSpel = eindmomentSpel;
    }

    public int getTijd() {
        return tijd;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public HighscoreEntry(String spelernaam,LocalDateTime startTijdSpel, LocalDateTime eindmomentSpel, int score) {
        this.spelernaam = spelernaam;
        this.startTijdSpel = startTijdSpel;
        this.eindmomentSpel = eindmomentSpel;
        this.tijd = score;
    }

    @Override
    public String toString() {
        return "model.HighscoreEntry{" +
                "spelernaam='" + spelernaam + '\'' +
                ", eindmomentSpel=" + eindmomentSpel +
                ", aantal seconden=" + tijd +
                '}';
    }


    @Override
    public int compareTo(HighscoreEntry o) {
        return  o.getTijd() - this.tijd;
    }

    public void setTijd(int tijd) {
        this.tijd = tijd;
    }
}
