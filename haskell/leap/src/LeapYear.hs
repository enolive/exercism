module LeapYear
  ( isLeapYear
  ) where

isDivisibleBy :: Integer -> Integer -> Bool
isDivisibleBy number divisor = number `mod` divisor == 0

isNotDivisibleBy :: Integer -> Integer -> Bool
isNotDivisibleBy number divisor = not $ isDivisibleBy number divisor

isLeapYear :: Integer -> Bool
isLeapYear year
  | year `isDivisibleBy` 400 = True
  | otherwise = year `isDivisibleBy` 4 && year `isNotDivisibleBy` 100
