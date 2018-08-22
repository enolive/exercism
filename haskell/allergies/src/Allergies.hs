module Allergies
  ( Allergen(..)
  , allergies
  , isAllergicTo
  ) where

import           Data.Bits

data Allergen
  = Eggs
  | Peanuts
  | Shellfish
  | Strawberries
  | Tomatoes
  | Chocolate
  | Pollen
  | Cats
  deriving (Eq, Show, Bounded, Enum)

allergies :: Int -> [Allergen]
allergies total = [allergen | (single, allergen) <- allergenScores, matchesScore total single]

matchesScore :: Int -> Int -> Bool
matchesScore total single = total .&. single /= 0

allergenScores :: [(Int, Allergen)]
allergenScores = zip bitScores allAllergens
  where
    bitScores = map (2^) [0..]
    allAllergens = [(minBound :: Allergen) ..]

isAllergicTo :: Allergen -> Int -> Bool
isAllergicTo allergen score = allergen `elem` allergies score
