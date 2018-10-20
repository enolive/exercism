module Series
  ( Error(..)
  , largestProduct
  ) where

import           Data.Bifunctor (first)
import           Data.Char      (digitToInt, isDigit)

data Error
  = InvalidSpan
  | InvalidDigit Char
  deriving (Show, Eq)

largestProduct :: Int -> String -> Either Error Integer
largestProduct size digits = largestProduct' <$> validateSize size digits <*> validateDigits digits

validateSize :: Int -> String -> Either Error Int
validateSize size digits
  | size `notElem` [0 .. length digits] = Left InvalidSpan
  | otherwise = Right size

validateDigits :: String -> Either Error [Int]
validateDigits xs
  | (not . null) invalidDigits = (InvalidDigit . head) `first` Left invalidDigits
  | otherwise = map digitToInt <$> Right xs
  where
    invalidDigits = filter (not . isDigit) xs

largestProduct' :: Int -> [Int] -> Integer
largestProduct' size = toInteger . getLargest . createProducts . window size
  where
    getLargest []      = 1
    getLargest numbers = maximum numbers
    createProducts = map product

window :: Int -> [a] -> [[a]]
window _ [] = []
window size all@(x:xs)
  | length part < size = []
  | otherwise = part : window size xs
  where
    part = take size all
