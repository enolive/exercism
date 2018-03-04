module Diamond
  ( diamond
  ) where

import Data.Char (ord)

diamond :: Char -> Maybe [String]
diamond c = (mirror . makeUpperHalf) <$> Just c

makeUpperHalf :: Char -> [String]
makeUpperHalf endChar = zipWith (curry line) [0 ..] ['A' .. endChar]
  where
    line = mirror . makeLine distanceFromA
    distanceFromA = ord endChar - ord 'A'

makeLine :: Int -> (Int, Char) -> String
makeLine length (index, character) =
  spaces (length - index) ++ [character] ++ spaces index

spaces :: Int -> String
spaces n = replicate n ' '

mirror :: [a] -> [a]
mirror = (reverse . init) >>= flip (++)