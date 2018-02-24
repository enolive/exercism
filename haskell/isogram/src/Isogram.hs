module Isogram
  ( isIsogram
  ) where

import Data.Char (isLetter, toLower)
import Data.List (nub)

isIsogram :: String -> Bool
isIsogram = areAllUnique . letters

areAllUnique :: String -> Bool
areAllUnique = nub >>= (==)

letters :: String -> String
letters = map toLower . filter isLetter