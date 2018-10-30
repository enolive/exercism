module Matrix
  ( saddlePoints
  ) where

import           Data.Array (Array, bounds, indices, range, (!))

type Index = (Int, Int)

saddlePoints :: Ord e => Array Index e -> [Index]
saddlePoints matrix = [index
  | index@(a, b) <- indices matrix
  , matrix ! index == maxRow a
  , matrix ! index == minCol b]
  where
    ((minX, minY), (maxX, maxY)) = bounds matrix
    maxRow a = maximum [matrix ! (a, y) | y <- [minY .. maxY]]
    minCol b = minimum [matrix ! (x, b) | x <- [minX .. maxX]]
