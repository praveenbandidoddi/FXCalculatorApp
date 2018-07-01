# FXCalculatorApp

Forex Currency Conversion Calculator

This Application was built to convert currency from one to other using provided conversion rate and lookup table implemented using Factory Design Pattern.

It takes console input in the below format:

"ccy1 amount in ccy2"

ex: AUD 100.00 in USD

provides output in the below format:

"ccy1 amout1 = amount2 ccy2"

ex: AUD 100.00 = USD 83.71

This application currenctly supports following conversions:
 
     AUDUSD: 0.8371
     CADUSD: 0.8711
     USDCNY: 6.1715
     EURUSD: 1.2315
     GBPUSD: 1.5683
     NZDUSD: 0.7750
     USDJPY: 119.95
     EURCZK: 27.6028
     EURDKK: 7.4405
     EURNOK: 8.6651

Following lookup table would be used to deduce the cross currency logic:

     AUDCAD: USD
     AUDCNY: USD
     AUDCZK: USD
     AUDDKK: USD
     AUDEUR: USD
     AUDGBP: USD
     AUDJPY: USD
     AUDNOK: USD
     AUDNZD: USD
     CADCNY: USD
     CADCZK: USD
     CADDKK: USD
     CADEUR: USD
     CADGBP: USD
     CADJPY: USD
     CADNOK: USD
     CADNZD: USD
     CNYCZK: USD
     CNYDKK: USD
     CNYEUR: USD
     CNYGBP: USD
     CNYJPY: USD
     CNYNOK: USD
     CNYNZD: USD
     CZKDKK: EUR
     CZKGBP: USD
     CZKJPY: USD
     CZKNOK: EUR
     CZKNZD: USD
     CZKUSD: EUR
     DKKGBP: USD
     DKKJPY: USD
     DKKNOK: EUR
     DKKNZD: USD
     DKKUSD: EUR
     EURGBP: USD
     EURJPY: USD
     EURNZD: USD
     GBPJPY: USD
     GBPNOK: USD
     GBPNZD: USD
     JPYNOK: USD
     JPYNZD: USD
     NOKNZD: USD
     NOKUSD: EUR

All properties files are placed in /resources directory.

conversions.properties: holds conversion rates
lookup.properties: holds lookup table for conversion

In order to support new currency formats, we could easily add that support by updating properties file.

In Order to support additional Handlers to add additional fucntionality can be done by adding handler and updating it in Factory class, hence we can easily plug in additional functionalities without impacting the existing fucntionaloties and map them in factory class.

Ex: AUDJPY: This program uses "cross via USD" and use the AUDUSD and USDJPY rates. This works by first converting AUD to USD, and then USD to JPY.
For example 1 AUD = 0.8371 USD --> 0.8371 USD = 100.41 JPY --> 1 AUD = 100.41 JPY

This program does this as below:

AUD/JPY rate: 
- first, look up AUD/JPY in the above table.
- the resulting entry shows that you need to cross via USD
- next look up AUD/USD - the rate for this is fed direct
- now look up USD/JPY - also fed direct
- fetch the rates for AUD/USD and USD/JPY and generate the cross rate from there.

Getting Started:

This program can be deployed as an jar application by packaging into a jar and starting it up.

Prerequisites:
Installation of Java JRE 1.8
Copy generated jar and start it.
or
Import project as a Maven project and run it on IDE, ex: Eclipse/IntelliJ

Running the tests:

Provided Unit test cases can be run on IDE by right click on ForexCcalculatorApplicationTests.java and Run option.

Following unit test cases cover all the possible scenarios that this program can be run:

1) testConvertionOfAUDtoUSD: test case AUD to USD for direct conversion.
2) testConvertionOfAUDtoAUD: test case AUD to AUD for same currency conversion.
3) testConvertionOfAUDtoDKK: test case AUD to DKK for cross via currency conversion.
4) testConvertionOfJPYtoUSD: test case JPY to USD for cross via currency conversion.
5) testConvertionOfKRWtoFJD: test case KRW to FJD for invalid currency type/not supported currency conversion.

Built With:

Java using Factory Design Pattern. 
Maven - Dependency Management
Junit - for Unit test cases

Versioning:
1.0

Author:
Praveen Bandidoddi

License:
This project is licensed under the Cognizant Australia
