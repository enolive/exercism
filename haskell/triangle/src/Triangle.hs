module Triangle (TriangleType(..), triangleType) where

import Data.Set ()
import qualified Data.Set as Set

data TriangleType = Equilateral
                  | Isosceles
                  | Scalene
                  | Illegal
                  deriving (Eq, Show)

triangleType :: (Num a, Ord a) => a -> a -> a -> TriangleType
triangleType a b c
  | not greaterThanZero || not hasTriangleInequality = Illegal
  | length unique == 1 = Equilateral
  | length unique == 2 = Isosceles
  | length unique == 3 = Scalene
  where
    hasTriangleInequality = a + b > c && b + c > a && a + c > b
    greaterThanZero = all (> 0) sides
    unique = (Set.toList . Set.fromList) sides
    sides = [a, b, c]
