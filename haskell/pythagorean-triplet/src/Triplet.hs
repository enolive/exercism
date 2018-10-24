module Triplet
  ( isPythagorean
  , mkTriplet
  , pythagoreanTriplets
  ) where

import           Data.List (sort)

type Triplet = (Int, Int, Int)

isPythagorean :: Triplet -> Bool
isPythagorean (a, b, c) = a ^ 2 + b ^ 2 == c ^ 2

mkTriplet :: Int -> Int -> Int -> Triplet
mkTriplet a b c = (a', b', c')
  where
    [a', b', c'] = sort [a, b, c]

pythagoreanTriplets :: Int -> Int -> [Triplet]
pythagoreanTriplets minFactor maxFactor =
  [(a, b, c) | a <- [minFactor .. maxFactor], b <- [a .. maxFactor], c <- [b .. maxFactor], isPythagorean (a, b, c)]
