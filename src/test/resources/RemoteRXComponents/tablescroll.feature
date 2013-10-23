Feature: Scroll within a viewpoint of a table

  Background: View on a table table that has a limited viewport

  Scenario: View contains correct rows based on viewport
    Given a table with the following data
    | id | instrument | counterparty  | side | notional |
    | 4  | GBPUSD     | counterparty1 | Sell | 12.2     |
    | 2  | GBPEUR     | counterparty2 | Buy  | 12.3     |
    | 3  | GBPJPY     | counterparty3 | Sell | 12.4     |
    And a viewpoint of 2
    Then the viewport looks like
    | id | instrument | counterparty  | side | notional |
    | 4  | GBPUSD     | counterparty1 | Sell | 12.2     |
    | 2  | GBPEUR     | counterparty2 | Buy  | 12.3     |

  Scenario: Scroll forwards
    Given a table with the following data
    | id | instrument | counterparty  | side | notional |
    | 4  | GBPUSD     | counterparty1 | Sell | 12.2     |
    | 2  | GBPEUR     | counterparty2 | Buy  | 12.3     |
    | 3  | GBPJPY     | counterparty3 | Sell | 12.4     |
    And a viewpoint of 2
    When scolling forwards by 1
    Then the viewport looks like
    | id | instrument | counterparty  | side | notional |
    | 2  | GBPEUR     | counterparty2 | Buy  | 12.3     |
    | 3  | GBPJPY     | counterparty3 | Sell | 12.4     |

  Scenario: Scroll backwards
    Given a table with the following data
    | id | instrument | counterparty  | side | notional |
    | 4  | GBPUSD     | counterparty1 | Sell | 12.2     |
    | 2  | GBPEUR     | counterparty2 | Buy  | 12.3     |
    | 3  | GBPJPY     | counterparty3 | Sell | 12.4     |
    And a viewpoint of 2
    When scolling forwards by 1
    And scolling backwards by 1
    Then the viewport looks like
    | id | instrument | counterparty  | side | notional |
    | 4  | GBPUSD     | counterparty1 | Sell | 12.2     |
    | 2  | GBPEUR     | counterparty2 | Buy  | 12.3     |
