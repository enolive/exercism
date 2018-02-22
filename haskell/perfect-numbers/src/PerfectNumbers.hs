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
  case compare (sumAliquot n) n of
    EQ -> Just Perfect
    GT -> Just Abundant
    LT -> Just Deficient
  where
    sumAliquot n = sum $ filter (divides n) $ takeWhile (< n) [1 ..]
    divides n quot = n `rem` quot == 0