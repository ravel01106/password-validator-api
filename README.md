# Password Validator API

## Description:
The purpose of this api is to be able to validate passwords using validators that are submitted by users.

## Objectives:
- We will try to implement a hexagonal architecture
- Unitary and integration tests will be created.
- TDD will be applied
- Exception handling will be performed

## Entities:
- Validator: it will be the validator that we receive from the users. Thanks to this we will know which parts we have to validate.
- ResultPasswordValidator: It will be the response that we will create from the service for the controller to send it to the users.
- ErrorDTO: This object will be sent to the User to report any errors encountered. In this case, when the body is empty
or when a call is made to an erroneous route.