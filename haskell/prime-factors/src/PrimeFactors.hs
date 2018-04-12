module PrimeFactors (primeFactors) where

primeFactors :: Integer -> [Integer]
primeFactors = factorize []

factorize :: [Integer] -> Integer -> [Integer]
factorize found 1 = reverse found
factorize found n = factorize (next:found) (n `div` next)
  where
    next = head $ filter (n `isDivisibleBy`) [current..n]
    current = found `headOr` 2
    headOr [] value = value
    headOr (x:_) _ = x

isDivisibleBy :: Integer -> Integer -> Bool
isDivisibleBy n d = n `mod` d == 0