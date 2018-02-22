module Grains (square, total) where

square :: Integer -> Maybe Integer
square n
  | n `notElem` [1 .. 64] = Nothing
  | otherwise = Just $ 2 ^ (n - 1)

total :: Integer
total = maybe 0 sum $ mapM square [1 .. 64]
