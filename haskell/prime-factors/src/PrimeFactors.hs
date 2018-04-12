module PrimeFactors (primeFactors) where

primeFactors :: Integer -> [Integer]
primeFactors n = primeFactors' n [2,3]

primeFactors' n [] = []
primeFactors' n (current:sieve)
  | n `mod` current == 0 = current : primeFactors' (n `div` current) (current:sieve)
  | otherwise = primeFactors' n sieve
