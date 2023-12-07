package swing;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    private final MainPanel mainPanel;
    public MainWindow() throws HeadlessException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Exchange Currencies APP");
        setSize(600,600);
        setLocationRelativeTo(null);

        this.mainPanel = new MainPanel();
        setContentPane(this.mainPanel);

    }

    public String getSelectedDate(){
              return this.mainPanel.getSelectedDate();
    }
}
