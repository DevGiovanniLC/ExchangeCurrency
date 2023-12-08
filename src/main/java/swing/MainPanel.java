package swing;

import swing.components.CalendarLabel;
import swing.components.CurrencyPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

public class MainPanel extends JPanel{

    private final CurrencyPanel currencyPanel;
    private final CalendarLabel selectedDate;
    private final JPanel selectionPanel;
    private final JButton button;

    public MainPanel(List<String> currencyList) {
        super(true);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(28,28,28));

        this.currencyPanel = new CurrencyPanel(currencyList);
        this.selectionPanel = new JPanel();
        this.selectedDate = new CalendarLabel("Selected Date");
        this.button = new JButton("Exchange");
        this.button.setFont(new Font("Arial", Font.BOLD, 25));
        customizeSelectionPanel(selectionPanel);
        initializeComponents();
    }

    private void customizeSelectionPanel(JPanel panel) {
        panel.setLayout(new FlowLayout());
        panel.setBorder(new EmptyBorder(0,15,0,25));
        panel.setBackground(new Color(28,28,28));
    }



    private void initializeComponents() {

        add(this.currencyPanel);
        add(this.selectionPanel);
        selectionPanel.add(selectedDate);
        selectionPanel.add(button);
        setVisible(true);
    }

    public String getSelectedDate(){
        return selectedDate.getSelectedDate();
    }


}
