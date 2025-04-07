package modele.jeu;

import modele.plateau.Case;
import modele.plateau.Plateau;

public class Jeu {
    private Plateau plateau;

    public Jeu() {
        plateau = new Plateau();
        initialiserPieces();
    }

    private void initialiserPieces() {
        plateau.getCases()[4][0].setPiece(new Roi(true));  // Roi blanc en (4,0)
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public void demandeDeplacementPiece(Case depart, Case arrivee) {
        if (depart.getPiece() != null) {
            plateau.deplacerPiece(depart, arrivee);
        }
    }
}


//public void jouerPartie()
//init()
//while partie pas terminé
//joueur a = getJoueur suivant
//Coup c= a.getCoup
//while coup valide
//c = a.getCoup
//appliquer coup c



//partie Terminée ()
//coup valide()
//get joueurSuivant()
//appliquerCoup()



//dans une classe joueur faire une fonction getCoup()
//wait du process qui va dodo