module CollatzConjecture
  ( collatz
  ) where

collatzRec :: Integer -> Integer -> Maybe Integer
collatzRec n steps
  | n <= 0 = Nothing
  | n == 1 = Just steps
  | even n = continueWith $ n `div` 2
  | odd n = continueWith $ n * 3 + 1
  where
    continueWith n = collatzRec n $ steps + 1

collatz :: Integer -> Maybe Integer
collatz n = collatzRec n 0