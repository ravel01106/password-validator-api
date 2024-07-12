# Password Validator API

## Endpoints:

- GET /passvalidator/:id -> (choice of the type of validation you want)
- POST /passvalidator/:id/validate -> (validation of the password written by the body)
    { password: "1234" }