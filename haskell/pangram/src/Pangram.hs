module Pangram
  ( isPangram
  ) where

import Data.Char (toLower, isLetter)
import Data.HashSet (fromList)

isPangram :: String -> Bool
isPangram text
  | null characters = False
  | length characters == length alphabet = True
  | otherwise = False
  where
    characters = fromList [toLower c | c <- text, isLetter c]
    alphabet = ['a' .. 'z']