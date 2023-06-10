@teacher @b2b @assessment
Feature: Assessment feature

  @B2B005 @smoke @regression @f2
  Scenario: Verify teacher is able to delete assessment
    Given the user is on login page
    And the user logins using api with details :
      | userEmail                         | userPassword |
      | auto_teacher+db12@splashlearn.com | 123456       |
    When user deletes the assessment using api having details :
      | klass_id                         | assessment_name | module_id |
      | 3D8B41C68A864A33A5C032F78408F72A | Addition        | 7         |
   # Then the user should be able to delete the assessment

  @B2B005 @smoke @regression @prod
  Scenario: Verify teacher is able to delete assessment
    Given the user is on login page
    And the user logins using api with details :
      | userEmail                | userPassword |
      | tuser3766+abcd@gmail.com | 123456       |
    When user deletes the assessment using api having details :
      | klass_id                         | assessment_name | module_id |
      | 346F36DC5A1E4214AE1C64BF6C53B413 | Addition        | 7         |