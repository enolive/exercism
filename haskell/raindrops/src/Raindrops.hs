module Raindrops (convert) where

convert :: Int -> String
convert n
 | n `divisibleBy` 3 = "Pling"
 | n `divisibleBy` 5 = "Plang"
 | n `divisibleBy` 7 = "Plong"
 | otherwise = show n

divisibleBy :: Int -> Int -> Bool
divisibleBy n d = n `mod` d == 0
