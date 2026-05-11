import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private GraphPanel graphPanel;

    public MainFrame() {
        setTitle("Aplikacja do Wizualizacji Grafów");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Inicjalizacja głównego obszaru roboczego
        graphPanel = new GraphPanel();

        // Dodawanie oddzielonych komponentów
        setJMenuBar(new AppMenuBar(this));
        add(new ToolBarPanel(graphPanel), BorderLayout.WEST);
        add(graphPanel, BorderLayout.CENTER);
    }
}
