Feature: As a Xero User,
  In order to manage my business successfully,
  I want to be able to add an "ANZ (NZ)" bank account inside any Xero Organisation.

  Background: 
    Given Xero Account details to login "jothi2k9@gmail.com" and "Test1234"

  Scenario Outline: Adding ANZ (NZ) bank account to Demo Company
    Given Xero user on Dashboard
    When Xero user adds "<Bank>" Bank Account from "<From>" for "<AccountType>"
    Then the added account should be available at Bank Accounts

    Examples: 
      | Bank     | From                             | AccountType           |
      | ANZ (NZ) | Dashboard  > Manage Bank Account | Everyday (day-to-day) |
      | ANZ (NZ) | Accounting > Bank Accounts       | Everyday (day-to-day) |
      | ANZ (NZ) | Accounting > Bank Accounts       | Loan                  |
      | ANZ (NZ) | Accounting > Bank Accounts       | Term Deposit          |
      | ANZ (NZ) | Accounting > Bank Accounts       | Credit Card           |
      | ANZ (NZ) | Accounting > Bank Accounts       | Other                 |
      | ANZ (NZ) | Accounting > Chart of accounts   | Everyday (day-to-day) |
      | ANZ (NZ) | Accounting > Chart of accounts   | Loan                  |
      | ANZ (NZ) | Accounting > Chart of accounts   | Term Deposit          |
      | ANZ (NZ) | Accounting > Chart of accounts   | Credit Card           |
      | ANZ (NZ) | Accounting > Chart of accounts   | Other                 |

  #######################################################################################################################################
  Scenario Outline: Adding multiple ANZ (NZ) bank account to Demo Company
    Given Xero user on Dashboard
    When Xero user adds multiple "<Bank>" Bank Accounts from "<From>" for "<AccountType>"
    Then the added account should be available at Bank Accounts

    Examples: 
      | Bank     | From                           | AccountType                      |
      | ANZ (NZ) | Accounting > Bank Accounts     | Everyday (day-to-day), Loan      |
      | ANZ (NZ) | Accounting > Chart of accounts | Term Deposit, Credit Card, Other |

  #######################################################################################################################################
  Scenario: Validating the UI error while adding account
    Given Xero user on Dashboard
    When Xero user fails to update Account Name and Account Type and Account Number
    Then the appropriate "Missing" UI error should be displayed
