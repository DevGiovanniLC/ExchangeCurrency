package swing;

import swing.components.CalendarLabel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.time.LocalDate;

public class SelectionPanel extends JPanel {

    private final CalendarLabel selectedDate;
    private final JButton exchangeButton;
    private final JLabel icon;

    public SelectionPanel() {
        setLayout(new FlowLayout());
        setBackground(new Color(0,true));
        setBorder(new EmptyBorder(5,0,15,0));

        this.selectedDate = new CalendarLabel("Selected Date");
        this.exchangeButton = new JButton("Exchange");
        this.icon = new JLabel(new ImageIcon("src/main/resources/Icon.png"));

        customizeComponents();
        initializeComponents();
    }

    public LocalDate getSelectedDate() {
        return this.selectedDate.getSelectedDate();
    }


    private void customizeComponents() {
        exchangeButton.setFont(new Font("Arial", Font.BOLD, 20));
        exchangeButton.setBorder(new EmptyBorder(10,20,10,20));
        exchangeButton.setSize(300,300);
        exchangeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        icon.setOpaque(false);
        icon.setBorder(new EmptyBorder(-10,40,-5,5));
    }

    private void initializeComponents() {
             add(selectedDate);
             add(exchangeButton);
             add(icon);
    }

    public JButton getExchangeButton() {
        return this.exchangeButton;
    }
}
