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
  | (== 0) `all` sides = Illegal
  | a + b < c || b + c < a || a + c < b = Illegal
  | length unique == 1 = Equilateral
  | length unique == 2 = Isosceles
  | length unique == 3 = Scalene
  where
    unique = (Set.toList . Set.fromList) sides
    sides = [a, b, c]
