module Squares
  ( difference
  , squareOfSums
  , sumOfSquares
  ) where

difference :: Integral a => a -> a
difference n = error "You need to implement this function."

squareOfSums :: Integral a => a -> a
squareOfSums n = squared $ sumUpTo n
  where squared = flip (^) 2
        sumUpTo n = n * (n + 1) `div` 2

sumOfSquares :: Integral a => a -> a
sumOfSquares = squarePyramidalNumber
  where squarePyramidalNumber n = n * (n + 1) * (2 * n + 1) `div` 6