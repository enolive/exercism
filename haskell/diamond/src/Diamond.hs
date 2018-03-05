module Diamond
  ( diamond
  ) where

import Data.Char (ord, chr)

diamond :: Char -> Maybe [String]
diamond c = (mirror . top) <$> Just c

top :: Char -> [String]
top endChar = map (row size) [0..size]
  where
    size = ord endChar - ord 'A'

row :: Int -> Int -> String
row size index = mirror $ spaces (size - index) ++ [character] ++ spaces index
  where
    character = chr $ ord 'A' + index

spaces :: Int -> String
spaces = flip replicate ' '

mirror :: [a] -> [a]
mirror = (reverse . init) >>= flip (++)