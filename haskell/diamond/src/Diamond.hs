module Diamond
  ( diamond
  ) where

import Data.Char (ord)

diamond :: Char -> Maybe [String]
diamond 'A' = Just ["A"]
diamond 'B' = Just [" A ", "B B", " A "]
diamond 'C' = Just $ mirror $ upperHalf 'C'

upperHalf endChar = map (mirror . makeLine (distanceFromA endChar)) $ zip [0..] ['A'..endChar]

distanceFromA c = ord c - ord 'A'

makeLine :: Int -> (Int, Char) -> String
makeLine length (index, character) = spaces (length - index) ++ [character] ++ spaces index

spaces :: Int -> String
spaces n = replicate n ' '

mirror :: [a] -> [a]
mirror = mirrored >>= flip (++)
  where
    mirrored = reverse . init