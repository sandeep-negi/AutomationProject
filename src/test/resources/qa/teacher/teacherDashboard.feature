@teacher @b2b @teacher_dashboard
Feature: Teacher dashboard feature

  @B2B001 @smoke @f2
  Scenario: Verify teacher should be able to logged in successfully and navigate to the dashboard
    Given the user is on login page
    And the user logins using api with details :
      | userEmail                         | userPassword |
      | auto_teacher+db12@splashlearn.com | 123456       |
    Then user should login successfully to his dashboard

  @B2B002 @f2
  Scenario: Verify user navigation from 'Select your classroom' page
    Given the user is on login page
    And the user logins using api with details :
      | userEmail                         | userPassword |
      | auto_teacher+db12@splashlearn.com | 123456       |
    And the user selects on student experience option
    Then user should navigate to classroom page

  @B2B001 @smoke @prod
  Scenario: Verify teacher should be able to logged in successfully and navigate to the dashboard
    Given the user is on login page
    And the user logins using api with details :
      | userEmail                | userPassword |
      | tuser3766+abcd@gmail.com | 123456       |
    Then user should login successfully to his dashboard

  @B2B002 @prod
  Scenario: Verify user navigation from 'Select your classroom' page
    Given the user is on login page
    And the user logins using api with details :
      | userEmail                | userPassword |
      | tuser3766+abcd@gmail.com | 123456       |
    And the user selects on student experience option
    Then user should navigate to classroom page

