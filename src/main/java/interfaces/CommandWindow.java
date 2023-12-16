package interfaces;

import Commands.Controller;

import java.time.LocalDate;

public interface CommandWindow {

    LocalDate getSelectedDate();

    double getAmountToExchange();

    String getCurrencyFrom();

    String getCurrencyTo();

    void setAmountExchanged(Double amount);

    void setController(Controller controller);
}
