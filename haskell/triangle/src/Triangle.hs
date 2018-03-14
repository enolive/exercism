module Triangle
  ( TriangleType(..)
  , triangleType
  ) where

import Control.Monad (ap)
import Data.List (sort)
import Data.Set ()
import qualified Data.Set as Set

data TriangleType
  = Equilateral
  | Isosceles
  | Scalene
  | Illegal
  deriving (Eq, Show)

triangleType :: (Num a, Ord a) => a -> a -> a -> TriangleType
triangleType a b c = triangleType' [a, b, c]

triangleType' :: (Num a, Ord a) => [a] -> TriangleType
triangleType' sides
  | (not . valid) sides = Illegal
  | otherwise =
    case numberOfUnique sides of
      1 -> Equilateral
      2 -> Isosceles
      3 -> Scalene
  where
    valid = return (&&) `ap` greaterThanZero `ap` (applyToTriangleInequality . sort)
    greaterThanZero = all (> 0)
    applyToTriangleInequality [a, b, c] = a + b > c
    numberOfUnique = Set.size . Set.fromList