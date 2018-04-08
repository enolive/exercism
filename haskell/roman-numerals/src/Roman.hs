module Roman (numerals) where

numerals :: Integer -> Maybe String
numerals n = (Just . snd . foldr translate (n, [])) translationMap

translate :: (Int, String) -> (Integer, String) -> (Integer, String)
translate (arabic, roman) (remaining, result) = (newRemaining, newResult)
  where
    newRemaining = remaining `mod` toInteger arabic
    newResult = result ++ (concat . replicate numberOfDigits) roman
    numberOfDigits = fromInteger remaining `div` arabic

translationMap :: [(Int, String)]
translationMap = [
  (1, "I"),
  (4, "IV"),
  (5, "V"),
  (9, "IX"),
  (10, "X"),
  (40, "XL"),
  (50, "L"),
  (90, "XC"),
  (100, "C"),
  (400, "CD"),
  (500, "D"),
  (900, "CM"),
  (1000, "M")
  ]