module Series
  ( slices
  ) where

import           Data.Char (digitToInt)

slices :: Int -> String -> [[Int]]
slices n = map digits . slidingWindow n

digits :: String -> [Int]
digits = map digitToInt

slidingWindow :: Int -> [a] -> [[a]]
slidingWindow 0 [] = [[]]
slidingWindow n xs
  | null xs = []
  | length current < n = []
  | otherwise = current : slidingWindow n rest
  where
    current = take n xs
    rest = drop 1 xs
