Feature: User functionality


  @wip
  Scenario:Add a user and validate the user has been added to the table
    Given user should navigate to the website
    When user click on add user button
    And user enter the following information
      | First Name | shahin     |
      | Last Name  | abdi       |
      | User Name  | shahin1992 |
      | Password   | @2277      |
    And user should select company
    And user should select the role
    And user continue following information
      | E-mail     | shahin.abdi107@gmail.com |
      | Cell Phone | +34678110260             |
    And user click the save button
    Then user should verify new user is added

  @wip2
  Scenario: Delete the user novak from the table and validate the user has been deleted
    Given user should navigate to the website
    When user click on the delete button of the user with the name "novak"
    And user should click on OK button
    Then user should verify novak is deleted
