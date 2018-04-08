module Roman (numerals) where

numerals :: Integer -> Maybe String
numerals 1 = Just "I"
numerals 2 = Just "II"
numerals 3 = Just "III"
