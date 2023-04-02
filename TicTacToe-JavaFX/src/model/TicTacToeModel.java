package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TicTacToeModel {

    private Game huidigeGame;
    private List<HighscoreEntry> highscoreEntryList;


    public TicTacToeModel(Game huidigeGame)
    {
        if (huidigeGame ==null)
        {
            this.huidigeGame = null;
        }
        else {
            this.huidigeGame = huidigeGame;
        }
    }

    public Game getHuidigeGame() {
        return huidigeGame;
    }
    public List<HighscoreEntry> getHighscoreEntryList() {
        return highscoreEntryList;
    }
    public void fillHighscores() {
        highscoreEntryList = new ArrayList<>();

        try {
            // Open the CSV file
            Reader reader = Files.newBufferedReader(Paths.get("resources/leaderboard.csv"));

            // Read the CSV file line by line
            String line;
            while ((line = ((BufferedReader) reader).readLine()) != null) {

                // Split the line into its individual fields
                String[] fields = line.split(",");


                // Extract the name, date1, date2, and score from the fields


                String name = fields[0];
                LocalDateTime date1 = LocalDateTime.parse(fields[1]);
               // date1.format();
                LocalDateTime date2 = LocalDateTime.parse(fields[2]);
                int score = Integer.parseInt(fields[3]);

                // Create a new highscore entry and add it to the list
                HighscoreEntry entry = new HighscoreEntry(name, date1, date2, score);
                highscoreEntryList.add(entry);
            }

            // Sort the highscore entry list
            Collections.sort(highscoreEntryList);

        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }

            // Sort the highscore entry list
            Collections.sort(highscoreEntryList);
            Collections.reverse(highscoreEntryList);
        }


}


