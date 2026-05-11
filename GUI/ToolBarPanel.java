import javax.swing.*;
import java.awt.*;

public class ToolBarPanel extends JPanel {
    private GraphPanel graphPanel;

    public ToolBarPanel(GraphPanel graphPanel) {
        this.graphPanel = graphPanel;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createTitledBorder("Narzędzia"));
        setPreferredSize(new Dimension(220, 0));

        // Deklaracja brakującej listy algorytmów
        String[] algorithms = {"Tutte", "Fruchterman-Reingold"};
        JComboBox<String> algoCombo = new JComboBox<>(algorithms);

        // Opcje wyświetlania
        JCheckBox showLabels = new JCheckBox("Pokaż etykiety", true);
        JCheckBox showWeights = new JCheckBox("Pokaż wagi", true);

        showLabels.addActionListener(e -> {
            if (graphPanel != null) {
                graphPanel.setLabelsVisible(showLabels.isSelected());
                graphPanel.repaint();
            }
        });

        JLabel zoomLabel = new JLabel("Pole widzenia (Zoom):");
        JSlider zoomSlider = new JSlider(50, 150, 100);
        zoomSlider.addChangeListener(e -> {
            if (graphPanel != null) {
                graphPanel.setScale(zoomSlider.getValue() / 100.0);
                graphPanel.repaint();
            }
        });

        add(new JLabel("Algorytm:"));
        add(algoCombo);
        add(Box.createRigidArea(new Dimension(0, 15)));
        add(showLabels);
        add(showWeights);
        add(Box.createRigidArea(new Dimension(0, 15)));
        add(zoomLabel);
        add(zoomSlider);
    }
}
