# Password Validator API

## Description:
The purpose of this api is to be able to validate passwords using validators that are submitted by users.

## Objectives:
- We will try to implement hexagonal architecture
- TDD will be implemented

## Entities:
- Validator: it will be the validator that we receive from the users. Thanks to this we will know which parts we have to validate.
- ResultPasswordValidator: It will be the response that we will create from the service for the controller to send it to the users.