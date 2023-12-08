package swing;

import javax.swing.*;
import java.awt.*;
import java.util.Collections;
import java.util.List;

public class MainWindow extends JFrame {

    private final MainPanel mainPanel;
    public MainWindow(List<String> currencyList) throws HeadlessException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Exchange Currencies APP");
        setSize(650,400);
        setLocationRelativeTo(null);
        Collections.sort(currencyList);
        this.mainPanel = new MainPanel(currencyList);
        setContentPane(this.mainPanel);

    }

    public String getSelectedDate(){
              return this.mainPanel.getSelectedDate();
    }
}
