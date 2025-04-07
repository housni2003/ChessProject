import modele.jeu.Jeu;
import VueControlleur.VueControlleur;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            Jeu jeu = new Jeu();                    // Création du modèle
            VueControlleur vue = new VueControlleur(jeu);  // Création de la vue + contrôleur
            vue.setVisible(true);                  // Affichage de la fenêtre
        });
    }
}
