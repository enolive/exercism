module PrimeFactors (primeFactors) where

primeFactors :: Integer -> [Integer]
primeFactors n = [x | x <- [2..n], isPrime x && n `mod` x == 0]

isPrime :: Integer -> Bool
isPrime x = all (not . divides x) [2..x-1]
  where
    divides x n = x `mod` n == 0