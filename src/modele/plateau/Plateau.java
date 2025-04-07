package modele.plateau;
import java.awt.Point;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import plateau.Case;

public class Plateau extends Observable {
    public final int SIZE_X = 8;
    public final int SIZE_Y = 8;
    private Case[][] cases;
    Point p;
    Map<Case, Point> caseToCoord = new HashMap<>();

    public enum Direction {
        HAUT,
        BAS,
        GAUCHE,
        DROITE,
        HAUT_GAUCHE,
        HAUT_DROITE,
        BAS_GAUCHE,
        BAS_DROITE;
    }
    public Plateau() {
        cases = new Case[SIZE_X][SIZE_Y];
        for (int x = 0; x < SIZE_X; x++) {
            for (int y = 0; y < SIZE_Y; y++) {
                cases[x][y] = new Case(x, y);
            }
        }
    }

    public Case[][] getCases() {
        return cases;
    }

    public Case getCaseRelative(Case source, Direction d){
        Point p = caseToCoord.get(source);
        int x = p.x;
        int y = p.y;
        switch (d) {
            case HAUT:
                return source.setPiece(x, y - 1);
            case BAS:
                return Case(x, y + 1);
            case GAUCHE:
                return Case(x - 1, y);
            case DROITE:
                return Case(x + 1, y);
            case HAUT_GAUCHE:
                return Case(x - 1, y - 1);
            case HAUT_DROITE:
                return Case(x + 1, y - 1);
            case BAS_GAUCHE:
                return Case(x - 1, y + 1);
            case BAS_DROITE:
                return Case(x + 1, y + 1);
            default:
                return null; // Direction non valide
        }
    }

    public void deplacerPiece(Case depart, Case arrivee) {
        arrivee.setPiece(depart.getPiece());
        depart.setPiece(null);
        setChanged();
        notifyObservers();
    }
}