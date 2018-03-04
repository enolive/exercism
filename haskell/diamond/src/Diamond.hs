module Diamond
  ( diamond
  ) where

import Data.Char (ord)

diamond :: Char -> Maybe [String]
diamond c = (mirror . makeUpperHalf) <$> Just c

makeUpperHalf :: Char -> [String]
makeUpperHalf endChar = zipWith (makeLine distanceFromA) [0 ..] ['A' .. endChar]
  where
    distanceFromA = ord endChar - ord 'A'

makeLine :: Int -> Int -> Char -> String
makeLine length index character =
  mirror $ spaces (length - index) ++ [character] ++ spaces index

spaces :: Int -> String
spaces = flip replicate ' '

mirror :: [a] -> [a]
mirror = (reverse . init) >>= flip (++)