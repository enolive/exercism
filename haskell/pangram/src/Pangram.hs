module Pangram
  ( isPangram
  ) where

import Data.Char (toLower, isLetter)
import Data.HashSet (fromList)

isPangram :: String -> Bool
isPangram text
  | length letters == length alphabet = True
  | otherwise = False
  where
    letters = fromList [toLower c | c <- text, isLetter c]
    alphabet = ['a' .. 'z']