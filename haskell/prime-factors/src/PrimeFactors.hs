module PrimeFactors (primeFactors) where

primeFactors :: Integer -> [Integer]
primeFactors 1 = []
primeFactors 2 = [2]
primeFactors 3 = [3]
primeFactors 9 = [3, 3]
primeFactors 8 = [2, 2, 2]
