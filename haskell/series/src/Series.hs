module Series (slices) where

import Data.Char (digitToInt)

slices :: Int -> String -> [[Int]]
slices n = map strToInt . slidingWindow n

strToInt :: String -> [Int]
strToInt = map digitToInt

slidingWindow :: Int -> [a] -> [[a]]
slidingWindow 0 [] = [[]]
slidingWindow n xs
  | null xs = []
  | length xs < n = []
  | otherwise = take n xs : (slidingWindow n . drop 1) xs