package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.util.List;

public class MainPanel extends JPanel{

    private final CurrencyPanel currencyPanel;
    private final JPanel selectionPanel;

    public MainPanel(List<String> currencyList) {
        super(true);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(28,28,28));

        this.currencyPanel = new CurrencyPanel(currencyList);
        this.selectionPanel = new SelectionPanel();


        initializeComponents();
    }

    public String getSelectedDate(){

        //return selectedDate.getSelectedDate();
        return null;
    }

    private void initializeComponents() {
        add(this.currencyPanel);
        add(this.selectionPanel);
        setVisible(true);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Color color1 = new Color(87,50,25); // Color inicial
        Color color2 = new Color(21,56,57); // Color final

        GradientPaint gradientPaint = new GradientPaint(
                new Point2D.Double(10, 10), color1,
                new Point2D.Double(getWidth(), getHeight()), color2
        );

        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(gradientPaint);

        g2d.fillRect(0, 0, getWidth(), getHeight());
    }

}
