package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;

import java.time.LocalDate;
import java.util.List;

public class MainPanel extends JPanel{

    private final CurrencyPanel currencyPanel;
    private final SelectionPanel selectionPanel;

    public MainPanel(List<String> currencyList) {
        super(true);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(28,28,28));

        this.currencyPanel = new CurrencyPanel(currencyList);
        this.selectionPanel = new SelectionPanel();


        initializeComponents();
    }

    private void initializeComponents() {
        add(this.currencyPanel);
        add(this.selectionPanel);
        setVisible(true);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Color color1 = new Color(87,50,25);
        Color color2 = new Color(21,56,57);

        GradientPaint gradientPaint = new GradientPaint(
                new Point2D.Double(10, 10), color1,
                new Point2D.Double(getWidth(), getHeight()), color2
        );

        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(gradientPaint);

        g2d.fillRect(0, 0, getWidth(), getHeight());
    }

    protected double getAmountToExchange() {
        return this.currencyPanel.getAmountToExchange();
    }

    protected LocalDate getSelectedDate() {
        return this.selectionPanel.getSelectedDate();
    }

    protected String getCurrencyFrom() {
        return this.currencyPanel.getCurrencyFrom();
    }

    protected String getCurrencyTo() {
        return this.currencyPanel.getCurrencyTo();
    }

    protected void setAmountExchanged(Double amount) {
        this.currencyPanel.setAmountExchanged(amount);
    }

    protected JButton getExchangeButton() {
        return this.selectionPanel.getExchangeButton();
    }
}
