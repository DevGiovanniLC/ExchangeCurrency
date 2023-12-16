package swing;

import swing.components.CalendarLabel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.time.LocalDate;

public class SelectionPanel extends JPanel {

    private final CalendarLabel selectedDate;
    private final JButton Exchangebutton;
    private final JLabel icon;

    public SelectionPanel() {
        setLayout(new FlowLayout());
        setBackground(new Color(0,true));
        setBorder(new EmptyBorder(10,0,0,0));

        this.selectedDate = new CalendarLabel("Selected Date");
        this.Exchangebutton = new JButton("Exchange");
        this.icon = new JLabel(new ImageIcon("src/main/resources/Icon.png"));

        customizeComponents();
        initializeComponents();
    }

    public LocalDate getSelectedDate() {
        return this.selectedDate.getSelectedDate();
    }


    private void customizeComponents() {
        Exchangebutton.setFont(new Font("Arial", Font.BOLD, 20));
        Exchangebutton.setBorder(new EmptyBorder(10,20,10,20));
        Exchangebutton.setSize(300,300);
        
        icon.setOpaque(false);
        icon.setBorder(new EmptyBorder(0,60,0,20));
    }

    private void initializeComponents() {
             add(selectedDate);
             add(Exchangebutton);
             add(icon);
    }

    public JButton getExchangeButton() {
        return this.Exchangebutton;
    }
}
