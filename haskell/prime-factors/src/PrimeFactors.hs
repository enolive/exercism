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
nextFactor Acc {..} = Just (next, Acc {current = next, limit = limit `div` next})
  where
    next = (head . filter (limit `isDivisibleBy`)) [current ..]

isDivisibleBy :: Integer -> Integer -> Bool
isDivisibleBy n d = n `mod` d == 0