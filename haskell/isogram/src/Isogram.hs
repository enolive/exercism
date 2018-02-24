module Isogram
  ( isIsogram
  ) where

import           Data.Char (isLetter, toLower)
import           Data.Map  (Map)
import qualified Data.Map  as Map

isIsogram :: String -> Bool
isIsogram xs = all (== 1) $ (Map.elems . letterCount) xs

letterCount :: String -> Map Char Int
letterCount xs = Map.fromListWith (+) [(toLower letter, 1) | letter <- xs, isLetter letter]
