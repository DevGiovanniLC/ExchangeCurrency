package swing.components;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class TextLabel extends JPanel {
    JTextField textField;
    Label label;

    public TextLabel(String text) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new EmptyBorder(10,0,15,0));
        setBackground(new Color(28,28,28));


        this.label = new Label(text + ": ");
        this.textField = new JTextField();
        customizeComponents();
        initializeComponents();
    }

    public TextLabel setEditable(boolean bool){
        textField.setFocusable(bool);
        return this;
    }

    private void customizeComponents() {
        this.label.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
        this.label.setForeground(Color.WHITE);
    }

    private void initializeComponents(){
        add(this.label);
        add(this.textField);
        setVisible(true);
    }



}