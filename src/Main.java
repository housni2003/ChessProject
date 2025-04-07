public class Main {
    public static void main(String[] args) {
        ChessboardModel model = new ChessboardModel();
        ChessboardView view = new ChessboardView(model);
        ChessboardController controller = new ChessboardController(model, view);
        controller.start();
    }
}
