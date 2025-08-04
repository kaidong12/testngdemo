Feature: Demo for expression

  Rule: valid expression

    Background:
      Given I start demo

    Scenario: Single test
      Given I open text file "text file"
      When I input word "word1"
      Then I should see word "word1" in text file

    Scenario Outline: Text file test
      Given I open text file "<filename>"
      When I input word "<text>"
      And I input string "<string>"
      Then I should see word "<text>" in text file
      And I should see string "<string>" in text file
      Examples:
      | filename     |  text    | string   |
      | text file 1  |  c       | c ++     |
      | text file 2  |  python  | python 2 |
      | text file 3  |  java    | java 1.8 |
      | text_file_4  |  golang  | golang 2 |
      | text_file_5  |  javascript | nodejs 8 |

  Rule: invalid expression
    Background:
      Given I start demo

    Scenario Outline: Calculator test
      Given I open calculator
      When I input int <number1>
      And I input float <number2>
      Then I should see int <number1> in calculator
      And I should see float <number2> in calculator
      Examples:
        |  number1 | number2 |
        |  1       | 1.0     |
        |  2       | 2.0     |
        |  3       | 3.0     |
        |  4       | 4.0     |
        |  5       | 5.0     |