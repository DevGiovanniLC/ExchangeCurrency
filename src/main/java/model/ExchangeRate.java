package model;


import java.time.LocalDateTime;

public class ExchangeRate {
    private final Currency From;
    private final Currency To;
    private final Rate Rate;

    public ExchangeRate(Currency from, Currency to) {
        From = from;
        To = to;
        Rate = updateRate();
    }

    private Rate updateRate() {
        Double valueFrom = (this.From.referenceValue()*1000);
        Double valueTo = (this.To.referenceValue()*1000);
        return new Rate(
                (valueTo/valueFrom),
                LocalDateTime.now()
        );
    }


    @Override
    public String toString() {
        return "ExchangeRate{" +
                "From=" + From +
                ", To=" + To +
                ", Rate=" + Rate +
                '}';
    }
}
