module Pangram
  ( isPangram
  ) where

import Data.Char (toLower, isLetter)
import Data.HashSet (fromList, isSubsetOf)

isPangram :: String -> Bool
isPangram text = alphabet `isSubsetOf` letters
  where
    letters = fromList [toLower c | c <- text, isLetter c]
    alphabet = fromList ['a' .. 'z']