module SumOfMultiples (sumOfMultiples) where
import Data.List (nub)

sumOfMultiples :: [Integer] -> Integer -> Integer
sumOfMultiples factors limit = sum $ nub $ factors >>= multiplesOf
  where multiplesOf n = takeWhile (< limit) [n*x | x <- [1..]]
