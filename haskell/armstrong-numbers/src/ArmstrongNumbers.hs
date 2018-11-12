module ArmstrongNumbers (armstrong) where

import Data.List (unfoldr)
import Data.Tuple (swap)

armstrong :: Integral a => a -> Bool
armstrong num = (sum . map (^ exponent)) digits' == num
  where
    digits' = digits num
    exponent = length digits'

digits :: Integral a => a -> [a]
digits = unfoldr tryExtractDigit
  where
    tryExtractDigit 0 = Nothing
    tryExtractDigit n = (Just . swap . (`divMod` 10)) n