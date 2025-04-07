public class ChessboardController {
    private ChessboardModel model;
    private ChessboardView view;

    public ChessboardController(ChessboardModel model, ChessboardView view) {
        this.model = model;
        this.view = view;
    }

    public void start() {
        this.view.setSize(400, 400);
        this.view.setDefaultCloseOperation(3);
        this.view.setVisible(true);
    }
}