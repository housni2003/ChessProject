import java.util.Observable;

public class ChessboardModel extends Observable {
    private int row;
    private int col;

    public ChessboardModel() {
    }

    public void setCoordinates(int row, int col) {
        this.row = row;
        this.col = col;
        this.setChanged();
        this.notifyObservers();
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }
}
