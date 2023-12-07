package swing;

import swing.components.CalendarLabel;
import swing.components.ComboLabel;
import swing.components.TextLabel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

public class MainPanel extends JPanel{

    private final JPanel form;
    private final Color backgroundColor;
    private final TextLabel textLabel;
    private final ComboLabel comboLabelFrom;
    private final ComboLabel comboLabelTo;
    private final CalendarLabel selectedDate;

    public MainPanel() {
        super(true);
        setLayout(new FlowLayout());
        setBackground(this.backgroundColor = new Color(28,28,28));

        form = new JPanel();
        this.textLabel = new TextLabel("Money");
        this.comboLabelFrom = new ComboLabel("From Currency", List.of("USD", "EUR"));
        this.comboLabelTo = new ComboLabel("To Currency", List.of("USD", "EUR"));
        this.selectedDate = new CalendarLabel("Selected Date");
        customizeForm();
        initializeComponents();
    }

    private void customizeForm() {

        form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));
        form.setBorder(new EmptyBorder(30,5,5,5));
        form.setBackground(backgroundColor);
    }

    private void initializeComponents() {
        this.add(this.form);
        form.add(this.textLabel);
        form.add(this.comboLabelFrom);
        form.add(this.comboLabelTo);
        form.add(this.selectedDate);
        setVisible(true);

    }

    public String getSelectedDate(){
        return selectedDate.getSelectedDate();
    }


}
