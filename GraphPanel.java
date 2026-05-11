import javax.swing.*;
import java.awt.*;

public class GraphPanel extends JPanel {
    private boolean labelsVisible = true;
    private double scale = 1.0;

    public GraphPanel() {
        setBackground(new Color(105,125,125));
    }

    public void setLabelsVisible(boolean visible) {
        this.labelsVisible = visible;
    }

    public void setScale(double scale) {
        this.scale = scale;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Tutaj w przyszłości znajdzie się pętla rysująca wierzchołki i krawędzie
        // korzystając z Graphics2D
    }
}