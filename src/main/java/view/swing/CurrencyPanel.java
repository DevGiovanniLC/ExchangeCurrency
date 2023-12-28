package view.swing;

import view.swing.components.ComboLabel;
import view.swing.components.TextLabel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;


public class CurrencyPanel extends JPanel {
    private final JPanel toCurrencyForm;
    private final JPanel fromCurrencyForm;
    private final TextLabel textLabelFrom;
    private final TextLabel textLabelTo;
    private final ComboLabel comboLabelFrom;
    private final ComboLabel comboLabelTo;

    public CurrencyPanel(List<String> currencyList) {
        super();
        setLayout(new GridLayout());
        setBorder(new EmptyBorder(20,0, 0,0));
        setBackground(new Color(0,true));
        toCurrencyForm = new JPanel();
        fromCurrencyForm = new JPanel();
        this.textLabelFrom = new TextLabel("Amount to exchange");
        this.textLabelTo = new TextLabel("Amount exchanged");
        this.comboLabelFrom = new ComboLabel("", currencyList);
        this.comboLabelTo = new ComboLabel("", currencyList);
        customizeForm(toCurrencyForm);
        customizeForm(fromCurrencyForm);
        initializeComponents();
    }

    private void customizeForm(JPanel form) {
        form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));
        form.setBorder(new EmptyBorder(0,30,10,30));
        form.setBackground(new Color(0,true));
    }

    private void initializeComponents() {
        this.add(this.fromCurrencyForm);
        this.add(this.toCurrencyForm);
        fromCurrencyForm.add(this.comboLabelFrom);
        fromCurrencyForm.add(this.textLabelFrom.setInitialValue(0.));
        toCurrencyForm.add(this.comboLabelTo);
        toCurrencyForm.add(this.textLabelTo.setEditable(false));
        toCurrencyForm.setVisible(true);
        fromCurrencyForm.setVisible(true);
        setVisible(true);
    }

    public double getAmountToExchange() {
        return this.textLabelFrom.getAmountToExchange();
    }

    public String getCurrencyFrom() {
        return this.comboLabelFrom.getCurrency();
    }

    public String getCurrencyTo() {
        return this.comboLabelTo.getCurrency();
    }

    public void setAmountExchanged(Double amount) {
        this.textLabelTo.setAmountExchanged(amount);
    }
}
