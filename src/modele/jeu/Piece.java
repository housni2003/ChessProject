package modele.jeu;

import modele.plateau.Case;

public abstract class Piece {
    private boolean estBlanc;
    public Case c;

    public Piece(boolean estBlanc) {
        this.estBlanc = estBlanc;
    }

    public boolean estBlanc() {
        return estBlanc;
    }
}