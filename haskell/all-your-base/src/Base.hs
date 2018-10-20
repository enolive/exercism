module Base
  ( Error(..)
  , rebase
  ) where

data Error a
  = InvalidInputBase
  | InvalidOutputBase
  | InvalidDigit a
  deriving (Show, Eq)

validateInputBase :: Integral a => a -> Either (Error a) a
validateInputBase = validateBase InvalidInputBase

validateOutputBase :: Integral a => a -> Either (Error a) a
validateOutputBase = validateBase InvalidOutputBase

validateBase :: Integral a => Error a -> a -> Either (Error a) a
validateBase err base
  | base < 2 = Left err
  | otherwise = Right base

validateDigits :: Integral a => [a] -> a -> Either (Error a) [a]
validateDigits digits inputBase
  | (not . null) invalidDigits = (Left . InvalidDigit . head) invalidDigits
  | otherwise = Right digits
  where
    invalidDigits = filter (invalidDigit inputBase) digits
    invalidDigit base digit = digit `notElem` [0 .. base - 1]

rebase :: Integral a => a -> a -> [a] -> Either (Error a) [a]
rebase inputBase outputBase inputDigits =
  rebase' <$> validateInputBase inputBase <*> validateOutputBase outputBase <*> validateDigits inputDigits inputBase

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
