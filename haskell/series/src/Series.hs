module Series
  ( slices
  ) where

import           Data.Char (digitToInt)

slices :: Int -> String -> [[Int]]
slices n = map (map digitToInt) . slidingWindow n

slidingWindow :: Int -> [a] -> [[a]]
slidingWindow 0 [] = [[]]
slidingWindow n xs
  | null xs = []
  | length current < n = []
  | otherwise = current : slidingWindow n rest
  where
    current = take n xs
    rest = drop 1 xs
