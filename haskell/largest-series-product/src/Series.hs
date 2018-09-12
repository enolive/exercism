module Series
  ( Error(..)
  , largestProduct
  ) where

import           Data.Char (digitToInt, isDigit)

data Error
  = InvalidSpan
  | InvalidDigit Char
  deriving (Show, Eq)

largestProduct :: Int -> String -> Either Error Integer
largestProduct size digits = toInteger . largestProduct' size <$> validateInput
  where
    validateInput = validateSize size digits >>= validateDigits

validateSize :: Int -> String -> Either Error String
validateSize size digits
  | size `notElem` [0 .. length digits] = Left InvalidSpan
  | otherwise = Right digits

validateDigits :: String -> Either Error [Int]
validateDigits xs
  | invalidDigits /= [] = Left $ InvalidDigit $ head invalidDigits
  | otherwise = map digitToInt <$> Right xs
  where
    invalidDigits = filter (not . isDigit) xs

largestProduct' :: Int -> [Int] -> Int
largestProduct' size = getLargest . createProducts . window size
  where
    getLargest [] = 1
    getLargest numbers = foldl max 0 numbers
    createProducts = map product

window :: Int -> [a] -> [[a]]
window _ [] = []
window size all@(x:xs)
  | length part < size = []
  | otherwise = part : window size xs
  where
    part = take size all
