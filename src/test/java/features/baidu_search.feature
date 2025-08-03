Feature: Baidu Search Test

  Rule: valid search

    Background:
      Given I start browser

    Scenario: Search test 1
      Given I open Baidu homepage
      When I search for "testng"
      Then I should see more than 6 results

    Scenario Outline: Search test 2
      Given I open Baidu homepage
      When I search for "<keyword>"
      Then I should see more than <count> results
      Examples:
        |  keyword | count |
        |  python  | 8     |
        |  java    | 8     |
        |  golang  | 8     |
        |  javascript | 8     |

  Rule: invalid search
    Background:
      Given I start browser

    Scenario Outline: Search test 3
      Given I open Baidu homepage
      When I search for "<keyword>"
      Then I should see more than <count> results
      Examples:
        |  keyword | count |
        |  python3  | 8     |
        |  java 1.8    | 8     |
        |  golang2  | 8     |
        |  typescript | 8     |