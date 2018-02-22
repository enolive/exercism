module Acronym
  ( abbreviate
  ) where

import Data.Char (toUpper, isLower, isUpper)

abbreviate :: String -> String
abbreviate xs = map (toUpper . getLetter) $ filter startsWord indexed
  where
    indexed = zip xs [0 ..]
    startsWord (current, index)
      | index == 0 = True
      | previous index `elem` [' ', '-'] = True
      | isUpper current && isLower(previous index) = True
      | otherwise = False
    previous index = letterAt $ index - 1
    letterAt index
      | index >= length xs = '\NUL'
      | otherwise = xs!!index
    getLetter (letter, index) = letter