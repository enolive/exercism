module Acronym
  ( abbreviate
  ) where

abbreviate :: String -> String
abbreviate xs = map getLetter $ filter startsWord indexed
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