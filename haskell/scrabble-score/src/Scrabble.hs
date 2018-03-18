module Scrabble
  ( scoreLetter
  , scoreWord
  ) where

import Data.Char (toLower)

scoreLetter :: Char -> Integer
scoreLetter l =
  case toLower l of
    'a' -> 1
    'z' -> 10
    _ -> 0

scoreWord :: String -> Integer
scoreWord = sum . map scoreLetter