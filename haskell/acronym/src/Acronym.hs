module Acronym
  ( abbreviate
  ) where

import Data.Char

abbreviate :: String -> String
abbreviate xs = abbreviate' clearSentence []
  where
    clearSentence = replaceHyphenBySpace <$> ' ' : xs
    replaceHyphenBySpace '-' = ' '
    replaceHyphenBySpace c = c

abbreviate' :: String -> String -> String
abbreviate' [current] acc = acc
abbreviate' (previous:current:xs) acc
  | isLower previous && isUpper current = abbreviateNext $ appendToAcc current
  | isSpace previous = abbreviateNext $ appendToAcc current
  | otherwise = abbreviateNext acc
  where
    abbreviateNext = abbreviate' (current : xs)
    appendToAcc c = acc ++ [toUpper c]