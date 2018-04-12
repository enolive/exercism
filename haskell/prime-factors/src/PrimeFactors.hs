{-# LANGUAGE RecordWildCards #-}

module PrimeFactors
  ( primeFactors
  ) where

import Data.List (unfoldr)

data Acc = Acc
  { current :: Integer
  , limit :: Integer
  }

primeFactors :: Integer -> [Integer]
primeFactors n = unfoldr nextFactor Acc {current = 2, limit = n}

nextFactor :: Acc -> Maybe (Integer, Acc)
nextFactor Acc {limit = 1} = Nothing
nextFactor acc@Acc {..}
  | modulo == 0 = Just (current, acc {limit = newLimit})
  | otherwise = nextFactor acc {current = current + 1}
  where
    (newLimit, modulo) = limit `divMod` current