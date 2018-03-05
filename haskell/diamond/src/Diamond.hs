module Diamond
  ( diamond
  ) where

import Data.Char (ord, chr)

diamond :: Char -> Maybe [String]
diamond c = (mirror . makeUpperHalf) <$> Just c

makeUpperHalf :: Char -> [String]
makeUpperHalf endChar = map (makeLine size) [0..size]
  where
    size = ord endChar - ord 'A'

makeLine :: Int -> Int -> String
makeLine size index = mirror $ spaces (size - index) ++ [character] ++ spaces index
  where
    character = chr $ ord 'A' + index

spaces :: Int -> String
spaces = flip replicate ' '

mirror :: [a] -> [a]
mirror = (reverse . init) >>= flip (++)