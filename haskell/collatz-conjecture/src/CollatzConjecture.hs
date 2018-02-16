module CollatzConjecture (collatz) where

collatzRec :: Integer -> Integer -> Maybe Integer
collatzRec 1 result = Just result
collatzRec n result
  | even n = collatzRec (n `div` 2) (result + 1)

collatz :: Integer -> Maybe Integer
collatz n = collatzRec n 0

