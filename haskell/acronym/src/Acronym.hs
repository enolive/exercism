module Acronym
  ( abbreviate
  ) where

import Data.Char (toUpper)

abbreviate :: String -> String
abbreviate xs = map (toUpper . getLetter) $ filter startsWord indexed
  where
    indexed = zip xs [0 ..]
    startsWord (letter, index)
      | index == 0 = True
      | letterAt(index - 1) == ' ' = True
      | otherwise = False
    letterAt index
      | index >= length xs = '\NUL'
      | otherwise = xs!!index
    getLetter (letter, index) = letter