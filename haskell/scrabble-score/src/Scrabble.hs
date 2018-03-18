module Scrabble
  ( scoreLetter
  , scoreWord
  ) where

import Data.Char (toLower)

scoreLetter :: Char -> Integer
scoreLetter l
  | lower `elem` "aeiorstu" = 1
  | lower `elem` "fy" = 4
  | lower `elem` "k" = 5
  | lower `elem` "qz" = 10
  | otherwise = 0
  where
    lower = toLower l

scoreWord :: String -> Integer
scoreWord = sum . map scoreLetter