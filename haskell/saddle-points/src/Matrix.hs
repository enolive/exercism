module Matrix
  ( saddlePoints
  ) where

import           Data.Array (Array, bounds, (!))

type Index = (Int, Int)

saddlePoints :: Ord e => Array Index e -> [Index]
saddlePoints matrix =
  [(a, b) | a <- [minX .. maxX], b <- [minY .. maxY], matrix ! (a, b) == maxRow a, matrix ! (a, b) == minCol b]
  where
    ((minX, minY), (maxX, maxY)) = bounds matrix
    maxRow a = maximum [matrix ! (a, y) | y <- [minY .. maxY]]
    minCol b = minimum [matrix ! (x, b) | x <- [minX .. maxX]]
