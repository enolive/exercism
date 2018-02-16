module Pangram
  ( isPangram
  ) where

import Data.Char (toLower)
import Data.HashSet (fromList)

isPangram :: String -> Bool
isPangram text
  | null characters = False
  | length characters == length alphabet = True
  | otherwise = True
  where
    characters = fromList (map toLower text)
    alphabet = ['a' .. 'z']