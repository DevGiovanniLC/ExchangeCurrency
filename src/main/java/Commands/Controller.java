package Commands;

import interfaces.Command;
import interfaces.CommandWindow;
import interfaces.ExchangeLoader;

import java.util.HashMap;
import java.util.Map;

public class Controller {
    Map<String, Command> commandMap;

    public Controller(CommandWindow window, ExchangeLoader exchangeLoader) {
        this.commandMap = new HashMap<>();
        this.commandMap.put("exchange", new ExchangeCommand(window, exchangeLoader));
    }

    public void execute(String command){
        this.commandMap.get(command).execute();
    }
}
