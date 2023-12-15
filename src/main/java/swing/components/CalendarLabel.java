package swing.components;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class CalendarLabel extends JPanel {
    UtilDateModel model;
    JDatePickerImpl datePicker;
    JLabel label;

    public CalendarLabel(String text) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new EmptyBorder(0,0,25,55));
        setBackground(new Color(0,true));

        this.label = new JLabel(text + ": ");
        this.model = new UtilDateModel();
        this.model.setSelected(true);
        JDatePanelImpl datePanel = new JDatePanelImpl(model);
        this.datePicker = new JDatePickerImpl(datePanel);
        customizeComponents();
        initializeComponents();
    }

    private void customizeComponents() {
        this.label.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
        this.label.setForeground(Color.WHITE);
        this.label.setOpaque(false);
    }

    private void initializeComponents(){
        add(this.label);
        add(this.datePicker);
        setVisible(true);
    }

    public String getSelectedDate(){
          return model.getYear()+"-"+model.getMonth()+"-"+model.getDay();
    }

}