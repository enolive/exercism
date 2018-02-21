module Squares
  ( difference
  , squareOfSums
  , sumOfSquares
  ) where

squared :: Integral a => a -> a
squared = flip (^) 2

difference :: Integral a => a -> a
difference n = error "You need to implement this function."

squareOfSums :: Integral a => a -> a
squareOfSums n = squared $ sumUpTo n
  where sumUpTo n = n * (n + 1) `div` 2

sumOfSquares :: Integral a => a -> a
sumOfSquares n = sum $ fmap squared [1..n]