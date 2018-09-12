module Series
  ( Error(..)
  , largestProduct
  ) where

import           Data.Char (digitToInt)

data Error
  = InvalidSpan
  | InvalidDigit Char
  deriving (Show, Eq)

largestProduct :: Int -> String -> Either Error Integer
largestProduct size digits = toInteger . highest . products . slidingWindow . toDigits <$> Right digits
  where
    toDigits = map digitToInt
    products = map product
    highest = foldl max 0
    slidingWindow = window size

window :: Int -> [a] -> [[a]]
window size all@(x:xs)
  | length part < size = []
  | otherwise = part : window size xs
  where
    part = take size all
