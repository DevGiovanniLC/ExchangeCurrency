package swing;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MainWindow extends JFrame {

    private final MainPanel mainPanel;
    public MainWindow(List<String> currencyList) throws HeadlessException
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Exchange Currencies APP");
        setSize(800,500);
        setMinimumSize(new Dimension(300,550));
        setLocationRelativeTo(null);

        this.mainPanel = new MainPanel(currencyList);
        setContentPane(this.mainPanel);
    }

    public String getSelectedDate()
    {
              return this.mainPanel.getSelectedDate();
    }
}
