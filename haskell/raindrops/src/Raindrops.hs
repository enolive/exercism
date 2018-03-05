module Raindrops (convert) where

convert :: Int -> String
convert n
  | null resultList = show n
  | otherwise = resultList
  where
    resultList = concatMap snd $ filter (\ (d, _) -> divisibleBy n d) rules

rules :: [(Int, String)]
rules = [
  (3, "Pling"),
  (5, "Plang"),
  (7, "Plong")
  ]

divisibleBy :: Int -> Int -> Bool
divisibleBy n d = n `mod` d == 0
