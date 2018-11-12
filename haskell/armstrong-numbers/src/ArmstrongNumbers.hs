module ArmstrongNumbers (armstrong) where

armstrong :: Integral a => a -> Bool
armstrong num = (sum . map (^ exponent)) digits' == num
  where
    digits' = digits num
    exponent = length digits'

digits :: Integral a => a -> [a]
digits 0 = []
digits n = current : digits remaining
  where
    (remaining, current) = n `divMod` 10
