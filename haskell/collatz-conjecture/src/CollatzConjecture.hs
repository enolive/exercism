module CollatzConjecture
  ( collatz
  ) where

collatzRec :: Integer -> Integer -> Integer
collatzRec n steps
  | n == 1 = steps
  | even n = continueWith $ n `div` 2
  | odd n = continueWith $ n * 3 + 1
  where
    continueWith n = collatzRec n $ steps + 1

collatz :: Integer -> Maybe Integer
collatz n
  | n <= 0 = Nothing
  | otherwise = Just $ collatzRec n 0