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
classify n =
  case compare sumAliquot n of
    EQ -> Just Perfect
    GT -> Just Abundant
    LT -> Just Deficient
  where
    sumAliquot = sum $ filter dividesInput $ takeWhile (< n) [1 ..]
    dividesInput quot = n `rem` quot == 0