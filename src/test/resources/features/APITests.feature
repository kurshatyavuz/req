Feature:  API Tests


  Scenario: GET request to /users
    Given existing Server application "https://reqres.in/api"
    Then on GET request to "/users" it returns expected users list

  Scenario: GET request to single user
    Given existing Server application "https://reqres.in/api"
    Then on GET request to "/users/2" it returns expected welcome message

  Scenario: GET request to nonexisting user
    Given existing Server application "https://reqres.in/api"
    Then on GET request to "/users/23" it returns 404 status code

  Scenario Outline: POST request adds new user to users list
    Given existing Server application "https://reqres.in/api"
    Then POST new registration <email> and <password> to register endpoint returns expected <status> and <id> and <token>

    Examples:
      | email                        | password      | status   | id   | token                |
      | "michael.lawson@reqres.in"   | "password123" | "200"    | "7"  | "QpwL5tke4Pnpja7X7"  |
      | "lindsay.ferguson@reqres.in" | "password123" | "200"    | "8"  | "QpwL5tke4Pnpja7X8"  |







#  Scenario Outline: POST request adds new user to users list
#    Given existing Server application "https://reqres.in/api"
#    Then POST new registration "<email>" and "<password>" to register endpoint returns expected <status> and "<response>"
#    Then POST new registration "michael.lawson@reqres.in" and "password123" to register endpoint returns expected 200 and "hello"
#    Then POST new registration email "<email>" and password "<password>" to /register endpoint returns expected status <status> and response "<response>"
#
#    Examples:
#      | email                       | password      | status  | response                                                     |
#      | michael.lawson@reqres.in    | password123   | 200     | { "id": 7, "token": "QpwL5tke4Pnpja7X7" }                    |
#      | lindsay.ferguson@reqres.in  | password123   | 200     | { "id": 8, "token": "QpwL5tke4Pnpja7X8" }                    |
#      | dan.clark@somewhere.com     | password123   | 400     | { "error": "Note: Only defined users succeed registration" } |
#      | sydney@fife                 |               | 400     | { "error": "Missing password" }                              |


#  Scenario Outline: POST request adds new user to users list updated
#    Given existing Server application "https://reqres.in/api"
#    Then POST new registration "<email>" and "<password>" to register endpoint expected <status> and "<response>" updated
#
#    Examples:
#      | email                       | password      | status  | response                                                     |
#      | michael.lawson@reqres.in    | password123   | 200     | test                    |
#      | michael.lawson@reqres.in    | password123   | 200     | { "id": 7, "token": "QpwL5tke4Pnpja7X7" }                    |
#      | lindsay.ferguson@reqres.in  | password123   | 200     | { "id": 8, "token": "QpwL5tke4Pnpja7X8" }                    |
#      | dan.clark@somewhere.com     | password123   | 400     | { "error": "Note: Only defined users succeed registration" } |
#      | sydney@fife                 |               | 400     | { "error": "Missing password" }                              |


