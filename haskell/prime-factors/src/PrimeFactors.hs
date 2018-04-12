module PrimeFactors (primeFactors) where
import Data.List (unfoldr)

type CurrentAndLimit = (Integer, Integer)

primeFactors :: Integer -> [Integer]
primeFactors n = unfoldr getNextFactor (2, n)

getNextFactor :: CurrentAndLimit -> Maybe (Integer, CurrentAndLimit)
getNextFactor (_, 1) = Nothing
getNextFactor (current, n) = Just (next, (next, n `div` next))
  where
    next = (head . filter (n `isDivisibleBy`)) [current..]

isDivisibleBy :: Integer -> Integer -> Bool
isDivisibleBy n d = n `mod` d == 0