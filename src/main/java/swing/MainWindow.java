package swing;

import Commands.Controller;
import interfaces.CommandWindow;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.List;


public class MainWindow extends JFrame implements CommandWindow {

    private final MainPanel mainPanel;
    public MainWindow(List<String> currencyList) throws HeadlessException
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Exchange Currencies APP");
        setIconImage(new ImageIcon("src/main/resources/Icon.png").getImage());
        setSize(800,450);
        setResizable(false);
        setLocationRelativeTo(null);

        this.mainPanel = new MainPanel(currencyList);
        setContentPane(this.mainPanel);
        setVisible(true);
    }

    @Override
    public LocalDate getSelectedDate()
    {
        return this.mainPanel.getSelectedDate();
    }


    @Override
    public double getAmountToExchange()
    {
        return this.mainPanel.getAmountToExchange();
    }

    @Override
    public String getCurrencyFrom()
    {
        return this.mainPanel.getCurrencyFrom().substring(0,3);
    }

    @Override
    public String getCurrencyTo()
    {
        return this.mainPanel.getCurrencyTo().substring(0,3);
    }

    @Override
    public void setAmountExchanged(Double amount)
    {
        this.mainPanel.setAmountExchanged(amount);
    }

    @Override
    public void setController(Controller controller) {
        JButton exchangeButton = this.mainPanel.getExchangeButton();
        exchangeButton.addActionListener(e -> controller.execute("exchange"));
    }
}
