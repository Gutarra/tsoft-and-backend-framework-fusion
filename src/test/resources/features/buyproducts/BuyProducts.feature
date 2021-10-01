Feature: Buying products

    @buy-product
    Scenario Outline: Buying three products in opencart.abstracta.us
        Given go to the website
        When the user "<test_case>" sign in on page
        And buying two laptops and a camera
        And the user records more details "<test_case>"
        Then the order is registered

        Examples:
        | test_case |
        | 1         |

    @buy-product-auto
    Scenario Outline: Buying evening dresses in automationpractice.com
        Given go to the website automation
        When the user sign in on page
        And buying "<quantity>" product
        Then order is registered

        Examples:
            | quantity |
            |  1       |
