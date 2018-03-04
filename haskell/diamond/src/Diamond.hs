module Diamond
  ( diamond
  ) where

import Data.Char (ord)

diamond :: Char -> Maybe [String]
diamond c = (mirror . upperHalf) <$> Just c

upperHalf endChar = zipWith (curry line) [0 ..] ['A' .. endChar]
  where
    line = mirror . makeLine (distanceFromA endChar)

distanceFromA c = ord c - ord 'A'

makeLine :: Int -> (Int, Char) -> String
makeLine length (index, character) = spaces (length - index) ++ [character] ++ spaces index

spaces :: Int -> String
spaces n = replicate n ' '

mirror :: [a] -> [a]
mirror = mirrored >>= flip (++)
  where
    mirrored = reverse . init