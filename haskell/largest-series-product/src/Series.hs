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
largestProduct size digits = toInteger . product . toDigits <$> Right digits
  where
    toDigits = map digitToInt
