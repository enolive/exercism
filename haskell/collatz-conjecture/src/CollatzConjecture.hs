module CollatzConjecture
  ( collatz
  ) where

collatzRec :: Integer -> Integer -> Maybe Integer
collatzRec 1 steps = Just steps
collatzRec n steps
  | n < 0 = Nothing
  | even n = collatzRec (n `div` 2) (steps + 1)
  | odd n = collatzRec (n * 3 + 1) (steps + 1)

collatz :: Integer -> Maybe Integer
collatz n = collatzRec n 0