package swing.components;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

public class ComboLabel extends JPanel {
    JComboBox<Object> comboBox;
    JLabel label;

    public ComboLabel(String text, List<String> elements) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new EmptyBorder(0,0,15,0));
        setBackground(new Color(0,true));

        this.label = new JLabel(text + " ");
        this.comboBox = new JComboBox<>(elements.toArray(new String[0]));
        customizeComponents();
        initializeComponents();
    }

    private void customizeComponents() {
        this.label.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
        this.label.setForeground(Color.WHITE);
        this.setOpaque(false);
    }

    private void initializeComponents(){
        add(this.label);
        add(this.comboBox);
        setVisible(true);
    }

}