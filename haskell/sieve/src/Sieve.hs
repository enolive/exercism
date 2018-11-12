module Sieve
  ( primesUpTo
  ) where

-- You should not use any of the division operations when implementing
-- the sieve of Eratosthenes.
import           Prelude  hiding (div, divMod, mod, quot, quotRem, rem, (/))

import           Data.Set (Set)
import qualified Data.Set as Set

primesUpTo :: Integer -> [Integer]
primesUpTo n = filter (not . (`Set.member` sieve')) [2 .. n]
  where
    sieve' = sieve 2 n Set.empty

sieve :: Integer -> Integer -> Set Integer -> Set Integer
sieve current limit set
  | current > limit = set
  | current `Set.member` set = sieve (current + 1) limit set
  | otherwise = sieve (current + 1) limit set'
  where
    set' = Set.union set . Set.fromList . takeWhile (<= limit) $ [x * current | x <- [2 ..]]
