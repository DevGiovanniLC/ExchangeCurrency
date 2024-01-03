 # Currency Exchanger (Graphical Interface)

<br><br>
### Software Usage
***
The software has a simple functionality: currency exchange. To use this feature, you only need to select the original currency and the currency you want to exchange it to.
Afterward, enter the amount of the original currency and choose the date on which you want to view that currency exchange. By default, the selected date is the current one.
Finally, click the exchange button.

An image of the graphical interface is attached to facilitate the explanation:

![image](https://github.com/DevGiovanniLC/ExchangeCurrency-SWING/assets/92268681/829f285e-ca2b-41c4-9b54-d9d9329ae3a5)

<br><br>
### Architecture
***
The software is built in Java, making use of the JavaSwing framework oriented towards building applications with a graphical interface using the Model-View-Controller (MVC) architecture design.

<br><br>
### Dependencies and APIs
***
The API used to obtain the currency values is managed on this website: https://exchangeratesapi.io/.<br>
Key dependencies of the software include GSON, used for JSON deserialization, and jdatepicker, used to provide a better user experience when selecting a date for currency exchange.

<br><br>
