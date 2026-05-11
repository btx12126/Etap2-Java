import javax.swing.*;
import java.io.File;

public class AppMenuBar extends JMenuBar {
    private JFrame parentFrame;

    public AppMenuBar(JFrame parentFrame) {
        this.parentFrame = parentFrame;

        JMenu fileMenu = new JMenu("Plik");
        JMenuItem loadTxt = new JMenuItem("Wczytaj (TXT)");
        JMenuItem loadBin = new JMenuItem("Wczytaj (Binarnie)");
        JMenuItem saveResults = new JMenuItem("Zapisz wyniki");
        JMenuItem exit = new JMenuItem("Wyjście");

        loadTxt.addActionListener(e -> openFileChooser("Wczytaj plik tekstowy"));
        loadBin.addActionListener(e -> openFileChooser("Wczytaj plik binarny"));
        saveResults.addActionListener(e -> JOptionPane.showMessageDialog(parentFrame, "Wyniki zapisane pomyślnie!"));
        exit.addActionListener(e -> System.exit(0));

        fileMenu.add(loadTxt);
        fileMenu.add(loadBin);
        fileMenu.addSeparator();
        fileMenu.add(saveResults);
        fileMenu.addSeparator();
        fileMenu.add(exit);

        add(fileMenu);
    }

    private void openFileChooser(String title) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle(title);
        int result = fileChooser.showOpenDialog(parentFrame);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            JOptionPane.showMessageDialog(parentFrame, "Wczytano: " + selectedFile.getName());
        }
    }
}