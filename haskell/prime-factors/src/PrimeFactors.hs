module PrimeFactors (primeFactors) where
import Data.List (unfoldr)

data CurrentAndLimit = CurrentAndLimit Integer Integer

primeFactors :: Integer -> [Integer]
primeFactors n = unfoldr getNextFactor $ CurrentAndLimit 2 n

getNextFactor :: CurrentAndLimit -> Maybe (Integer, CurrentAndLimit)
getNextFactor (CurrentAndLimit _ 1) = Nothing
getNextFactor (CurrentAndLimit current n) = Just (next, CurrentAndLimit next (n `div` next))
  where
    next = (head . filter (n `isDivisibleBy`)) [current..]

isDivisibleBy :: Integer -> Integer -> Bool
isDivisibleBy n d = n `mod` d == 0