Feature: Coffee Shop Loyalty Card
  After every drink purchase you get a stamp, after 6 stamps you got a croissant and 12 stamps you get  a free drink

  Background:
    Given the following drink categories
    | Drink      | Category    | Stamps |
    | Latte      | Hot Coffee  |   1    |
    | Iced Mocha | Iced Coffee |   2    |
    | Earl Grey  | Tea         |   1    |
    | Affrogato  | Special     |   3    |
    | Frappe     | Special     |   3    |
    | Flat White | Hot Coffee  |   1    |
    | Iced Latte | Iced Coffee |   2    |

  Scenario Outline: Getting Stamps when buying drinks
    Given CustomerA wants a drink
    When CustomerA purchases <Quantity> <Drink> drinks
    Then They should earn <Stamps> stamps
    Examples:
    | Drink     |  Quantity |  Stamps |
    | Latte     |    2      |    2    |
    | Frappe    |    1      |    3    |
    | Iced Latte|    3      |    6    |
    | Earl Grey |    3      |    3    |
