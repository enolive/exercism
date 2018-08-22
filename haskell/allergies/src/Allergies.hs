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
allergenScores = zip bits allAllergens
  where
    allAllergens = [(minBound :: Allergen) ..]
    bits = map (2^) [0..]

isAllergicTo :: Allergen -> Int -> Bool
isAllergicTo allergen score = allergen `elem` allergies score
