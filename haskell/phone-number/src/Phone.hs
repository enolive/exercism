module Phone (number) where

import Data.Char (isDigit)

number :: String -> Maybe String
number xs
  | length cleaned < 10 = Nothing
  | length cleaned == 11 && head cleaned /= '1' = Nothing
  | length cleaned > 11 = Nothing
  | any (not . isDigit) cleaned = Nothing
  | head cleaned == '1' = Just $ tail cleaned
  | otherwise = Just cleaned
  where
    cleaned = clean xs

clean :: String -> String
clean = filter (not . isPunctuation)

isPunctuation :: Char -> Bool
isPunctuation c = c `elem` "+() -."
