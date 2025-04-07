
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChessboardView extends JFrame implements Observer {
    private ChessboardModel model;
    private JLabel statusLabel;
    private JLabel lastClickedCell = null;
    private Color lastClickedColor = null;

    public ChessboardView(ChessboardModel model) {
        this.model = model;
        this.model.addObserver(this);
        this.build();
    }

    void build() {
        this.setLayout(new BorderLayout());
        JPanel jp = new JPanel(new GridLayout(8, 8));
        this.add(jp, "Center");
        this.statusLabel = new JLabel("Coordonnées: ");
        this.add(this.statusLabel, "South");

        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                final int row = i;
                final int col = j;
                final JLabel jl = new JLabel();
                jl.setOpaque(true);
                jl.setPreferredSize(new Dimension(50, 50));
                jl.setBorder(BorderFactory.createLineBorder(Color.GRAY));
                final Color defaultColor = (row + col) % 2 == 0 ? Color.WHITE : Color.BLACK;
                jl.setBackground(defaultColor);
                jl.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        if (ChessboardView.this.lastClickedCell != null) {
                            ChessboardView.this.lastClickedCell.setBackground(ChessboardView.this.lastClickedColor);
                        }

                        ChessboardView.this.lastClickedCell = jl;
                        ChessboardView.this.lastClickedColor = defaultColor;
                        jl.setBackground(Color.RED);
                        ChessboardView.this.model.setCoordinates(row, col);
                    }
                });
                jp.add(jl);
            }
        }


        this.setTitle("Échiquier");
        this.setSize(400, 400);
        this.setDefaultCloseOperation(3);
        this.setVisible(true);
    }

    public void update(Observable o, Object arg) {
        this.statusLabel.setText("Coordonnées: (" + this.model.getRow() + ", " + this.model.getCol() + ")");
    }
}