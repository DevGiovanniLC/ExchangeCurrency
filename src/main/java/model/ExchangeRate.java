package model;


public class ExchangeRate {
    private final Currency From;
    private final Currency To;
    private Value Rate;

    public ExchangeRate(Currency from, Currency to, Value rate) {
        From = from;
        To = to;
        Rate = rate;
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
