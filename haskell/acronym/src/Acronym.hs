module Acronym
  ( abbreviate
  ) where

import Data.Char (isLower, isUpper, toUpper)

abbreviate :: String -> String
abbreviate xs = concatMap tryMakeAbbr pairPreviousWithCurrent
  where
    pairPreviousWithCurrent = zip (' ' : xs) xs
    tryMakeAbbr (previous, current)
      | isSpaceOrHyphen previous = [toUpper current]
      | isLower previous && isUpper current = [current]
      | otherwise = []
    isSpaceOrHyphen c = c `elem` [' ', '-']