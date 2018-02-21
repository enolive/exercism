module Squares
  ( difference
  , squareOfSums
  , sumOfSquares
  ) where

import Control.Monad (liftM2)

difference :: Integral a => a -> a
difference = liftM2 (-) squareOfSums sumOfSquares

squareOfSums :: Integral a => a -> a
squareOfSums = squared . sumUpTo
  where
    squared = flip (^) 2
    sumUpTo n = n * (n + 1) `div` 2

sumOfSquares :: Integral a => a -> a
sumOfSquares = squarePyramidalNumber
  where
    squarePyramidalNumber n = n * (n + 1) * (2 * n + 1) `div` 6