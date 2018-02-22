module Grains (square, total) where

square :: Integer -> Maybe Integer
square n = Just $ 2 ^ (n - 1)

total :: Integer
total = error "You need to implement this function."
