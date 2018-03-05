module Raindrops (convert) where

convert :: Int -> String
convert n
 | n `divisibleBy` 3 = "Pling"
 | n `divisibleBy` 5 = "Plang"
 | n `divisibleBy` 7 = "Plong"
 | otherwise = show n

rules :: [(Int, String)]
rules = [
  (3, "Pling"),
  (5, "Plang"),
  (7, "Plong")
  ]

divisibleBy :: Int -> Int -> Bool
divisibleBy n d = n `mod` d == 0
