module Anagram
  ( anagramsFor
  ) where

import Control.Monad (ap)
import Data.Char (toLower)
import Data.Function (on)
import Data.List (sort)

anagramsFor :: String -> [String] -> [String]
anagramsFor word = filter (isAnagramOf word)

isAnagramOf :: String -> String -> Bool
isAnagramOf word = return (&&) `ap` (not . equalIgnoringCase word) `ap` (sameLettersAs word)
  where
    equalIgnoringCase = (==) `on` lower
    sameLettersAs = (==) `on` sort . lower
    lower = map toLower