package modele.jeu;

import modele.plateau.Case;
import modele.plateau.Plateau;

public class Jeu extends Thread{
    private Plateau plateau;

    public Jeu() {
        plateau = new Plateau();
        initialiserPieces();
        start();
    }

    @Override
    public void run() {
       jouerPartie();
    }

    Coup buff;
    public synchronized void setCoup(Coup c) { // la vue va appeler set coup
        buff = c;
        notify(); // réveille le thread du jeu qui attend dans getCoup()
    }


    public synchronized Coup getCoup() throws InterruptedException { // elle sont synchronisé donc il n y a qu"un seul thread qui peut executer a la fois setCoup et getCoup, on ne pe
        while (buff == null) { // on ne peut pas call getCoup et setCoup en meme temps
            wait(); // attend qu’un coup soit joué
        }
        Coup c = buff;
        buff = null; // reset pour le prochain tour
        return c;
    }


    public void jouerPartie() {

        while(true) {

        }

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