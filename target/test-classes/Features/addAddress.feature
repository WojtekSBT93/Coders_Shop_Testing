Feature: Add address





  Scenario Outline: test

    Given Page https://prod-kurs.coderslab.pl/index.php opened in browser
    When Sign in link clicked on home page
    And email entered in login form email input
    And password entered in login form password input
    And SignIn button clicked
    And click addresses btn
    And address form filled <alias> <address> <city> <zip/postal code> <country> <phone>
    And click save
    Then address added
    Then delete added address
    And check if address is deleted
    And exit

    Examples:
      | alias| address| city| zip/postal code|country|phone|
      | Flat| Road    | Toledo | 30900          | 1 | 1231231231 |










