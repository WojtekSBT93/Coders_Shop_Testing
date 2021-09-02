Feature: Add address





  Scenario Outline: test



    Given Page https://prod-kurs.coderslab.pl/index.php opened in browser
    When Sign in link clicked on home page
    And email entered in login form email input
    And password entered in login form password input
    And SignIn button clicked
    And click addresses btn
    And click create new address btn
    And address form filled <alias> <address> <city> <zip/postal code> <country> <phone>
    And click save
    Then address added
    Then delete added address
    And check if address is deleted
    And exit

    Examples:
      | alias| address| city| zip/postal code|country|phone|
      | Flat| Road    | Toledo | 30900          | 1 | 1231231231 |


    Scenario: User add sweater to cart and pay by check in store

      Given User is logged in his account
      When User enter product name in searchbar
      And User choose Hummingbird Printed Sweater
      And User choose size and quantity
      And User confirm proceed to checkout
      And User confirm address
      And User confirm delivery option
      And User choose pay by check
      And Discount will be correctly charged
      And User agree to the terms of service
      And User confirm order with an obligation to pay
      Then User see info your order is confirmed











