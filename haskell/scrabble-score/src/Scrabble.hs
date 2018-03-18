module Scrabble
  ( scoreLetter
  , scoreWord
  ) where

import Data.Char (toLower)

scoreLetter :: Char -> Integer
scoreLetter l
  | lower `elem` "aeioulnrst" = 1
  | lower `elem` "dg" = 2
  | lower `elem` "bcmp" = 3
  | lower `elem` "fhvwy" = 4
  | lower `elem` "k" = 5
  | lower `elem` "jx" = 8
  | lower `elem` "qz" = 10
  | otherwise = 0
  where
    lower = toLower l

scoreWord :: String -> Integer
scoreWord = sum . map scoreLetter