module PerfectNumbers
  ( classify
  , Classification(..)
  ) where

data Classification
  = Deficient
  | Perfect
  | Abundant
  deriving (Eq, Show)

classify :: Int -> Maybe Classification
classify n
  | n <= 0 = Nothing
  | sumAliquot == n = Just Perfect
  | sumAliquot < n = Just Deficient
  | sumAliquot > n = Just Abundant
  where
    sumAliquot = sum factors
    factors = [x| x <- [1 .. n `div` 2], n `rem` x == 0]
