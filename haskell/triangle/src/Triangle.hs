module Triangle
  ( TriangleType(..)
  , triangleType
  ) where

import Data.Set ()
import qualified Data.Set as Set

data TriangleType
  = Equilateral
  | Isosceles
  | Scalene
  | Illegal
  deriving (Eq, Show)

triangleType :: (Num a, Ord a) => a -> a -> a -> TriangleType
triangleType a b c
  | not isValid = Illegal
  | otherwise =
    case numberOfUniqueSides of
      1 -> Equilateral
      2 -> Isosceles
      3 -> Scalene
  where
    isValid = greaterThanZero && hasTriangleInequality
    greaterThanZero = all (> 0) [a, b, c]
    hasTriangleInequality = a + b > c && b + c > a && a + c > b
    numberOfUniqueSides = (Set.size . Set.fromList) [a, b, c]