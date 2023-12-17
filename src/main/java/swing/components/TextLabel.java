package swing.components;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.text.DecimalFormat;

public class TextLabel extends JPanel {
    JTextField textField;
    JLabel label;

    public TextLabel(String text) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new EmptyBorder(10,0,15,0));
        setBackground(new Color(0,true));


        this.label = new JLabel(text + ": ");
        this.textField = new JTextField();
        customizeComponents();
        initializeComponents();
    }

    public TextLabel setEditable(boolean bool){
        textField.setEditable(bool);
        return this;
    }

    public TextLabel setInitialValue(Double value){
        textField.setText(String.valueOf(value));
        return this;
    }


    private void customizeComponents() {
        this.label.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
        this.label.setForeground(Color.WHITE);
        this.label.setBorder(new EmptyBorder(0,0,5,0));
        this.label.setOpaque(false);
        this.textField.setBorder(new EmptyBorder(5,10,5,5));
        this.textField.setFont(new Font("Arial", Font.BOLD, 16));
    }

    private void initializeComponents(){
        add(this.label);
        add(this.textField);
        setVisible(true);
    }


    public double getAmountToExchange() {
        try {
            return Double.parseDouble(this.textField.getText());
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "\n" +
                    "The amount to be exchanged must be a number", "To exchange Alert", JOptionPane.INFORMATION_MESSAGE);
        }
        return 0;
    }

    public void setAmountExchanged(Double amount) {
        this.textField.setText(formatDouble(amount));
    }

    private String formatDouble(Double amount){
        DecimalFormat format = new DecimalFormat("#.###");
        return format.format(amount);
    }
}