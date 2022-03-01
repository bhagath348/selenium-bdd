@jupiter-toys @contact @shop
Feature: Jupiter Toys feature
  I want to traverse between diffecrent pages and validate success and failure functionality

  @failure @contact
  Scenario: As a user I want to go to contact page from home page and validate error messages for empty data
    Given I navigate Jupiter Toys website
    When I click on "Contact" CTA to navigate to "contact page"
    And I click on Submit button
    Then I should see error messages
    When I populate mandatory fields
    Then I should not see error messages

  @success @contact
  Scenario: As a user I want to go to contact page from home page and validate success messages
    Given I navigate Jupiter Toys website
    When I click on "Contact" CTA to navigate to "contact page"
    When I populate mandatory fields
    And I click on Submit button
    Then I should see successful submission message

  @failure @contact
  Scenario: As a user I want to go to contact page from home page and validate error messages for invalid data
    Given I navigate Jupiter Toys website
    When I click on "Contact" CTA to navigate to "contact page"
    And I populate mandatory fields with invalid data
    Then I should see error message for invalid data
    
  @success @shop
  Scenario: As a user I want to go to contact page from home page and add items to cart
    Given I navigate Jupiter Toys website
    When I click on "Shop" CTA to navigate to "shop page"
    And I click buy button 2 times on "Funny Cow"
    And I click buy button 1 times on "Fluffy Bunny"
    And I click the cart menu
    Then I should see the items are in the cart
