module Raindrops (convert) where

convert :: Int -> String
convert n
 | n `mod` 3 == 0 = "Pling"
 | n == 5 = "Plang"
 | n == 7 = "Plong"
 | otherwise = "1"
