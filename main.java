import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;

public class GraphApp extends JFrame {

    private GraphPanel graphPanel;

    public GraphApp() {
        setTitle("Aplikacja do Wizualizacji Grafów");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        graphPanel = new GraphPanel();
        
        setJMenuBar(createMenuBar());
        add(createToolBar(), BorderLayout.WEST);
        add(graphPanel, BorderLayout.CENTER);
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("Plik");
        JMenuItem loadTxt = new JMenuItem("Wczytaj (TXT)");
        JMenuItem loadBin = new JMenuItem("Wczytaj (Binarnie)");
        JMenuItem saveResults = new JMenuItem("Zapisz wyniki");
        JMenuItem exit = new JMenuItem("Wyjście");

        loadTxt.addActionListener(e -> openFileChooser("Wczytaj plik tekstowy"));
        loadBin.addActionListener(e -> openFileChooser("Wczytaj plik binarny"));
        saveResults.addActionListener(e -> JOptionPane.showMessageDialog(this, "Wyniki zapisane pomyślnie!"));
        exit.addActionListener(e -> System.exit(0));

        fileMenu.add(loadTxt);
        fileMenu.add(loadBin);
        fileMenu.addSeparator();
        fileMenu.add(saveResults);
        fileMenu.addSeparator();
        fileMenu.add(exit);

        menuBar.add(fileMenu);
        return menuBar;
    }

    private JPanel createToolBar() {
        JPanel toolBar = new JPanel();
        toolBar.setLayout(new BoxLayout(toolBar, BoxLayout.Y_AXIS));
        toolBar.setBorder(BorderFactory.createTitledBorder("Narzędzia"));
        toolBar.setPreferredSize(new Dimension(220, 0));
        
        // Opcje wyświetlania
        JCheckBox showLabels = new JCheckBox("Pokaż etykiety", true);
        JCheckBox showWeights = new JCheckBox("Pokaż wagi", true);
        
        showLabels.addActionListener(e -> {
            graphPanel.setLabelsVisible(showLabels.isSelected());
            graphPanel.repaint();
        });

        JLabel zoomLabel = new JLabel("Pole widzenia (Zoom):");
        JSlider zoomSlider = new JSlider(50, 150, 100);
        zoomSlider.addChangeListener(e -> {
            graphPanel.setScale(zoomSlider.getValue() / 100.0);
            graphPanel.repaint();
        });

        toolBar.add(new JLabel("Algorytm:"));
        toolBar.add(algoCombo);
        toolBar.add(Box.createRigidArea(new Dimension(0, 15)));
        toolBar.add(showLabels);
        toolBar.add(showWeights);
        toolBar.add(Box.createRigidArea(new Dimension(0, 15)));
        toolBar.add(zoomLabel);
        toolBar.add(zoomSlider);

        return toolBar;
    }

    private void openFileChooser(String title) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle(title);
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_VALUE) {
            File selectedFile = fileChooser.getSelectedFile();
            JOptionPane.showMessageDialog(this, "Wczytano: " + selectedFile.getName());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GraphApp().setVisible(true);
        });
    }
}

