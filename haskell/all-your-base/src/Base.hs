module Base
  ( Error(..)
  , rebase
  ) where

data Error a
  = InvalidInputBase
  | InvalidOutputBase
  | InvalidDigit a
  deriving (Show, Eq)

rebase :: Integral a => a -> a -> [a] -> Either (Error a) [a]
rebase inputBase outputBase inputDigits
  | invalidBase inputBase = Left InvalidInputBase
  | invalidBase outputBase = Left InvalidOutputBase
  | (not . null) invalidDigits = (Left . InvalidDigit . head) invalidDigits
  | otherwise = (Right . rebase' inputBase outputBase) inputDigits
  where
    invalidBase base = base < 2
    invalidDigits = filter (invalidDigit inputBase) inputDigits
    invalidDigit base digit = digit `notElem` [0 .. base - 1]

rebase' :: Integral a => a -> a -> [a] -> [a]
rebase' inputBase outputBase = fromBase10 outputBase . toBase10 inputBase

fromBase10 :: Integral a => a -> a -> [a]
fromBase10 outputBase 0 = []
fromBase10 outputBase number = fromBase10 outputBase remaining ++ [current]
  where
    (remaining, current) = number `divMod` outputBase

toBase10 :: Integral a => a -> [a] -> a
toBase10 inputBase inputDigits = sum $ zipWith (rebaseDigit inputBase) inputDigits exponents
  where
    maxExp = length inputDigits - 1
    exponents = [maxExp,maxExp - 1 ..]
    rebaseDigit inputBase digit exp = digit * inputBase ^ exp
