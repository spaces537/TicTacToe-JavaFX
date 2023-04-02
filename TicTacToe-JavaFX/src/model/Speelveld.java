package model;
public class Speelveld {
    Vakje vakjes [] [];
    Vakje vakje;
    int currentspeler=1;

    int veldGrootte=4;

    public void setVakje(Vakje vakje) {
        this.vakje = vakje;
    }

    public Speelveld(int dimensie)
    {
        this.veldGrootte=dimensie;
        this.vakjes = new Vakje[dimensie][dimensie];
        this.fillVakjes();


    }

    public Vakje[][] getVakjes() {
        return vakjes;
    }

    public Vakje getVakje() {
        return vakje;
    }

    public int getCurrentspeler() {
        return currentspeler;
    }

    public void setVakjes(Vakje[][] vakjes) {
        this.vakjes = vakjes;
    }

    public void fillVakjes() {
        for (int row = 0; row < getVeldGrootte(); row++) {
            for (int col = 0; col < getVeldGrootte(); col++) {
               this.vakjes[row][col] = new Vakje(Symbool.LEEG);
            }
        }
    }

    public void setCurrentspeler(int currentspeler) {
        this.currentspeler = currentspeler;
    }

    public int getVeldGrootte() {
        return veldGrootte;
    }

    public void setVeldGrootte(int veldGrootte) {
        this.veldGrootte = veldGrootte;
    }
    public boolean checkWinnaar() {
        // Check rows
        for (int row = 0; row < veldGrootte; row++) {
            boolean isWinningRow = true;
            Symbool winningSymbol = vakjes[row][0].getInhoud();
            for (int col = 1; col < veldGrootte; col++) {
                if (vakjes[row][col].getInhoud() != winningSymbol) {
                    isWinningRow = false;
                    break;
                }
            }
            if (isWinningRow && winningSymbol != Symbool.LEEG) {
                // Highlight winning row
                for (int col = 0; col < veldGrootte; col++) {
                    vakjes[row][col].setInhoud(Symbool.WINNER);
                }
                return true;
            }
        }

        // Check columns
        for (int col = 0; col < veldGrootte; col++) {
            boolean isWinningColumn = true;
            Symbool winningSymbol = vakjes[0][col].getInhoud();
            for (int row = 1; row < veldGrootte; row++) {
                if (vakjes[row][col].getInhoud() != winningSymbol) {
                    isWinningColumn = false;
                    break;
                }
            }
            if (isWinningColumn && winningSymbol != Symbool.LEEG) {
                // Highlight winning column
                for (int row = 0; row < veldGrootte; row++) {
                    vakjes[row][col].setInhoud(Symbool.WINNER);
                }
                return true;
            }
        }

        // Check diagonal (top-left to bottom-right)
        boolean isWinningDiagonal = true;
        Symbool winningSymbol = vakjes[0][0].getInhoud();
        for (int i = 1; i < veldGrootte; i++) {
            if (vakjes[i][i].getInhoud() != winningSymbol) {
                isWinningDiagonal = false;
                break;
            }
        }
        if (isWinningDiagonal && winningSymbol != Symbool.LEEG) {
            // Highlight winning diagonal
            for (int i = 0; i < veldGrootte; i++) {
                vakjes[i][i].setInhoud(Symbool.WINNER);
            }
            return true;
        }

        // Check diagonal (top-right to bottom-left)
        isWinningDiagonal = true;
        winningSymbol = vakjes[0][veldGrootte - 1].getInhoud();
        for (int i = 1; i < veldGrootte; i++) {
            if (vakjes[i][veldGrootte - 1 - i].getInhoud() != winningSymbol) {
                isWinningDiagonal = false;
                break;
            }
        }
        if (isWinningDiagonal && winningSymbol != Symbool.LEEG) {
            // Highlight winning diagonal
            for (int i = 0; i < veldGrootte; i++) {

                vakjes[i][veldGrootte - 1 - i].setInhoud(Symbool.WINNER);
            }
            return true;
        }

        return false;
    }
}
