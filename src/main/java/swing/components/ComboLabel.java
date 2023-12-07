package swing.components;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

public class ComboLabel extends JPanel {
    JComboBox<Object> comboBox;
    Label label;

    public ComboLabel(String text, List<String> elements) {
        setBackground(new Color(28,28,28));
        setBorder(new EmptyBorder(10,0,10,0));

        this.label = new Label(text + ": ");
        this.comboBox = new JComboBox<>(elements.toArray(new String[0]));
        customizeComponents();
        initializeComponents();
    }

    private void customizeComponents() {
        this.label.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
        this.label.setForeground(Color.WHITE);
    }

    private void initializeComponents(){
        add(this.label);
        add(this.comboBox);
        setVisible(true);
    }

}