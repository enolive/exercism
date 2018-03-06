module Phone (number) where

import Data.Char (isDigit)

number :: String -> Maybe String
number xs
  | isValid cleanNumber = Just cleanNumber
  | otherwise = Nothing
  where
    cleanNumber = (stripCountryCode . filter isDigit) xs

stripCountryCode :: String -> String
stripCountryCode xs
  | length xs == 11 && head xs == '1' = tail xs
  | otherwise = xs

isValid :: String -> Bool
isValid phone = validLength && validArea && validExchange
  where
    validLength = length phone == 10
    validArea = validSubCode $ head phone
    validExchange = validSubCode $ phone !! 3
    validSubCode = (`elem` ['2'..'9'])