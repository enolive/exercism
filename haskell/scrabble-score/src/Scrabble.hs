module Scrabble (scoreLetter, scoreWord) where

import Data.Char (toLower)

scoreLetter :: Char -> Integer
scoreLetter 'a' = 1
scoreLetter 'Z' = 10
scoreLetter _ = 0

scoreWord :: String -> Integer
scoreWord = sum . map (scoreLetter . toLower)
