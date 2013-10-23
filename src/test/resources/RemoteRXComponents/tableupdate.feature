Feature: Update to table is reflected in underlying viewport

@focus
  Scenario: Change a single underlying data element in the table, and ensure its reflected in the viewport
    Given a table with the following data
    | id | instrument | counterparty  | side | notional |
    | 4  | GBPUSD     | counterparty1 | Sell | 12.2     |
    | 2  | GBPEUR     | counterparty2 | Buy  | 12.3     |
    | 3  | GBPJPY     | counterparty3 | Sell | 12.4     |
    And a viewpoint of 2
    When the following data is changed
    | id | instrument | counterparty   | side | notional |
    | 2  |            | counterparty22 |      |  0       |
    Then the viewport looks like
    | id | instrument | counterparty   | side | notional |
    | 4  | GBPUSD     | counterparty1  | Sell | 12.2     |
    | 2  | GBPEUR     | counterparty22 | Buy  | 12.3     |
