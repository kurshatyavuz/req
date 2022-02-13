Feature:  API Tests 2


  Scenario Outline: POST request adds new user to users list using request body in String
    Given existing server application is "https://reqres.in/api"
    Then POST new registration <email> and <password> to register endpoint returns expected <status> and <id> and <token> using request body in String

    Examples:
      | email                        | password      | status   | id   | token                |
      | "michael.lawson@reqres.in"   | "password123" | "200"    | "7"  | "QpwL5tke4Pnpja7X7"  |
      | "lindsay.ferguson@reqres.in" | "password123" | "200"    | "8"  | "QpwL5tke4Pnpja7X8"  |



  Scenario Outline: POST request adds new user to users list using request body in POJO
    Given existing server application is "https://reqres.in/api"
    Then POST new registration <email> and <password> to register endpoint returns expected <status> and <id> and <token> using request body in POJO

    Examples:
      | email                        | password      | status   | id   | token                |
      | "michael.lawson@reqres.in"   | "password123" | "200"    | "7"  | "QpwL5tke4Pnpja7X7"  |



  Scenario Outline: POST request adds new user to users list using request body in Map
    Given existing server application is "https://reqres.in/api"
    Then POST new registration <email> and <password> to register endpoint returns expected <status> and <id> and <token> using request body in Map

    Examples:
      | email                        | password      | status   | id   | token                |
      | "michael.lawson@reqres.in"   | "password123" | "200"    | "7"  | "QpwL5tke4Pnpja7X7"  |



  Scenario Outline: POST request adds new user to users list using request body in Json String
    Given existing server application is "https://reqres.in/api"
    Then POST new registration <email> and <password> to register endpoint returns expected <status> and <id> and <token> using request body in Json String

    Examples:
      | email                        | password      | status   | id   | token                |
      | "michael.lawson@reqres.in"   | "password123" | "200"    | "7"  | "QpwL5tke4Pnpja7X7"  |
#      | "lindsay.ferguson@reqres.in" | "password123" | "200"    | "8"  | "QpwL5tke4Pnpja7X8"  |