module Scrabble
  ( scoreLetter
  , scoreWord
  ) where

import Data.Char (toLower)

scoreLetter :: Char -> Integer
scoreLetter l
  | lower `elem` "at" = 1
  | lower `elem` "f" = 4
  | lower `elem` "z" = 10
  | otherwise = 0
  where
    lower = toLower l

scoreWord :: String -> Integer
scoreWord = sum . map scoreLetter