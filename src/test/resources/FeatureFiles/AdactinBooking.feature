Feature: Adactin Holtel Booking

  Scenario Outline: Successfull Booking
    When User should enter the login credentials with "<username>", "<password>" and click the login button
    When User should enter the Booking details such as "<Location>","<Hotels>","<Room type>","<Number of rooms>","<check in date>","<check out date>","<adults per room>","<children per room>" and click submit button
    And User should click the radio button and click search button
    And User should enter the personal details such as "<firstName>", "<lastName>", "<address>", "<ccno>", "<cctype>", "<exmonth>", "<expyear>", "<cvv>" and click Booknow button
    Then User should validate the Booking Confirmation

    Examples: 
      | username   | password | Location | Hotels      | Room type | Number of rooms | check in date | check out date | adults per room | children per room | firstName | lastName | address           | ccno             | cctype | exmonth  | expyear | cvv |
      | naveen1612 | P5EN3D   | Sydney   | Hotel Creek | Standard  |               1 | 21/09/2024    | 25/09/2024     |               2 | 1 - One           | Naveen    | Velusamy | Chennimalai,erode | 1234567890123456 | VISA   | December |    2028 | 123 |
