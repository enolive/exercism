module Diamond
  ( diamond
  ) where

import Data.Char (chr, ord)

diamond :: Char -> Maybe [String]
diamond c = (mirror . top) <$> charM
  where
    charM
      | c `elem` ['A' .. 'Z'] = Just c
      | otherwise = Nothing

top :: Char -> [String]
top endChar = map (mirror . half) [0 .. size]
  where
    half index = spaces (size - index) ++ [character index] ++ spaces index
    size = ord endChar - ord 'A'
    character index = chr $ ord 'A' + index

spaces :: Int -> String
spaces = flip replicate ' '

mirror :: [a] -> [a]
mirror = (reverse . init) >>= flip (++)