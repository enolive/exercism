module Series (slices) where

import Data.Char (digitToInt)

slices :: Int -> String -> [[Int]]
slices n = map (map digitToInt) . slidingWindow n

slidingWindow :: Int -> [a] -> [[a]]
slidingWindow 0 [] = [[]]
slidingWindow n xs
  | null xs = []
  | length xs < n = []
  | otherwise = (take n) xs : (slidingWindow n . drop 1) xs