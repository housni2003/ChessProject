package modele;

import modele.jeu.Piece;
import modele.plateau.Plateau;

public class Decorateur {
    Plateau p;
    Piece piece;
    Decorateur decorateur; // peut servir pour faire une chaîne de décorateurs

    public Decorateur(Plateau plateau, Piece piecee) {
        this.p = plateau;
        this.piece = piecee;
        this.decorateur = null; // par défaut, pas de décorateur "suivant"
    }
}