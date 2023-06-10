@teacher @b2b @home_access
Feature: Teacher Home Access feature

  @B2B003 @smoke @regression @f2
  Scenario: Verify Home Access page on click of enable Home Access button
    Given the user is on login page
    And the user logins using api with details :
      | userEmail                         | userPassword |
      | auto_teacher+db12@splashlearn.com | 123456       |
    And the user clicks on enable home access option
    Then the user should navigate to home access page


  @B2B004 @f2
  Scenario: Verify back button on home access page
    Given the user is on login page
    And the user logins using api with details :
      | userEmail                         | userPassword |
      | auto_teacher+db12@splashlearn.com | 123456       |
    And the user clicks on enable home access option
    And the user clicks on back button on home page
    Then the user should navigate to teacher dashboard

  @B2B003 @smoke @regression @prod
  Scenario: Verify Home Access page on click of enable Home Access button
    Given the user is on login page
    And the user logins using api with details :
      | userEmail                | userPassword |
      | tuser3766+abcd@gmail.com | 123456       |
    And the user clicks on enable home access option
    Then the user should navigate to home access page


  @B2B004 @prod
  Scenario: Verify back button on home access page
    Given the user is on login page
    And the user logins using api with details :
      | userEmail                | userPassword |
      | tuser3766+abcd@gmail.com | 123456       |
    And the user clicks on enable home access option
    And the user clicks on back button on home page
    Then the user should navigate to teacher dashboard