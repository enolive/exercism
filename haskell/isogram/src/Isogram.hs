module Isogram
  ( isIsogram
  ) where

import Data.Char (isLetter, toLower)
import Data.List (nub)

isIsogram :: String -> Bool
isIsogram = (nub >>= (==)) . letters

letters :: String -> String
letters = map toLower . filter isLetter