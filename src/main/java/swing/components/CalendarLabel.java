package swing.components;

import net.sourceforge.jdatepicker.DateModel;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.time.LocalDate;


public class CalendarLabel extends JPanel {
    UtilDateModel model;
    JDatePanelImpl datePanel;
    JDatePickerImpl datePicker;
    JLabel label;

    public CalendarLabel(String text) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new EmptyBorder(0,0,25,30));
        setBackground(new Color(0,true));

        this.label = new JLabel(text);
        this.model = new UtilDateModel();
        this.model.setSelected(true);
        datePanel = new JDatePanelImpl(model);
        this.datePicker = new JDatePickerImpl(datePanel);
        customizeComponents();
        initializeComponents();
    }

    private void customizeComponents() {
        this.label.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 18));
        this.label.setForeground(Color.WHITE);
        this.label.setOpaque(false);
        this.label.setBorder(new EmptyBorder(0,5,5,0));
        this.datePicker.setCursor(new Cursor(Cursor.HAND_CURSOR));

        this.datePicker.getModel().addChangeListener(e -> {
            
            DateModel<?> model = datePicker.getModel();
            LocalDate selectedDate = LocalDate.of(model.getYear(), model.getMonth()+1, model.getDay());
            LocalDate actualDate = LocalDate.now();

            if (selectedDate.isAfter(actualDate)){
                     model.setDate(actualDate.getYear(),actualDate.getMonth().getValue()-1, actualDate.getDayOfMonth());
            }
        });
    }

    private void initializeComponents(){
        add(this.label);
        add(this.datePicker);
        setVisible(true);
    }

    public LocalDate getSelectedDate()
    {
          return LocalDate.of(model.getYear(),model.getMonth()+1,model.getDay());
    }

}