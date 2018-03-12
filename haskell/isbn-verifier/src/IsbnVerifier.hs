module IsbnVerifier (isbn) where
import Data.Char (isDigit, digitToInt)

isbn :: String -> Bool
isbn input = validLength && validCheckSum
  where
    validLength = length cleanInput == 10
    validCheckSum = sum digitValues `mod` 11 == 0
    digitValues = zipWith (*) allDigits [10,9..1]
    allDigits = numberDigits ++ [checkDigit]
    numberDigits = (map digitToInt . filter isDigit) $ init cleanInput
    checkDigit
      | isDigit lastDigit = digitToInt lastDigit
      | lastDigit == 'X' = 10
      | otherwise = 0
    lastDigit = last cleanInput
    cleanInput = filter (/= '-') input