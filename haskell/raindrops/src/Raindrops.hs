module Raindrops (convert) where

convert :: Int -> String
convert n
  | null resultList = show n
  | otherwise = resultList
  where
    resultList = concatMap snd $ filter (`fst` n) rules

rules :: [(Int -> Bool, String)]
rules = [
  (divisibleBy 3, "Pling"),
  (divisibleBy 5, "Plang"),
  (divisibleBy 7, "Plong")
  ]

divisibleBy :: Int -> Int -> Bool
divisibleBy d n = n `mod` d == 0
