module ArmstrongNumbers (armstrong) where

armstrong :: Integral a => a -> Bool
armstrong num = sum expDigits == num
  where
    expDigits = map (^ exponent) digits'
    digits' = digits num
    exponent = length digits'

digits :: Integral a => a -> [a]
digits 0 = []
digits n = current : digits next
  where
    (next, current) = n `divMod` 10
