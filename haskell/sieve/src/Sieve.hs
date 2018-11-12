module Sieve
  ( primesUpTo
  ) where

-- You should not use any of the division operations when implementing
-- the sieve of Eratosthenes.
import           Prelude  hiding (div, divMod, mod, quot, quotRem, rem, (/))

import           Data.Set (Set)
import qualified Data.Set as Set

primesUpTo :: Integer -> [Integer]
primesUpTo n = sieveUpTo [2 .. n] n

sieveUpTo [] _ = []
sieveUpTo (prime:xs) n = prime : sieveUpTo xs' n
  where
    xs' = xs `without` multiples
    multiples = Set.fromList . takeWhile (<= n) $ [x * prime | x <- [2 .. n]]
    xs `without` set = Set.toList . (Set.\\ set) . Set.fromList $ xs
