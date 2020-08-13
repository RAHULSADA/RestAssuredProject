Feature: Verify credit cards

  Scenario: Verify Avion card
    Given User has an active Avion card
    When user logs into website user name "user1" password "pwd1"
    Then credit card home page should be displayed
    And Avion card details should be displayed in summary section

  Scenario: Verify disabled cards
    Given User has disabled card
    When user logs into website user name "user2" password "pwd2"
    Then credit card home page should be displayed
    And Avion card details should be displayed in summary section
    But disabled card section should not be displayed in summary