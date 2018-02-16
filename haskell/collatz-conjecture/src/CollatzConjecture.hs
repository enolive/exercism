module CollatzConjecture
  ( collatz
  ) where

inc :: Integer -> Integer
inc n = n + 1

collatzRec :: Integer -> Integer -> Maybe Integer
collatzRec n steps
  | n <= 0 = Nothing
  | n == 1 = Just steps
  | even n = collatzRec (n `div` 2) $ inc steps
  | odd n = collatzRec (n * 3 + 1) $ inc steps


collatz :: Integer -> Maybe Integer
collatz n = collatzRec n 0