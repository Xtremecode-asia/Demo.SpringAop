Feature: A service for digesting a plain string as a digested string

Narative:
In order to hash any important string data
As a User
I want to be able to hash a plain string using various hash algorithms

Scenario: 1. Hash a plain string using SHA-512 algorithm

Given a plain string: Despite all my rage i still just a rat in a cage
When the User hash the plain string using SHA-512 algorithm
Then the plain string should be digested

Scenario: 2. Try to hash a plain string using unknown algorithm

Given a plain string: Despite all my rage i still just a rat in a cage
When the User hash the plain string using fizzbuzz algorithm
Then the hash should return error


