module Phone (number) where

import Data.Char (isDigit)

number :: String -> Maybe String
number xs = stripPunctuation xs >>= stripCountryCode >>= validateArea >>= validateExchange

stripPunctuation :: String -> Maybe String
stripPunctuation xs
  | length cleaned < 10 || length cleaned > 11 = Nothing
  | any (not . isDigit) cleaned = Nothing
  | otherwise = Just cleaned
  where
    cleaned = filter (`notElem` "+() -.") xs

stripCountryCode :: String -> Maybe String
stripCountryCode xs
  | length xs < 11 = Just xs
  | head xs == '1' = Just $ tail xs
  | otherwise = Nothing

validateArea :: String -> Maybe String
validateArea xs
  | isValidSubCode $ head xs = Just xs
  | otherwise = Nothing

validateExchange :: String -> Maybe String
validateExchange xs
  | isValidSubCode $ xs !! 3 = Just xs
  | otherwise = Nothing

isValidSubCode :: Char -> Bool
isValidSubCode c = c `elem` ['2'..'9']