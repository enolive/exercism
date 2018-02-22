module Acronym
  ( abbreviate
  ) where

import Control.Applicative
import Data.Char (isLower, isUpper, toUpper)

abbreviate :: String -> String
abbreviate sentence = (toUpper . getLetter) <$> filter startsWord indexedSentence
  where
    indexedSentence = zip sentence [0 ..]
    startsWord = startsWordIn sentence

getLetter :: (Char, Int) -> Char
getLetter (letter, index) = letter

startsWordIn :: String -> (Char, Int) -> Bool
startsWordIn xs (current, index)
  | index == 0 = True
  | previous `elem` [' ', '-'] = True
  | isUpper current && isLower previous = True
  | otherwise = False
  where
    previous = letterAt $ index - 1
    letterAt index
      | index >= length xs = '\NUL'
      | otherwise = xs !! index