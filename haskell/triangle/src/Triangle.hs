module Triangle
  ( TriangleType(..)
  , triangleType
  ) where

import Data.List (sort)
import Data.Set ()
import qualified Data.Set as Set
import Control.Monad (liftM2)

data TriangleType
  = Equilateral
  | Isosceles
  | Scalene
  | Illegal
  deriving (Eq, Show)

triangleType :: (Num a, Ord a) => a -> a -> a -> TriangleType
triangleType a b c = triangleType' [a, b, c]

triangleType' sides
  | (not . valid) sides = Illegal
  | otherwise =
    case numberOfUnique sides of
      1 -> Equilateral
      2 -> Isosceles
      3 -> Scalene
  where
    valid = liftM2 (&&) greaterThanZero (appliesToTriangleInequality . sort)
    greaterThanZero = all (> 0)
    appliesToTriangleInequality [a, b, c] = a + b > c
    numberOfUnique = Set.size . Set.fromList
