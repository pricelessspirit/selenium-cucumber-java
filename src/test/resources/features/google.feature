Feature: The Google homepage allows user to perform a search.

  Scenario: Users can perform a search on Google
    Given I navigate to "https://www.google.com"
    Then I wait for 3 sec
    Then I enter "Cucumber" into input field having name "q"
    Then I wait for 2 sec
    #Then I click on element having name "btnK"
    Then I forcefully click on element having name "btnK"
    Then I wait for 2 sec
    Then I take screenshot
    Then link having partial text "cucumber" should be present
    Then I wait for 5 sec
