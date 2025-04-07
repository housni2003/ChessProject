package modele.plateau;

import modele.jeu.Piece;

public class Case {
    private int x, y;
    private Piece piece;

    public Case(int x, int y) {
        this.x = x;
        this.y = y;
        this.piece = null;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    // creer un set x et un set y pour Plateau pour getCaseRelative
}