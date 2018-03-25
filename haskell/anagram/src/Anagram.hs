module Anagram (anagramsFor) where

import Data.List (sort)
import Data.Char (toLower)

anagramsFor :: String -> [String] -> [String]
anagramsFor word = filter (isAnagramOf word)

isAnagramOf :: String -> String -> Bool
isAnagramOf word candidate = lowerWord /= lowerCandidate && sort lowerWord == sort lowerCandidate
  where
    lowerWord = map toLower word
    lowerCandidate = map toLower candidate