module Phone (number) where

import Data.Char (isDigit)

number :: String -> Maybe String
number xs
  | inValid cleaned = Nothing
  | hasCountryCode cleaned = Just $ tail cleaned
  | otherwise = Just cleaned
  where
    cleaned = clean xs

inValid cleaned
  | length cleaned `notElem` [10, 11] = True
  | any (not . isDigit) cleaned = True
  | countryCode cleaned /= '1' = True
  | areaCode cleaned `elem` "01" = True
  | exchangeCode cleaned `elem` "01" = True
  | otherwise = False

countryCode :: String -> Char
countryCode cleaned
  | hasCountryCode cleaned = head cleaned
  | otherwise = '1'

areaCode :: String -> Char
areaCode cleaned
  | hasCountryCode cleaned = (!! 1) cleaned
  | otherwise = head cleaned

exchangeCode :: String -> Char
exchangeCode cleaned
  | hasCountryCode cleaned = (!! 4) cleaned
  | otherwise = (!! 3) cleaned

hasCountryCode cleaned = length cleaned == 11

clean :: String -> String
clean = filter (not . isPunctuation)

isPunctuation :: Char -> Bool
isPunctuation c = c `elem` "+() -."
